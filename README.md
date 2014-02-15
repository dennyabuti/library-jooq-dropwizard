library-jooq-dropwizard
=======================


web service Integrating both jooq and dropwizard

In the GenerateSource.groovy file 
  1. set the sourceDir to point to your project directory and 
  2. set your database credentials under username and passowrd

In the libray.yml file 
  1. Ensure the db creditials are correct


To run the project in commanline, navigate to the project folder then execute the following commands in order. Command 2 needs to wait for 1 to finish
  
  1. gradle clean build run 
  2. gradle clean execute -Pstg=final build jar

To run the built jar

  java -jar build/libs/library-jooq-dropwizard-1.0.jar server library.yml
  
In a web browser enter the following url

  http://localhost:8080/author/create?fname=yourfirstname&lname=namelastyour
