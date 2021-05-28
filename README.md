maven_planit
---
````````````````````````````
This automation framework is build based on Page Object Model, Selenium, TestNG using Java.

This framework is based in **Page Object Model (POM).**

The framework uses:

1. Java
2. Selenium
3. TestNG
4. ExtentReport
5. Log4j


Steps to create test cases:

1.Created base package that contains the TestBaseSetup class which will be called for initialising the webdriver whenver the test is run. 
 
2.Created pageobject package that contains two page classes i.e, ContactPage class and ShopPage class 
  These page class contains all the elements that are present on the contact page & shop page and its corresponding action methods.
  
  
3.Created the bleow test classes for the 4 scenarios which are asked to be tested which uses the methods of the Page Classes.
   TC001_ValidateError_ContactPage
   TC002_ValidateSuccessMessage_ContactPage
   TC003_ValidateError_InvalidData_MandatoryField_ContactPage
   TC004_ValidateCartItems_ShopPage

4.Added the test class in testng.xml file under the project

5.All the inputs to the Mandatory field in the testcases are passed in the Çonfig.prop file present in the test/resource folder

5.Executed the test cases by maven command `mvn test -DsuiteXmlFile=testng.xml`

6.HTML Report is generated.



