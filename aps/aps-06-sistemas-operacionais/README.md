<a name="readme-top"></a>

<div align="center">

[![MIT License][license-shield]][license-url]

  <br />
  <a href="https://github.com/ofelipescherer/college-projects">
    <img src="https://user-images.githubusercontent.com/62115215/218600027-5eda2e8c-b177-437b-86e4-2003c5ef6eef.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">APS 6</h3>

<p align="center">

APS 6 project

<br />
<a href="https://github.com/ofelipescherer/college-projects"><strong>Explore the docs »</strong></a>
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

## 🏬 About 🏬

APS is a semester activity requested by my faculty. Each semester there is a subject that is chosen by the grade and we have to do a work/project related to it.

In the sixth semester we focused on Linux plattform, so the APS project- A simulation about food orders.

Objectives of this simulation:

- Virtual machines (“Cashier”, “Server” and “Administrator”) connected in a network;
- Generate random commands in the “cashier” machine during a pre-selected period at (12h-15h);
- Make a daily backup of the generated commands and take them to the server at (15h00-15h10);
- Make a report on the server based on the newly command files transferred at the end of working hours at (15h15);
- Make a copy of the report file to the administrator machine at (15h20-15h25);
- To send files between virtual machines a folder will be made shared, where all virtual machines will have access;
- The cashier machine must not be able to communicate with the administrator machine (Blocked via Firewall);
- Configure each machine's proxy based on its role;

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲Built With🐲********************** -->

<a name="stack"></a>

## 💻 Built With 💻

<div align="center">

[![Linux][linux]][linux-url]

</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲Getting Started🐲********************** -->

<a name="install"></a>

## 🚂 Getting Started 🚂

To get this project up and running locally on your pc, follow the steps:

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/ofelipescherer/college-projects.git
   ```
2. Go the APS 6 files
   ```sh
   cd aps/aps-06-sistemas-operacionais/
   ```
3. To run this project locally first you will need to install 3 virtual machines or use 3 computers with linux and put the folders in theirs respectives machines.

4. To configure Firewall  
   Used Technlogy: iptables;  
   Example to block an ip: `sudo iptables -I <package arrival rule> -s <ip> -j <rule of what to do with the package>`  
   Example to block a port: `sudo iptables -A <package arrival rule> -p tcp --dport <porta> -j <rule of what to do with the package>`

5. To configure Proxy
   Used Technlogy: [Squid](http://www.squid-cache.org)  
   Install Squid: `sudo apt install squid`  
   Configure: `sudo vim /etc/squid/squid.conf`  
   Paste this in the configure file:

```
   include /etc/squid/conf.d/*
   acl localnet src <YOUR IPV4>
   acl blocksite dstdomain "/etc/squid/blocksite"
   http_access deny blocksite
   http_access allow localnet
```

Block sites: `sudo vim /etc/squid/keyword_block`

6. To configure routines  
   Used Technlogy: Crontab  
   How to configure crontab: `sudo crontab -e`  
   Paste your line of choice, crotab's sintaxe is the following: `<minute> <hour> <day of month> <month> <day of week> <user> <script location>`  
   To help find your command, you can use [Crontab Guru](https://crontab.guru/#*_16_1-_*_*)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲How to use🐲********************** -->

<a name="usage"></a>

## 🙋 How to use 🙋

Project has been made for automation Linux systeam, so there are some bash scripts that can be automated using crontab for example.

![Project](https://user-images.githubusercontent.com/62115215/218895463-8f3e54ea-268f-4c6b-90a5-f118070eb61e.png)

![Project](https://user-images.githubusercontent.com/62115215/218895477-5997cd3a-5579-4df1-83ee-b09ad3ca738d.png)

![Project](https://user-images.githubusercontent.com/62115215/218895481-f9ad1b7a-163f-4286-9bbd-1cc0f1594993.png)

![Project](https://user-images.githubusercontent.com/62115215/218895483-0de5eff9-0f3a-4dce-809b-abc3351e112c.png)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲Info🐲********************** -->

<a name="info"></a>

## :information_source: Info :information_source:

Don't forget to leave a star if you like the project ✨

<div align="center">

[![MIT License][license-shield]][license-url]
[![How to contribute][info-contribute-shield]][info-contribute-url]
[![Create an issue][info-issues-shield]][info-issues-url]

</div>

<!-- **********************🐲Contact Me🐲********************** -->

<a name="contact"></a>

## 💬 Contact me 💬

My name is Felipe Scherer and you can find me at:

<div align="center">

[![Youtube][youtube-shield]][youtube-url]
[![Linkedin][linkedin-shield]][linkedin-url]
[![Github][github-shield]][github-url]

</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- **********************🐲Contributors🐲********************** -->

<a name="contributors"></a>

## 🤗 Contributors 🤗

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/ofelipescherer">
        <img src="https://avatars.githubusercontent.com/u/62115215" width="100px;" alt="Felipe Scherer Picture"/><br>
        <sub>
          <b>Felipe Scherer</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/viniGuidi">
        <img src="https://avatars.githubusercontent.com/viniGuidi" width="100px;"  alt="Vinicius Guidi Picture"/><br>
        <sub>
          <b>Vinicius Guidi</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Luxyz">
        <img src="https://avatars.githubusercontent.com/Luxyz" width="100px;" alt="Jehan Dias Picture"/><br>
        <sub>
          <b>Jehan Dias</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/kellydena">
        <img src="https://avatars.githubusercontent.com/kellydena" width="100px;"  alt="Kelly Dena Picture"/><br>
        <sub>
          <b>Kelly Dena</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->

[contributors-shield]: https://img.shields.io/github/contributors/ofelipescherer/college-projects.svg?style=for-the-badge
[contributors-url]: https://github.com/ofelipescherer/college-projects/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/ofelipescherer/college-projects.svg?style=for-the-badge
[forks-url]: https://github.com/ofelipescherer/college-projects/network/members
[stars-shield]: https://img.shields.io/github/stars/ofelipescherer/college-projects.svg?style=for-the-badge
[stars-url]: https://github.com/ofelipescherer/college-projects/stargazers
[issues-shield]: https://img.shields.io/github/issues/ofelipescherer/college-projects.svg?style=for-the-badge
[issues-url]: https://github.com/ofelipescherer/college-projects/issues
[license-shield]: https://img.shields.io/github/license/ofelipescherer/college-projects.svg?style=for-the-badge
[license-url]: https://github.com/ofelipescherer/college-projects/blob/master/LICENSE.md
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=0E76A8
[linkedin-url]: https://www.linkedin.com/in/ofelipescherer
[youtube-shield]: https://img.shields.io/badge/YouTube-FF0000?style=for-the-badge&logo=youtube&logoColor=white
[youtube-url]: https://www.youtube.com/channel/UCySqmz_Rohnl53VLoNQsnKg
[github-shield]: https://img.shields.io/badge/Github-000000?style=for-the-badge&logo=github&logoColor=white
[github-url]: https://github.com/ofelipescherer
[linux]: https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black
[linux-url]: https://ubuntu.com
[info-contribute-shield]: https://img.shields.io/badge/👋-How%20to%20contribute-blue.svg?style=for-the-badge
[info-contribute-url]: https://github.com/ofelipescherer/utils/blob/main/CONTRIBUTING.md
[info-issues-shield]: https://img.shields.io/badge/🐞-How%20to%20create%20an%20issue-blue.svg?style=for-the-badge
[info-issues-url]: https://github.com/ofelipescherer/utils/blob/main/ISSUE.md
