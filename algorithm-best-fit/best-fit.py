#Best fit algoritm
#-1 é um espaço livre na memória

from random import randint, choice

def allocate(start_index, id, times, memory):
  for i in range(start_index, start_index+times):
    memory[i] = id
  
def try_allocate(memory, next_process_block_size):
  best_fit_index = len(memory)+1 #Precisa iniciar maior que o comprimento da memória
  has_free_space = False
  #Verifica os espaços livres e retorna qual o melhor espaço para alocar
  for index, block  in enumerate(memory):
    if(block==-1):
      counter = 0
      for a in range(index, len(memory)):
        if(memory[a]== -1):
          counter += 1
        else:
          break
      if(counter >= next_process_block_size):
        if(counter <=  best_fit_index):
          best_fit_index = index
          has_free_space = True
          break

  if(has_free_space):
    return [best_fit_index, next_process_block_size]
  else:
    return None #Se retornar isso, significa que não tem mais espaço na lista

def free_memory(current_processes, memory, id_to_be_removed):
  current_processes.remove(id_to_be_removed)
  for index, value in enumerate(memory):
    if(value==id_to_be_removed):
      memory[index] = -1

def program():
  memory = [-1] * 100
  current_processes = []
  config = []
  id = 0
  loops_remaining_before_remove = 2

  while config!=None:
    next_process_block_size = randint(1,5)
    config = try_allocate(memory, next_process_block_size)
    print(f'Tentando alocar {next_process_block_size} blocos')
    if(config!=None):
      print(f'Alocando {next_process_block_size} blocos com id {id}')
      allocate(config[0],id, config[1], memory)
      print(f'Memória:\n{memory}\n')
      current_processes.append(id)
      loops_remaining_before_remove-=1
      id+=1
    if(loops_remaining_before_remove==0):
      id_to_be_removed = choice(current_processes)
      print(f'Removendo blocos com id {id_to_be_removed}')
      free_memory(current_processes, memory, id_to_be_removed)
      print(f'Memória:\n{memory}\n')
      loops_remaining_before_remove=2
  print('\nEstado final da memória:')
  print(memory)

program()

input("\nAperte enter para finalizar...")