library-jooq-dropwizard
=======================


web service Integrating both jooq and dropwizard

In the GenerateSource.groovy file 
  1. set the sourceDir to point to your project directory and 
  2. set your database credentials under username and passowrd

In the libray.yml file 
  1. Ensure the db creditials are correct


To run the project in commanline navigate to the project folder then type in the following gradle commands
  
  1. gradle clean build run 
  2. gradle clean execute -Pstg=final build jar
