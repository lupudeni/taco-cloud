# Taco Cloud with MongoDB

## Overview

This is a Spring Boot application for managing taco orders with a MongoDB database. The application allows users to customize their tacos, place orders, and view the available ingredients. This version uses MongoDB as a data store instead of Cassandra.

## Features
- [Prerequisites](#prerequisites)
- [Setting Up MongoDB](#setting-up-mongodb)
- [Running the Application](#running-the-application)
- [Interacting with MongoDB](#interacting-with-mongodb)

## Prerequisites
- Java 11 or newer
- Maven or Gradle
- Docker (for MongoDB container)

## Setting Up MongoDB
Before running the Spring Boot application, you need to set up a MongoDB container if you don't have MongoDB running on your local machine. Run mongo-setup.sh

## Running the Application

1. **Clone the Repository**:
git clone https://github.com/lupudeni/taco-cloud.git
cd taco-cloud
git checkout mongoDB-alternative

2. **Build the Application**:
./mvnw clean install
or
mvn clean install -DskipTests

3. **Run the Application**:
./mvnw spring-boot:run

## Interacting with MongoDB

1. **Access the Mongo Container**:
docker exec -it my-mongo mongosh

3. **Use the tacocloud db**:
use tacoclouddb;

2. **List collections**:
show collections;

4. **Query ingredients**:
db.ingredients.find();

