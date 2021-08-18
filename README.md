# javajerseyrest

Download eclipse install enterprise for Java EE

configure tomcat server in eclipse, in this specific project I downloaded tomcat 8 manually untarred it and pointed to local install. 
Java version of project and tomcat which points to internal project is Java 8.

configure windows / preferences / maven - tick Download artifcat source / javadoc / index updates on start / update maven project - 4 tick boxes next to on another tick them all

Create a maven project - look for jersey and filter for jersey-quickstart-webapp

When installed - look through pom.xml and change beta jersey.version to this current version ` <jersey.version>1.19.4</jersey.version>`

Project will be then upto this point of checkin


Right click on project choose properties under targeted Runtimes ensure the tomcat configured is selected. 

Choose drop down by green play button on top menu bar and choose run as and run as server


[Video showing this project from scratch](https://www.youtube.com/watch?v=QwjOtVkGaVc)


### On successful launch some url's available are:


`http://localhost:8080/javarest-jersey/app/mybooks`


Authors only comes alive after books has been hit once 

`http://localhost:8080/javarest-jersey/app/authors`


`http://localhost:8080/javarest-jersey/app/authors/books/100`


Sending a request via `POSTMAN` rest utility to `localhost:8080/javarest-jersey/app/authors/author/100` with method set to `DELETE` should also remove 2 books belonging to that author


