
import numpy as np
import matplotlib.image as im
import matplotlib.pyplot as plt
from pathlib import Path
import os

"""-------------------------Funcoes---------------------------------"""

# Funcao que transforma a imagem em uma matriz numpy
def transform_matrix(file: str, png: bool) -> np.array:
    matrix_8bit = im.imread(file)
    if(png):
        matrix_8bit *= 255
    matrix_8bit = matrix_8bit.astype(np.uint16)
    return matrix_8bit


# Funcao que transforma a imagem em escala de cinza
def image_to_gray(matrix: np.array) -> np.array:
    linhas = matrix.shape[0]
    colunas = matrix.shape[1]

    matrix_gray = np.zeros((linhas, colunas))

    for i in range(linhas):
        for j in range(colunas):
            r, g, b = matrix[i, j]
            matrix_gray[i, j] = int((r + g + b) / 3)
    return matrix_gray

# Funcao que transforma a imagem png em escala de cinza
def image_to_gray_alpha(matrix: np.array) -> np.array:
    linhas = matrix.shape[0]
    colunas = matrix.shape[1]
    colors = matrix.shape[2]

    matrix_gray = np.zeros((linhas, colunas))

    for i in range(linhas):
        for j in range(colunas):
            for k in range(colors):
                r, g, b, a = matrix[i, j]
                matrix_gray[i, j] = int((r + g + b + a) / 4)
    return matrix_gray


"""-------------------------Programa---------------------------------"""

# Configurando o caminho da imagem a ser binarizada
file = os.path.join('.', 'images', 'splash.jpg')

# Salvando a extencao da imagem para fazer uma tratativa futura
file_name, file_extension = os.path.splitext(file)

# Transformando a imagem em escala de cinza
if(file_extension == '.png'):
    matrix_colored = transform_matrix(file, True)
    matrix_gray = image_to_gray_alpha(matrix_colored)
else:
    matrix_colored = transform_matrix(file, False)
    matrix_gray = image_to_gray(matrix_colored)

# Gerando o histograma da imagem
histogram = np.zeros(256).astype(int)
row = matrix_gray.shape[0]
column = matrix_gray.shape[1]

# Populando o histograma
for i in range(row):
    for j in range(column):
        color = matrix_gray[i, j]
        color = int(color)
        histogram[color] = histogram[color] + 1


# Agora precisaremos calcular o valor de thresholding, o linear na hora da limiarizacao
# Valores acima do thresholding se tornaram brancos (255,255,255) e valores abaixo se tornaram pretos (0,0,0)
# Para isso, não existe uma maneira universa, mas sim, diversas que podem se adaptar a diferentes imagens

# Abaixo a técnica escolhida e que foi testada nas imagens disponibilizadas na pasta ./images
# Eh baseada em achar o maior valor no histograma (sera a cor de plano de fundo)
# Em seguida, iremos pegar uma margem de erro de 10% para:
# - Esquerda (se o plano de fundo for preto; index = 255)
# - Direita (se o plano de fundo for branco; index = 0)
greater_index = 0
greater_value = 0
for index, value in enumerate(histogram):
    if(value > greater_value):
        greater_value = value
        greater_index = index

# Calculando o threshold baseado na cor do plano de fundo
if(greater_index < 150):
    threshold = greater_index + (len(histogram) * 1/10)
else:
    threshold = greater_index - (len(histogram) * 1/10)

# Criando a imagem binarizada
matrix_threshold = np.zeros((row, column))
for i in range(row):
    for j in range(column):
        cor = matrix_gray[i, j]
        if cor < threshold:
            matrix_threshold[i, j] = 0
        else:
            matrix_threshold[i, j] = 255

# Agora Criaremos uma pasta pra enviar as imagens de relatorio
# Enviando as imagens de relatorio para a pasta "report"
Path("./report").mkdir(parents=True, exist_ok=True)
path = os.path.join('.', 'report')

plt.figure()
plt.title('Matriz colorida')
plt.imshow(matrix_colored)
plt.savefig(os.path.join(path, 'matrix_colored.png'))

plt.figure()
plt.title('Matriz em escala de cinza')
plt.imshow(matrix_gray, cmap='gray')
plt.savefig(os.path.join(path, 'matrix_gray.png'))

plt.figure()
plt.title('Gráfico do histograma')
plt.plot(range(256), histogram)
plt.savefig(os.path.join(path, 'histogram.png'))

plt.figure()
plt.title('Gráfico do histograma com threshold')
plt.plot(range(256), histogram)
plt.plot([threshold, threshold], [0, max(histogram)])
plt.savefig(os.path.join(path, 'histogram_with_threshold'))

plt.figure()
plt.title('Matriz limiarizada')
plt.imshow(matrix_threshold, cmap='gray')
plt.savefig(os.path.join(path, 'matrix_threshold.png'))
