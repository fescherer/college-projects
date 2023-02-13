def converter(equacao):
    pilha = []
    saida = ""

    for x in equacao:
        if(x == "("):
            #ignora
            continue
        elif(x == ")"):
            #copia o ultimo operador acessado
            saida += pilha[0]
            del pilha[0]

        elif(x == "+" or x == "-" or x == "/" or x == "*"):
            #aguardar
            pilha.insert(0,x)
        else:
            #copiar para expressao
            saida += x

    return saida

print(converter("((A+(B*C))-D)")) #RESULTADO ABC*+D-




'''
def converter(equacao):
    pilha = []
    saida = ""
    
    for x in equacao:
        if(x == "("):
            #ignora
            continue
        elif(x == ")"):
            #copia o ultimo operador acessado para a saida e exclui da pilha
            saida += pilha[0]
            del pilha[0]
    
        elif(x == "+" or x == "-" or x == "/" or x == "*"):
            #guarda o operador na pilha
            pilha.insert(0,x)
        else:
            #copia o operando para a saida
            saida += x
    
    return saida



print(converter("((A+(B*C))-D)")) #RESULTADO -+A*BCD  ''' 