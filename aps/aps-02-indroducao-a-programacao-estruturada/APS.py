from math import radians, sin, cos, atan2, sqrt, degrees #Importa uma biblioteca para facilitar as contas de seno, cosseno, raiz quadrada, entre outros

pontosPlastico = [[-22.948552 , -47.057825 , 'Ecoponto Vila Campos Sales'] , [-22.936008 , -47.118342 , 'Ecoponto Vila União'] , [-22.924515 , -47.144453 , 'Cooperativa Tatuapé'] , [-22.895924 , -47.156212 , 'Ecoponto Parque São Jorge'] , [-22.891912 , -47.101192 , 'Ecoponto Jardim Eulina']]

ruasPlastico = ['Av. São José dos Campos, 2255 - Jardim Nova Europa', 'R. Manoel Gomes Ferreira, 42 - Parque Tropical', 'Estrada do Mão Branca, sem numero - Jardim São Caetano', 'R. Plácida Pretini, 196 - Parque São Jorge', '-R. Marechal Rondon,  2296 - Jardim Chapadão']


pontosPapel = [[-22.889295 , -46.979747 , 'Ecoponto Sousas'] , [-22.915155 , -47.037598 , 'Ecoponto Jardim Paranapanema'] , [-22.915674 , -47.040948 , 'Cooperativa Reciclar'] , [-22.817133 , -47.100368 , 'Ecoponto Barão Geraldo'] , [-22.891912 , -47.101192 , 'Ecoponto Jardim Eulina']]

ruasPapel = ['Av. Dona Júlia da Conceição Alves , 0 - Vila Santana', "R. Serra d'Água, 363 - Jardim São Fernando", 'R. Alaíde Nascimento de Lemos, 300 - Jardim Baronesa Campinas', 'Av. Santa Isabel, 3015 - Barão Geraldo', 'R. Marechal Rondon,  2296 - Jardim Chapadão']


pontosMetal = [[-22.889295 , -46.979747 , 'Ecoponto Sousas'],[-22.915155 , -47.037598 , 'Ecoponto Jardim Paranapanema'],[-22.942671, -47.030520 , 'Ecoponto Jardim São Gabriel'],[-22.891912, -47.101192 , 'Ecoponto Jardim Eulina'],[-22.915585, -47.071310 , 'Cooperativa São Bernardo']]

ruasMetal = ['Av. Dona Júlia da Conceição Alves , 0 - Vila Santana', "Rua Serra d'Água, 363 - Jardim São Fernando", 'R. José Martins Lourenço, 140 - Jardim São Gabriel', 'R. Marechal Rondon,  2296 - Jardim Chapadão', 'Avenida Prefeito Faria Lima, 630 - Parque Itália']


pontosVidro = [[-22.977462 , -47.177865 , 'Ecoponto Vida Nova'],[-22.915820 , -47.105793 , 'Cooperativa Santa Genebra'],[-22.942671 , -47.030520 , 'Ecoponto Jardim São Gabriel'],[-22.915585 , -47.071310 , 'Cooperativa São Bernardo'],[-22.948552 , -47.057825 , 'Ecoponto Vila Campos Sales']]

ruasVidro = ['R. Lídia Martins de Assis, 42 - Vida Nova','R. Pastor Osvaldo Alves Martins - Vila Castelo Branco','R. José Martins Lourenço, 140 - Jardim São Gabriel','Avenida Prefeito Faria Lima, 630 - Parque Itália','Avenida São José dos Campos, 2255 - Jardim Nova Europa']



latmax = -22.713898 #Latitude máxima da região
latmin = -23.067607 #Latitude mínima da região
lonmax = -46.810703 #Longitude máxima da região
lonmin = -47.252721 #Longitude mínima da região



def Validacao(minn,maxx,value): #Verifica se o valor digitado está dentro do raio da região estipulada
    if value > minn and value < maxx:
        return True
    else:
        print(f'\nVocê precisa digitar um valor entre {minn} e {maxx}')
        return False

