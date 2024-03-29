
# Taco Cloud

Taco Cloud is a web application developed using the Spring in Action 6th edition book. It allows users to create, customize, and order tacos online. The application is built using Spring Boot and offers an MVC architecture. 
The app is supposed to serve as a learning basis for Spring and thus contains different comments spread out in the code to help with the understanding of using Spring.


## Features

- User authentication and authorization using Spring Security
- Ability to create and customize tacos with different fillings, toppings, and sauces
- Option to place an order and view order status
- Responsive and intuitive user interface


    
## Run Locally

To get started with Taco Cloud, clone the repository and run the application using the following commands:

```bash
  git clone https://github.com/lupudeni/taco-cloud.git
```

Start the server

```bash
  mvn spring-boot:run
```

Once the application is running, open your web browser and navigate to http://localhost:8080.

## Tech Stack

**View:** Thymeleaf

**Server:** Java 11, Spring Boot 6

**DB:** built in H2 using Flyway for migrations

