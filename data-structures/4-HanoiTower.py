def move_torre(n,origem, aux, destino):
    if n == 1:
        disco(origem, destino)
    else:
        move_torre(n-1,origem,destino, aux)
        disco(origem, destino)
        move_torre(n-1,aux,origem, destino)
        

def disco(fp,tp):
    print("Movendo o disco de", fp, "para", tp)

move_torre(4,"A","B","C")