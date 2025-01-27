# Taco Cloud Application with Cassandra Integration

Welcome to the Taco Cloud application! This guide will help you set up and run the application with Apache Cassandra as the database backend.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setting Up Cassandra](#setting-up-cassandra)
- [Configuring the Application](#configuring-the-application)
- [Running the Application](#running-the-application)
- [Interacting with Cassandra](#interacting-with-cassandra)

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK) 17**: [Download JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- **Apache Maven**: [Download Maven](https://maven.apache.org/download.cgi)
- **Docker**: [Download Docker](https://www.docker.com/get-started)

## Setting Up Cassandra

To set up Apache Cassandra using Docker:

1. **Pull the Cassandra Docker Image**:
   docker pull cassandra:latest

2. **Run the Cassandra Container**:
   docker run --name taco-cassandra -p 9042:9042 -d cassandra:latest

3. **Verify Cassandra is Running**:
   docker ps
   
## Configuring the Application
spring:
  application:
    name: taco-cloud
  cassandra:
    keyspace-name: tacocloud
    schema-action: recreate
    local-datacenter: datacenter1
    contact-points: localhost
    port: 9042

## Running the Application

1. **Clone the Repository**:
git clone https://github.com/lupudeni/taco-cloud.git
cd taco-cloud
git checkout cassandraDB-alternative

2. **Build the Application**:
./mvnw clean install
or
mvn clean install -DskipTests

3. **Run the Application**:
./mvnw spring-boot:run

## Interacting with Cassandra

1. **Access the Cassandra Container**:
docker exec -it taco-cassandra cqlsh

2. **List Keyspaces**:
DESCRIBE KEYSPACES;

3. **Use the tacocloud Keyspace**:
USE tacocloud;

4. **List Tables**:
DESCRIBE TABLES;

    
