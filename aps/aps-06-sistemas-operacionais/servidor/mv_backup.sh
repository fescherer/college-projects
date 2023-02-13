#!/bin/bash

DATE=$(date '+%d_%m_%Y');

NAME=$"/media/sf_shared-folder/backup_${DATE}"

mkdir $NAME

mv $NAME /home/servidor/Youfood/backup/


