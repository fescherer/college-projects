# Felipe Scherer 
#Algoritmos vistos em aula + 1 de minha escolha
# Algotimo Escolhido: Comb Sort

# Bubble Sort
def bubbleSort(lista):
    for j in range(len(lista)-1,0,-1):
        for i in range(j):
            if lista[i]>lista[i+1]:
                aux = lista[i]
                lista[i] = lista[i+1]
                lista[i+1] = aux

lista = [12,52,51,23,1,0,5,1]
bubbleSort(lista)
print(f"Bubble Sort: {lista}")

# Selection Sort
def selectionSort(lista):
    for i in range(len(lista)):
        menorIndice = i
        for j in range(i+1, len(lista)):
            if lista[menorIndice] > lista[j]:
                menorIndice = j 
        aux = 0
        aux = lista[menorIndice]
        lista[menorIndice] = lista[i]
        lista[i] = aux

vetor = [5,3,1,6,1,2,5,2,10]
selectionSort(vetor)
print(f"Selection Sort: {vetor}")

# Insertion Sort
def insertionSort(lista):
    for i in range(1,len(lista)):
        aux = lista[i]
        j = i - 1
        while j>=0 and aux < lista[j]:
            lista[j+1] = lista[j]
            j -= 1
        lista[j+1] = aux

vetor2 = [31, 41, 59, 26, 41, 58]
insertionSort(vetor2)
print(f"Insertion Sort: {vetor2}")

# Quick Sort
def particao(lista, menor, maior):
    pivo = lista[maior] 
    i = menor - 1 
    for j in range(menor, maior):
        if(lista[j] <= pivo):
            i += 1
            aux = lista[i]
            lista[i] = lista[j]
            lista[j] = aux
    aux = lista[maior]
    lista[maior] = lista[i + 1]
    lista[i + 1] = aux
    return (i + 1)

def quick_sort(lista, menor, maior):
    if(menor < maior):
        index_particao = particao(lista,menor,maior)
        quick_sort(lista, menor, index_particao - 1)
        quick_sort(lista, index_particao + 1, maior)

vetor3 = [8,2,42,36,42,18,59,31,4,0,82,3,58]
quick_sort(vetor3, 0, len(vetor3)-1)
print(f"Quick Sort: {vetor3}")

# Comb Sort --> Escolhido por mim
def atualiza_inc(inc):
    inc = inc / 1.3 #--> 1.3 foi um fator decidido cientificamente 
    if(inc <= 1):
        return 1
    else:
        return int(inc)  

def comb_sort(lista):
    inc = len(lista)
    troca = True

    while(not inc == 1 or troca == True):
        inc = atualiza_inc(inc)
        troca = False
        for i in range(0, len(lista) - inc):
            if(lista[i] > lista[i + inc]):
                aux = lista[i]
                lista[i] = lista[i+inc]
                lista[i+inc] = aux
                troca = True

vetor4 = [3,51,5,25,6,26,78,9,7,0,-1]
comb_sort(vetor4)
print(f"Combo Sort: {vetor4}")