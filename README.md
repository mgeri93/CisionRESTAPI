# CisionRESTAPI
## Technical information
	This is a SPRING MAVEN project built on JAVA 11 with H2 database (running on localhost:8080).
	Dependencies used on project build:
		-Spring Boot DevTools
		-Lombok
		-Spring Web
		-Spring Data JPA
		-H2 Database

## Brief Introduction
	This is a REST API appliacation which takes a JSON payload and checks its content whether it contains a palindrome,
	and if so, returning the size of the palindrome.
	Example input: {
			"content": "abrakadabra",
			"timestamp": "2018-10-09 00:12:12+0100"
			}
	The application considers only alphabetic characters when calculating the plaindrome size,
	and only validates and saves JSON entries where none of the input fields are empty or null.
	
## Using The Application
### Input file
	The input file can be located and modified in the application's resource folder.
	src/main/resources/json/payload.json
### Boot Up
	The application can be boot up from here:
	src/main/java/com/example/cisionrestapi/CisionRestApiApplication.java
### Checking results
	After entering the JSON contents and booting up our application,
	we can check the result on the "http://localhost:8080/list" endpoint in our browser or with an API Tool i.e.: Postman.
	
	

