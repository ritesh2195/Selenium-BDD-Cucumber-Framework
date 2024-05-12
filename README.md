# Amazon Automation with Selenium, BDD, and Cucumber

## Overview
This project provides automated testing and interaction with Amazon's website using Selenium WebDriver, BDD (Behavior-Driven Development), and Cucumber. The automation covers functionalities like login, address management, product search, and adding items to the cart.

## Features
- **Login Automation:** Automates the login process to Amazon using provided credentials.
- **Address Management:** Allows adding and deleting addresses associated with the user's account.
- **Product Search:** Conducts product searches on Amazon based on specified criteria.
- **Add to Cart:** Adds selected items to the shopping cart.

## Prerequisites
- Java Development Kit (JDK) installed
- Maven installed
- WebDriver for your preferred browser (e.g., ChromeDriver for Google Chrome)

## Setup
1. Clone the repository:
   ```
   git clone https://github.com/ritesh2195/Selenium-BDD-Cucumber-Framework.git
   ```
2. Navigate to the project directory:
   ```
   cd amazon-automation
   ```
3. Install dependencies:
   ```
   mvn clean install
   ```

## Configuration
1. Provide your Amazon login credentials in the `config.properties` file.
2. Ensure the WebDriver executable path is correctly set in the `config.properties` file.

## Usage
1. Execute the Cucumber runner class to run all the automated tests:
   ```
   mvn test
   ```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
