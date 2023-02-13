'''Exemplo da aula. Fazer um programa que recursivo que imprimi a quantidade de potência de 2 passadas
Por exemplo. funcao(4) = 2, 4, 8, 16'''


def potencia_de_2(numero):

    if(numero == 0):
        return 
    else:
        print(2 ** numero)
        numero = numero - 1
        potencia_de_2(numero)

potencia_de_2(3)