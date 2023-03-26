
<div align=center>
<a href="https://www.python.org">
<img src="https://img.shields.io/badge/python-3.7-informational">
</a>
<a href="https://opensource.org/licenses/MIT">
<img alt="APM" src="https://img.shields.io/apm/l/vim-mode">
</a>
</div>      
      
# Introduction 💡 
Best fit is a memory management algorithm. Its operation consists of allocating the block in the smallest space that is big enough in that block. This algorithm is a little slow as it has to make several comparisons, but it prevents many errors. 

# About 📘
The project was created to simulate best fit algorithm. This is just for demonstration, it's an easy and visually implementation. If you want to see a real implementation you can take a look at [Tutorials Point](https://www.tutorialspoint.com/cplusplus-program-for-best-fit-algorithm-in-memory-management).

Some important things:
-  Memory is represented by a list of 100 elements
- -1 represents a free space in memory;
- Other number represents the process's id
- Each process can be created with random sizes
- The program creates always two process and after choose a random process to erase
- When a process is allocated, the program do some verifications to allocate in the best place

# Objetives 📋

> Demonstrate how best fit algorithm works

# How Works 👨‍🏫

1. First we create some variables
```python
  memory = [-1] * 100
  current_processes = []
  config = []
  id = 0
  loops_remaining_before_remove = 2
```

2. After that, we create a while loop, that will try to create and allocate the process. If the process can't be allocated (because memory is full), it return None and finish the while loop
```python
def try_allocate(memory, next_process_block_size):
  best_fit_index = len(memory)+1 
  has_free_space = False
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
    return None

    
while config!=None:
  next_process_block_size = randint(1,5)
  config = try_allocate(memory, next_process_block_size)
```

# Run Locally 📂
- You need to install [Python 3](https://www.python.org/downloads) to run the program.

- Do a git clone

      git clone https://github.com/ofelipescherer/algorithm-best-fit.git

- After you can run `paging.py`

# Reference Material 📚
[Tutorials Point](https://www.tutorialspoint.com/cplusplus-program-for-best-fit-algorithm-in-memory-management)

# Legal Informations 👩‍⚖️

- The project is [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
- You can fork and use as you want
- I would appreciate if you put my name and the link to this repository
