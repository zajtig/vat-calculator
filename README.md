# Maven commands:

* **Command to run Unit tests:**
  `mvn clean test`
* **Command to run Pitest:**
  `mvn clean test && mvn org.pitest:pitest-maven:mutationCoverage`
* **Command to run system tests:**
  `mvn clean test-compile failsafe:integration-test failsafe:verify -DskipIntegrationTests=false`
* **Command to generate Serenity html system test report:**
  `cd system-test && mvn serenity:aggregate`
* **Create distribution:**
  `cd vat-calculator-rest && mvn clean install spring-boot:repackage`
* **Command to run sonar:**
  `mvn clean verify sonar:sonar` (Please adjust your sonar.host.url and sonar.login properties in your settings.xml)
* **Swagger url:** 
  'http://localhost:8080/swagger-ui/index.html'


# Domain dictionary:

| Word                                          | Description                                                                                                                                                                |
|:----------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Net                                           | A net amount, profit, weight, or price                                                                                                                                     |
| Gross                                         | A gross profit or income                                                                                                                                                   |
| VAT                                           | Value added tax                                                                                                                                                            |