🚀 Selenium Test Automation Framework
This is a robust and scalable Selenium-based UI Test Automation Framework developed in Java using TestNG. It supports cross-browser testing across Chrome, Edge, and Firefox with headless mode capabilities. The framework is designed to be clean, reusable, and easy to maintain for web UI test automation.

🔧 Features
🧪 TestNG-based structure for test lifecycle management

🌐 Cross-browser support: Chrome, Edge, Firefox

🕶️ Headless execution for CI environments

📸 Screenshot capture on test failures

📂 Page Object Model (POM) for clean code separation

🧵 Thread-safe WebDriver using ThreadLocal for parallel test execution

📋 Logging with Log4j for better traceability and debugging

📄 CSV or external file-driven testing (if you're using it for data-driven tests)

🛠️ Technologies Used
Java 21

Selenium 4.25

TestNG

Maven

Log4j

Apache Commons IO

🚦 Getting Started
Clone the repository:

bash

git clone https://github.com/your-username/your-repo-name.git
Update your testng.xml or configuration file with appropriate browser and headless flags:

xml

<parameter name="browser" value="chrome"/>
<parameter name="isLambdaTest" value="true"/>
<parameter name="isHeadless" value="true"/>

Run tests using:
bash

mvn clean test
📁 Project Structure
bash

src/
├── main/
│   ├── java/
│   │   ├── com.ui.pages         # Page Object Model classes
│   │   ├── com.utility          # WebDriver & Utility classes
│   │   └── com.constants        # Enum for browser types
│
├── test/
│   ├── java/
│   │   └── com.ui.tests         # Test classes using TestNG
🧹 Future Enhancements
Integration with CI/CD (Jenkins, GitHub Actions)

Reporting (Extent Reports)

Advanced data-driven testing support (Excel/JSON/CSV)
