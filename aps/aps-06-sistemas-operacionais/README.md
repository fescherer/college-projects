# Introduction :bulb:

Operating Systems Simulation

This project was made for operating systems class in Unip-Campinas-Brazil.

# About :blue_book:

This was supposed to be a simulation of some type of business. Here we used 3 virtual machines using linux being one the manager (Adm); one the cashier (less adm) and one server.
We had to configure firewall, proxy and routines scripts.

# Objetives :clipboard:
Objectives of this simulation:

 - Virtual machines (“Cashier”, “Server” and “Administrator”) connected in a network;
 - Generate random commands in the “cashier” machine during a pre-selected period at (12h-15h);
 - Make a daily backup of the generated commands and take them to the server at (15h00-15h10);
 - Make a report on the server based on the newly command files transferred at the end of working hours at (15h15);
 - Make a copy of the report file to the administrator machine at (15h20-15h25);
 - To send files between virtual machines a folder will be made shared, where all virtual machines will have access;
 - The cashier machine must not be able to communicate with the administrator machine (Blocked via Firewall);
 - Configure each machine's proxy based on its role;

# Run Locally :open_file_folder:
To run this project locally first you will need to install 3 virtual machines or use 3 computers with linux and put the folders in theirs respectives machines.

 - To configure Firewall  
   Used Technlogy: iptables;  
   Example to block an ip: ```sudo iptables -I <package arrival rule> -s <ip> -j <rule of what to do with the package>```   
   Example to block a port: ```sudo iptables -A <package arrival rule> -p tcp --dport <porta> -j <rule of what to do with the package>```   
   
 - To configure Proxy 
   Used Technlogy: [Squid](http://www.squid-cache.org)  
   Install Squid: ```sudo apt install squid```  
   Configure: ```sudo vim /etc/squid/squid.conf```  
   Paste this in the configure file: 
     ```
        include /etc/squid/conf.d/*
        acl localnet src <YOUR IPV4>
        acl blocksite dstdomain "/etc/squid/blocksite"
        http_access deny blocksite
        http_access allow localnet
      ```  
    Block sites: ```sudo vim /etc/squid/keyword_block```  
    
  - To configure routines  
   Used Technlogy: Crontab   
   How to configure crontab: ```sudo crontab -e```  
   Paste your line of choice, crotab's sintaxe is the following: ```<minute> <hour> <day of month> <month> <day of week> <user> <script location>```  
   To help find your command, you can use [Crontab Guru](https://crontab.guru/#*_16_1-_*_*)  