def funcao(pontosColeta, ruasColeta):
    TryOver = False #Serve para continuar no loop até que termine a função
    menor = 600000
    latUser = lonUser = 0
    while not TryOver: #Somente sairá desse loop se TryOver for falso
        try: #Try é uma função para impedir que o programa de erro, se o usuário digitar uma letra, por exemplo, os erros entram pelo "except"
            while not Validacao(latmin, latmax, latUser): #Pede para o usuário digitar sua latitude até estar dentros dos valores mínimo e máximo
                latUser = float(input('Digite sua latitude: '))
            print('Sua latitude foi salva!')
            while not Validacao(lonmin, lonmax, lonUser): #Pede para o usuário digitar sua longitude até estar dentros dos valores mínimo e máximo
                lonUser = float(input('Digite sua longitude: '))
            print('Sua longitude foi salva!')
        except ValueError: #Caso o usuário digite algum caractere que seja diferente de números, o programa da erro
            print('\nError :(\n\nVocê precisa digitar somente números :(\n')
        except:
            print('\nAlgo inesperado aconteceu, tente novamente.\n')
        else: #Caso não ocorra nenhum erro, ele entra por esse else
            lonUser, latUser = map(radians, [lonUser, latUser]) #Transforma a latitude e longitude do usuário em radianos
            for i in range(0,len(pontosColeta)):
                j = 0
                pontosColeta[i][j], pontosColeta[i][j+1] = map(radians, [pontosColeta[i][j],pontosColeta[i][j+1]]) #Transforma a latitude e longitude dos pontos em radianos
                dlat = pontosColeta[i][j] - latUser #Distância das latitudes
                dlon = pontosColeta[i][j+1] - lonUser #Distância das longitudes
                a = sin(dlat/2)**2 + cos(latUser) * cos(pontosColeta[i][j]) * sin(dlon/2)**2
                c = 2 * atan2(sqrt(a), sqrt(1-a))
                distancia = 6371 * c
                if distancia < menor: #Ele verifica qual foi a menor distância 
                    menor = distancia
                    nome = pontosColeta[i][j+2]
                    rua = ruasColeta[i]
                pontosColeta[i][j], pontosColeta[i][j+1] = map(degrees, [pontosColeta[i][j],pontosColeta[i][j+1]]) #Volta as coordenadas para graus
            print(f'\nA menor distância é o ponto {nome} que fica na {rua} e está a {menor:.2f}Km')
            TryOver = True


def menu(funcao):
    TryOver = False
    while not TryOver:
        try:
            escolha = int(input('-> Qual é a sua opção ? '))
        except ValueError:
            print('Digite somente números')
        else:
            if escolha == 1:
                funcao(pontosPlastico, ruasPlastico)
            elif escolha == 2:
                funcao(pontosPapel, ruasPapel)
            elif escolha == 3:
                funcao(pontosMetal, ruasMetal)
            elif escolha == 4:
                funcao(pontosVidro, ruasVidro)
            elif escolha == 5:
                print('\nAguarde...')
            else:
                print('\nOpção inválida. Tente novamente.')
            TryOver = True

def Cadastro(x, y): #Função que serve para o cadastramento de pontos de coleta
    TryOver = False
    lat = lon = 0
    while not TryOver:
        try:
            while not Validacao(latmin,latmax,lat):
                lat = float(input('Digite a latitude do ponto de coleta: '))
            print("Sua latitude foi salva!")
            
            while not Validacao(lonmin,lonmax,lon):
                lon = float(input('Digite a longitude do ponto de coleta: '))
            print("Sua longitude foi salva!")
            
            nome = input('\nDigite o nome do ponto de coleta: ')
            rua = input('\nDigite o nome da rua do ponto de coleta (Seguir o padrão: "Rua número, Bairro"): ')
        except ValueError: #Caso o usuário digite algum caractere que seja diferente de números, o programa da erro
            print('\nError :(\n\nVocê precisa digitar somente números :(\n')
        else: 
            aux = [lat, lon, nome] #Vetor auxiliar, por antes de colocar na matriz principal, essas variaveis devem ser testadas para serem válidas
            x.append(aux)
            y.append(rua)
            print('Seu ponto foi cadastrado com sucesso!')
            TryOver = True

