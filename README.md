# BPDTS Herokuapp API Tests

The Test Automation Solution (TAS) is built using Serenity & Rest-Assured libraries using Java/Gradle

Tests have been written to support both formats:<br />
	1. SerenityParameterizedRunner using CSV (Junit format) and <br />
	2. CucumberWithSerenity (BDD format)

<b>Test Execution</b>:<br />
	1. Download the project to a local directory (ex: C:\BPDTS-Herokuapp)<br />
	2. Import the project using gradle option on your chosen IDE (IntelliJ or Eclipse)<br />
	3. Run Command: <i>gradlew clean build -i <i/>	(builds the project and executes all tests available)

<b>Test Execution CSV Test Runner</b>:<br />
For executing only CSV data driven tests use specific CSV_Test_Runner<br />
	Run Command: <i>gradlew clean test --tests CSV_TestSuite_Runner -i<i/>
	
<b>Test Execution BDD Features</b>:<br />
For executing feature (BDD) tests choose Feature_Test_Runner<br />
	Run Command: <i>gradlew clean test --tests Feature_Test_Runner -i<i/>
	
<b>NOTE</b>: The feature tests have been written as 2 types
	1. Focused tests individually (BDD Scenarios)
	2. Data-driven tests using (BDD Scenario Outline)
	
<b>Test Reporting (Serenity in-built report)</b>:
	Launch the index.html navigating to C:\BPDTS-Herokuapp\target\site\serenity\index.html
