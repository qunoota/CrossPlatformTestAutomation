# CrossPlatformAutomation Framework

## Overview
The CrossPlatformAutomation framework is designed to integrate web, mobile, and API testing into a single platform. 

## Key Features

### TestBase Class
- **Parent Class**: Acts as the parent class for all classes.
- **Initialization**: Initializes web browsers, Android, and iOS testing environments.
- **Browser Support**: Initializes the web driver for Chrome, Firefox, and Edge based on configuration settings.
- **Browser Setup**: Maximizes browser window, deletes cookies, and navigates to a predefined URL.

### Configuration Management
- **ConfigReader and ConfigProperties**: 
-  Uses `configReader` to load properties from the config file.

### Test Data Management
- **Test Data JSON File**: Uses `TestData -> testdata.json` to retrieve login usernames and passwords (data-driven testing).

### Mobile Testing Integration
- **Android Testing**: Integrated with Appium for Android mobile testing.
- **iOS Testing**: Uses BrowserStack for iOS testing, enabling cross-platform mobile testing.

### API Testing with Rest Assured
- **Rest Assured**: Utilized for API testing.
- **Faker Library**: Implements `Faker` library to generate test data dynamically.
- **Request Types**: Supports POST requests to add names to the API response and PUT requests to update names.

## Tools and Technologies
- **Selenium with TestNG**: For web automation testing.
- **Appium**: For Android mobile testing.
- **BrowserStack**: For iOS mobile testing.
- **Rest Assured and Faker Library**: For API testing.
- **Test Data Json File**: For test data management.
- **Logging**: Log4j API for making it easier to track test execution and debug failures.

## Reporting
- Extent Reporting Framework

## Getting Started

### Prerequisites
- Java 17
- Maven
- Android SDK (for Android testing)
- BrowserStack account (for iOS testing)
- ChromeDriver, FirefoxDriver, and EdgeDriver

### Installation
1. **Clone the Repository**:
    git clone https://github.com/qunoota/CrossPlatformTestAutomation
2. Tests are executed using the `testng.xml` configuration file.