def Apagar(x, y): #Função que apaga um ponto de coleta
    if len(x) > 0: #Verifica se a quantidade de pontos é maior que 0, pois não podemos apagar sendo q não tem mais nenhum ponto cadastrado
        print('Os pontos atuais:')
        for i in range(len(x)): #Imprimi todos os pontos que estão cadastrados e um número(Index) para eles, assim o usuario pode saber qual ponto apagar
            print(f'Ponto {i+1} = {x[i]}')
        index = int(input('\nDigite o número do ponto que deseja apagar: ')) #Escolhe qual o ponto deseja apagar
        if index <= len(x):
            x.pop(index-1)
            y.pop(index-1)
            print('O ponto foi apagado com sucesso!')
        else:
            print('Não existe esse ponto, tente novamente')
    else:
        print('Você precisa ter no mínimo 1 ponto cadastrado')
    
def Imprimir(x, y):
    print('\nPontos de coleta:')
    for i in range(len(y)):
        print(f'\n{x[i][2]} - {y[i]}') 
        print(f'Coordenadas: {x[i][0]}, {x[i][1]}')   

print('Bem Vindo!')
print('/----'*15)
opcao = 0 #Defini qual a opção do menu que o usuário irá escolher
while opcao != 8:
    TryOver = False
    while not TryOver:
        try:
            print('''\nQual tipo de lixo você deseja reciclar ?
            { 1 } Plástico
            { 2 } Papel
            { 3 } Metal
            { 4 } Vidro
            { 5 } Cadastro de ponto de coleta
            { 6 } Remoção de ponto de coleta
            { 7 } Pontos cadastrados
            { 8 } Sair do programa''') 
            opcao = int(input('-> Qual é a sua opção ? '))
        except ValueError:
            print('\nError :(\n\nVocê precisa digitar somente números')
        except ValueError: 
            print('\nError :(\n\nVocê precisa digitar somente números.')
        else: 
            if opcao == 1: #Escolheu plástico
                print('\nVocê escolheu Plástico!')
                funcao(pontosPlastico, ruasPlastico)

            elif opcao == 2: #Escolheu papel
                print('\nVocê escolheu Papel!')
                funcao(pontosPapel, ruasPapel)

            elif opcao == 3: #Escolheu Metal
                print('\nVocê escolheu Metal!')
                funcao(pontosMetal, ruasMetal)

            elif opcao == 4: #Escolheu vidro
                print('\nVocê escolheu vidro!')
                funcao(pontosVidro, ruasVidro)
            
            elif opcao == 5: #Cadastramento de pontos
                print('\nVocê escolheu cadastrar um ponto!')
                print('\nQual tipo de lixo do ponto que você deseja cadastrar?\n{ 1 } Plástico\n{ 2 } Papel\n{ 3 } Metal\n{ 4 } Vidro\n{ 5 } Sair')
                menu(Cadastro)

            elif opcao == 6:
                print('\nQual tipo de lixo do ponto que você deseja apagar?\n{ 1 } Plástico\n{ 2 } Papel\n{ 3 } Metal\n{ 4 } Vidro\n{ 5 } Sair')
                menu(Apagar)

            elif opcao == 7:
                print('\nQual tipo de ponto que deseja vizualizar??\n{ 1 } Plástico\n{ 2 } Papel\n{ 3 } Metal\n{ 4 } Vidro\n{ 5 } Sair')
                menu(Imprimir)

            elif opcao == 8:
                print('\nAguarde...')
                TryOver = True #Sai do try

            else:
                print('Opção inválida. Tente novamente.')
                
            print('/----'*15)
exitt = input('Fim do programa!') #Variavel que segura o programa aberto até o usuário querer fecha-lo