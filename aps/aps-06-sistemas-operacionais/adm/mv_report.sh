#!/bin/bash

DATE=$(date '+%d_%m_%Y');

NAME=$"/media/sf_shared-folder/relatorio_${DATE}.txt"

mkdir $NAME

mv $NAME /home/adm-youfood/Youfood/relatorios/

