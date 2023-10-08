<a name="readme-top"></a>

<div align="center">

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

  <br />
  <a href="https://github.com/fescherer/college-projects">
    <img src="https://user-images.githubusercontent.com/62115215/218600027-5eda2e8c-b177-437b-86e4-2003c5ef6eef.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Simulation of Algorithm Best Fit</h3>

<p align="center">

Simulation of Algorithm Best Fit Project

<br />
<a href="https://github.com/fescherer/college-projects"><strong>Explore the docs »</strong></a>
<br />
<br />
<a href="#about">About</a>
•
<a href="#stack">Build With</a>
•
<a href="#install">Getting Started</a>
•
<a href="#usage">How to use</a>
•
<a href="#info">Info</a>
•
<a href="#contact">Contact me</a>
•
<a href="#contributors">Contributors</a>

</p>
</div>

<!-- **********************🐲About🐲********************** -->

<a name="about"></a>

## 📕 About 📕

Best fit is a memory management algorithm. Its operation consists of allocating the block in the smallest space that is big enough in that block. This algorithm is a little slow as it has to make several comparisons, but it prevents many errors. 

The project was created to simulate best fit algorithm. This is just for demonstration, it's an easy and visually implementation. If you want to see a real implementation you can take a look at [Tutorials Point](https://www.tutorialspoint.com/cplusplus-program-for-best-fit-algorithm-in-memory-management).

Some important things:
-  Memory is represented by a list of 100 elements
- -1 represents a free space in memory;
- Other number represents the process's id
- Each process can be created with random sizes
- The program creates always two process and after choose a random process to erase
- When a process is allocated, the program do some verifications to allocate in the best place

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲Built With🐲********************** -->

<a name="stack"></a>

## 💻 Built With 💻

<div align="center">

[![Python][python]][python-url]

</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲Getting Started🐲********************** -->

<a name="install"></a>

## 🚂 Getting Started 🚂

To get this project up and running locally on your pc, follow the steps:

### Installation

1. Clone the repo
  ```sh
   git clone https://github.com/fescherer/college-projects.git
  ```
2. Go the Simulation of Algorithm Best Fit
  ```sh
   cd algorithm-best-fit
  ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲How to use🐲********************** -->

<a name="usage"></a>

## 🙋 How to use 🙋

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

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## References

[Tutorials Point](https://www.tutorialspoint.com/cplusplus-program-for-best-fit-algorithm-in-memory-management)

<!-- **********************🐲Info🐲********************** -->

<a name="info"></a>

## 🌎 Info 🌎

Don't forget to leave a star if you like the project ✨

<div align="center">

[![MIT License][license-shield]][license-url]
[![How to contribute][info-contribute-shield]][info-contribute-url]
[![Create an issue][info-issues-shield]][info-issues-url]

</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲Contact Me🐲********************** -->
<a name="contact"></a>

## 💬 Contact me 💬

My name is Felipe Scherer. You can find my socials at [my Github profile](https://github.com/fescherer) 😸

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲Contributors🐲********************** -->

<a name="contributors"></a>

## 🤗 Contributors 🤗

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/fescherer">
        <img src="https://github.com/fescherer.png" width="100px;" alt="Felipe Scherer Picture"/><br>
        <sub>
          <b>Felipe Scherer</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- Badges and Badges Link -->
[contributors-shield]: https://img.shields.io/github/contributors/fescherer/college-projects.svg?style=for-the-badge
[contributors-url]: https://github.com/fescherer/college-projects/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/fescherer/college-projects.svg?style=for-the-badge
[forks-url]: https://github.com/fescherer/college-projects/network/members
[stars-shield]: https://img.shields.io/github/stars/fescherer/college-projects.svg?style=for-the-badge
[stars-url]: https://github.com/fescherer/college-projects/stargazers
[issues-shield]: https://img.shields.io/github/issues/fescherer/college-projects.svg?style=for-the-badge
[issues-url]: https://github.com/fescherer/college-projects/issues

[license-shield]: https://img.shields.io/github/license/fescherer/college-projects.svg?style=for-the-badge
[license-url]: https://github.com/fescherer/college-projects/blob/master/LICENSE
[info-contribute-shield]: https://img.shields.io/badge/👋-How%20to%20contribute-blue.svg?style=for-the-badge
[info-contribute-url]: https://github.com/fescherer/utils/blob/main/CONTRIBUTING.md
[info-issues-shield]: https://img.shields.io/badge/🐞-How%20to%20create%20an%20issue-blue.svg?style=for-the-badge
[info-issues-url]: https://github.com/fescherer/utils/blob/main/ISSUE.md

<!-- https://github.com/Ileriayo/markdown-badges -->
[python]: https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white
[python-url]: https://www.python.org

