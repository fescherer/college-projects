#!/bin/bash

DATE=$(date '+%d_%m_%Y');

NAME=$"/home/servidor/Youfood/relatorios/relatorio_${DATE}.txt"

mkdir $NAME

cp $NAME /media/sf_shared-folder/


