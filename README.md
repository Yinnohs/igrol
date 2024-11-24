 
# Table of Content
- [Table of Content](#table-of-content)
- [Igrol Backend](#igrol-backend)
  - [Technologies used](#technologies-used)
  - [Installation](#installation)
    - [1. Clone /download the repository](#1-clone-download-the-repository)
    - [2. Download the maven dependecies and install them in the project](#2-download-the-maven-dependecies-and-install-them-in-the-project)
    - [3. Run the project](#3-run-the-project)
  - [How To Use](#how-to-use)
    - [- Register new user](#--register-new-user)
    - [- Login User](#--login-user)

# Igrol Backend
This s a backend done for igrol applciation  - igrol is a real time shopping list app to use with your family and friends.


## Technologies used

Java 17
Spring boot 3.3.5
Junit 5
Arch unit 1.3.0 


## Installation

### 1. Clone /download the repository
I recommend use git to clone the repository

```
git clone https://github.com/Yinnohs/igrol.git
```

### 2. Download the maven dependecies and install them in the project
Yes! this java- springboot and i use maven for the dependecy management but dont feel afraid to change it to gradel or another package manager.

Any who this is the command you need to run if your not using eclispse / vscode or intellij idea to open the application.

```
mvn dependecy clean install
```

if you are using some of the IDE listed above or any other IDE with support for maven you can try to find the corresponded way to download dependecies / sync the mave project.

### 3. Run the project

1. Make sure you hace docker installed on the machine (or podman) if not [click here](https://docs.docker.com/engine/install/) to go to the docker documentation

2. Run the next command bring up an instance of mongodb (used in the project)(Make sure to isntall docker compose too)
```
docker-compose up
```  
3. Run the maven project
By command
```
mvn spring-boot:run
```
4. Clarifications
The project runs on port 5052 by thefault you can change that on the file located on:
```
\src\main\resources #WINDOWS
/src\main/resources #LINUX / MAC
```

With others IDEs its easier to bring up a maven project but for the sake of leaving this README short i will not deep dive into it.

## How To Use
RN is a work in progress but you can create some regiser a login request using any HTTP testing suit like postman or insomnia

### - Register new user
Create a POST request to:
```
http://localhost:5052/api/v1/auth/register
```

with the next json payload 
```
{
  "name": "John",
  "surname": "Doe",
  "email": "john.doe@example.com",
  "address": "123 Elm Street, Springfield, USA",
  "phoneNumber": "+1-555-1234",
  "password": "securePassword123"
}

{
  "name": "string",
  "surname": "string",
  "email": "string",
  "address": "string",
  "phoneNumber": "string",
  "password": "string"
}
```

Expected response:

```
{
  "id":"6f5ce023-3c07-4029-82f0-4cec6473f899" 
  "name": "John",
  "surname": "Doe",
  "email": "john.doe@example.com",
  "address": "123 Elm Street, Springfield, USA",
  "phoneNumber": "+1-555-1234",
}

{
  "id": "uuid string"
  "name": "string",
  "surname": "string",
  "email": "string",
  "address": "string",
  "phoneNumber": "string"
}
```

### - Login User
Create a POST request to:
```
http://localhost:5052/api/v1/auth/login
```

With the nex payload (for this endpoint to work you shoulf first insert a user to the database with the steps above)

```
{
  "email": "john.doe@example.com",
  "password": "securePassword123"
}


{
  "email": "string",
  "password": "string"
}
```

the expected response is the next:

```
{
  "token": "session token",
  "user": "User like the response of the previos endpoint explanation"  
}


{
  token: "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNzMyNDg5NzU5LCJleHAiOjE3MzI0OTMzNTl9.5KDf61HZ-JtL1Li3dp1VsHKPiH_DqETejtxjcpFMDCs",

  user: {
    "id":"6f5ce023-3c07-4029-82f0-4cec6473f899" 
    "name": "John",
    "surname": "Doe",
    "email": "john.doe@example.com",
    "address": "123 Elm Street, Springfield, USA",
    "phoneNumber": "+1-555-1234",
  }
}
```

Made with 💛 by Yinnohs.