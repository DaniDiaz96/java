# Charlene Coffee Corner

A project that simulate a coffee shop

## Installing

How you run this code is up to you, but usually you would start by using an IDE like NetBeans, Intellij IDEA, or Eclipse.

The Maven dependencies may lag behind the official releases a bit.

If you notice some problems with this setup, please open an issue.

### A couple of Maven commands

Once you have configured the project in your IDE you can build it from there. However if you prefer you can use maven from the command line. In that case you could be interested in this short list of commands:

* `mvn compile`: it will just compile the code of the application and tell you if there are errors
* `mvn test`: it will compile the code of the application and the tests.
* `mvn install`: it will do everything `mvn test` does and then if everything looks file it will install the library or the application into your local maven repository (typically under <USER FOLDER>/.m2). In this way you could use this library from other projects you want to build on the same machine

If you need more information please take a look at this [quick tutorial](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).

## How to run the project

Once you have compiled the project you have to run CharleneCoffeeCornerApplication.class to get the output

### An output example

```
Client: Daniel
Product: Coffee large with extra milk - 3.80 CHF
Product: Coffee small with special roast - 3.40 CHF
Product: Orange juice - 3.95 CHF
No discount applied
Total: 11.15 CHF

Client: Juan
Product: Coffee medium with foamed milk - 3.50 CHF
Product: Bacon roll - 4.50 CHF
Product: Orange juice - 3.95 CHF
Discount: 0.50 CHF
Total: 11.45 CHF

Client: Isabel
Product: Coffee small - 2.50 CHF
Product: Orange juice - 3.95 CHF
Product: Orange juice - 3.95 CHF
Product: Coffee large - 3.50 CHF
Product: Coffee large - 3.50 CHF
Discount: 3.50 CHF
Total: 13.90 CHF
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## JDK version

* [11.0.2](https://www.oracle.com/es/java/technologies/javase-jdk11-downloads.html) - Java version

## Authors

* **Daniel Díaz-Malaguilla Palacios** 
