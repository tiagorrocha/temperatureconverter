# Temperature Converter

Temperature Converter is an application that converts degrees celsius to fahrenheit and vice versa.

## Setup
+ **Prerequisites:**
   + MySQL
   + Git

Clone repository:

```bash
git clone https://github.com/tiagorrocha/temperatureconverter.git
```
For database, create schema MySql.
```bash
mysql -u root -p
create database temperatureconverter_db;
```
In this project, the credentials for database are:

##### *user*: root and *password*: root

## Command-line instructions
+ **Prerequisites:**
   + Install Java version 1.8 and Maven 3.6.

#### Run project
##### With migrations:
```bash
cd temperatureconverter
mvn spring-boot:run
```
##### No migrations:
##### Changes in "application.properties" 
``` txt
spring.liquibase.enabled=false
```
Run:
```bash
mvn spring-boot:run
```
##### Run tests:
```bash
mvn test
```
#####  Generate a Changelog from Database:
```bash
mvn liquibase:generateChangeLog
```

## Eclipse instructions
+ **Prerequisites:**
   + Install Eclipse and the Maven plugin.
+ Import **temperatureconverter** project:
   + Click on File > Import > Maven > Existing Maven Projects > Next > Browse >
      + Go to  project directory, select the folder and click in Ok.

##### Run project:
+ Right-click on project
+ Run as > Java Application

##### Run tests:
+ Right-click on project
+ Run as > Junit Test