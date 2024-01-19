# Demo Web Framework for TS
This framework was built using [askomdch webapplication/](https://askomdch.com/).

## Wireframe description:

 This Java-based Selenium framework with Cucumber integration 
 is designed to streamline and enhance the automation testing process for web applications. 
 The framework utilizes the powerful Selenium WebDriver for browser automation
 and Cucumber for behavior-driven development (BDD) testing.

## Key Features
**Modular Structure**: The framework is organized into modular components,
promoting maintainability and reusability of code.

**Page Object Model (POM)**: Leverage the Page Object Model design pattern 
for clear separation of concerns and improved code structure.

**Cucumber Integration**: Write and execute BDD tests using Cucumber, 
allowing collaboration between technical and non-technical team members.

**Configurable**: Easily configure test parameters, browser options,
and other settings through a centralized configuration file.

**Reporting**: Generate detailed and easily understandable
test reports for effective analysis and debugging.

## The technologies to be used:
- Java 
- Selenium
- TestNG
- Maven
- Cucumber
  

## Prerequisites
- Ensure you have Java installed on your machine.
- Download and set up the Selenium WebDriver.
- Install necessary dependencies using Maven.

## Steps to run the application:

- git clone https://github.com/TSR-Repo/WebFramework/
- cd Webframework
- mvn clean test — default test command, runs headless tests on Chrome.
- allure serve allure-results - generate test report.
- mvn test
- Run application

## Customization
Adjust the configuration file (src/test/resources/config.properties) to suit your project requirements. 

- factory folder: add before and after hooks for both browsers
- hooks: add before and after hooks
- pages implement checkout
- stepdefinitions: implement checkout
- RunnerTest.java: It runs cucumber features


