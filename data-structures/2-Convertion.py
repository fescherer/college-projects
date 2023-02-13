def fazConta(operador, fila):
    if(operador == "+"):
        return fila[-2] + fila[-1]
    elif(operador == "-"):
        return fila[-2] - fila[-1]
    elif(operador == "/"):
        return fila[-2] / fila[-1]
    elif(operador == "*"):
        return fila[-2] * fila[-1]
    

def calcular(equacao):
    pilha = []
    fila = []

    for x in equacao:
        if(x == "("):
            #ignora
            continue
        elif(x == ")"):
            #copia o ultimo operador acessado
            fila[-2] = fazConta(pilha[0], fila)
            del pilha[0]
            del fila[-1]

        elif(x == "+" or x == "-" or x == "/" or x == "*"):
            #aguardar
            pilha.insert(0,x)
        else:
            #copiar para expressao
            x = int(x)
            fila.append(x)

    return fila[0]

print(calcular("((4+(2*2))-1)")) #RESULTADO 7