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

<h3 align="center">APS 4</h3>

<p align="center">

APS 4 project

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

APS is a semester activity requested by my faculty. Each semester there is a subject that is chosen by the grade and we have to do a work/project related to it.

In the forth semester. We learned about user interfaces using Java awt and swing to make really simple interfaces. On top of that, we were starting to use SQL language, so the project for this APS need to have both User interface using Java Swing and awt and a database Postgress or mySQL.

The project is a library managment application. You can manage the authors, books and publishers.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲Built With🐲********************** -->

<a name="stack"></a>

## 💻 Built With 💻

<div align="center">

[![Java][java]][java-url]
[![MySQL][mysql]][mysql-url]

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
2. Go the APS 4 files
   ```sh
   cd aps/aps-04-aplicacao-orientacao-a-objetos/
   ```
3. Open the project on Eclipse or other IDE that has support for Java

4. If you want to run the database, you need to install mySQL too. We used WAMP, but you can use other tecnology to open the database.

5. _**Make sure to change the database access in file db.properties in src folder**_

Database structure:

```mysql
CREATE TABLE Authors (
  author_id INT(8) AUTO_INCREMENT PRIMARY KEY,
  name CHAR(25) NOT NULL,
  fname CHAR(25) NOT NULL
);

CREATE TABLE Publishers (
  publisher_id INT(8) AUTO_INCREMENT PRIMARY KEY,
  name CHAR(30) NOT NULL,
  url CHAR(80) NOT NULL
);

CREATE TABLE Books (
  title CHAR(60) NOT NULL,
  isbn CHAR(13) PRIMARY KEY,
  publisher_id INT NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (publisher_id) REFERENCES Publishers (publisher_id)
);

CREATE TABLE BooksAuthors (
  isbn CHAR(13) NOT NULL,
  author_id INT NOT NULL,
  seq_no INT NOT NULL,
  FOREIGN KEY (isbn) REFERENCES Books (isbn),
  FOREIGN KEY (author_id) REFERENCES Authors (author_id),
  PRIMARY KEY (isbn, author_id)
);
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲How to use🐲********************** -->

<a name="usage"></a>

## 🙋 How to use 🙋

As a managment app, you can edit, delete and add new publishers, books or authors.

![Project image initial screen](https://user-images.githubusercontent.com/62115215/218890436-6570d175-62b3-4cb7-954c-0bec17a653c1.png)
![Project image search screen](https://user-images.githubusercontent.com/62115215/218890438-819cf6c7-f448-4c4d-80ed-4cfe716d1376.png)
![Project image list screen](https://user-images.githubusercontent.com/62115215/218890440-3e16b71c-908c-4bae-8768-3ed842065a23.png)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

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
        <td align="center">
      <a href="https://github.com/viniGuidi">
        <img src="https://github.com/viniGuidi.png" width="100px;"  alt="Vinicius Guidi Picture"/><br>
        <sub>
          <b>Vinicius Guidi</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Luxyz">
        <img src="https://github.com/Luxyz.png" width="100px;" alt="Jehan Dias Picture"/><br>
        <sub>
          <b>Jehan Dias</b>
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
[java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white
[java-url]: https://www.java.com
[mysql]: https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white
[mysql-url]: https://www.mysql.com