# Spring-JPA-PostgreSQL-Docker-Compose

## Here are the docker images for [SPRING](https://hub.docker.com/repository/docker/pro1zero/spring) and [POSTGRES](https://hub.docker.com/repository/docker/pro1zero/postgres)

At the moment, I'm still dealing with some platform related issues (Mac M1 -> LINUX - amd/64) but, you can still test this code up by following the below steps:

## docker-compose 'up'

1. Download both the images, and the source code on your local machine. 
2. Start your docker desktop and navigate all the way to docker-compose.yml. 
3. Open console in current window and run this command  ```docker-compose up --build```. This will start the program flow. (Make sure your docker desktop is turned on and the ports 8080 and 5432 are not occupied on your local machine) I'm exposing 8080 port for localhost spring application and 5432 for postgres.
4. Now, the url ```http://localhost:8080/api/v1/student``` should work on your local browser and you should see a Student array of size 2. 

<br>

## How to execute PUT, POST, and DELETE Operations using [CURL](https://curl.se/) or [POSTMAN](https://www.postman.com/)?

1. **POST** Operation using Postman: Open Postman and select POST operation, inside the body paste the url as ```http://localhost:8080/api/v1/student```. Then inside the headers part, input key="Content-Type" and value="application/json" and paste the following into raw format body part. 
```
{
"name": "Butter",
"email": "butter@gmail.com",
"dob": "2018-01-10"
}
```
Once done with these steps, press Send and see the http response. 

2. **PUT** operation using Postman: Open Postman and select PUT operation, inside the body paste the url as ```http://localhost:8080/api/v1/student/1?email=newEmail@gmail.com&name=Butter Soni```. Keep headers and raw body empty and press SEND and wait for the http response. 

3. **DELETE** operation using Postman: Open Postman and select DELETE operation, inside the body paste the url as ```http://localhost:8080/api/v1/student/1```. Again, keep headers and raw body empty and press SEND and wait for the http response. 

## docker-compose 'down'

Once you're done with the testing, press ```CTRL + C``` on the current running docker terminal to force stop the execution and type and enter ```docker-compose down``` and you're good to go. 


**_I'm trying to fix issues which will allow us to leverage and test a composed docker container over the [DOCKER PLAYGROUND](https://labs.play-with-docker.com/). I will fix this issue shortly._** 
