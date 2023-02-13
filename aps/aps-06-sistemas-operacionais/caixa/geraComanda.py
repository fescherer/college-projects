#!/usr/bin/env python3

import os
from datetime import datetime
from produtos import produtos
from clientes import clientes
from random import randint


def gera_comanda():
    # Pega valores de hora e minuto e cria um arquivo txt
    now = datetime.now()
    file_name = now.strftime("%H_%M")
    file = os.path.join('.', 'comandas', f'comanda_{file_name}.txt')
    f = open(file, "w+")

    # Comeca a escrever o relatorio com a data e hora atual
    f.write('Resumo da comanda\n')
    f.write(
        f'Hora: {now.strftime("%H:%M")}\nData: {now.strftime("%d/%m/%Y")}\n')
    f.write(f'Cliente {clientes[randint(0,len(clientes)-1)]}\n\n')

    # Variaveis que serao usadas e a quantidade de produtos que sera selecionado
    qnt = randint(1, 4)
    prod_list = []
    prod_id = []

    # Escolhendo produtos aleatorios da lista do arquivo produtos.py
    for i in range(qnt):
        prod = randint(0, len(produtos)-1)
        prod_list.append(
            produtos[prod])
        prod_id.append(prod)

    # Escrevendo os ids dos produtos selecionados
    f.write('Ids produtos:\n')
    for i in prod_id:
        f.write(f'{i} '),

    # Terminando a comanda listando os produtos com detalhes
    f.write('\n\n')
    f.write('Relatorio\n\n')
    f.write('Produtos\n')
    for i in prod_list:
        f.write(f'Id: {i.get("id")}\n')
        f.write(f'Nome: {i.get("name")}\n')
        f.write(f'Preco: {i.get("price")}\n\n')
    f.close()


# Gera uma comanda se o valor do randint for igual 1
# Isso permite que a simulacao nao fique linear
if(randint(0, 1) == 1):
    gera_comanda()
