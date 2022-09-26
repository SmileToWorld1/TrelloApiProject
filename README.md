#  REST API PROJECT EXERCISE

##### TOOLS AND EXPLANATIONS
>- The project has been prepared based on Cucumber BDD style.
>- Maven build management tool is used in this project by Java language.
>- LOG4J and SL4J information is provided as a logging design.
>- In the project that includes a scenario, which is about Board' And Card' https requests 
   >with Post, Put and Delete by receiving information from the live API server (https://developer.atlassian.com/cloud/trello/rest/),
>- A special tag(`@api_trello`,`@wip`) was used in the project. Thus, the desired feature can be run in Runner.

##### HOW TO RUN TESTS
```sh
 -> Under the runner package "Runner" right click and run Runner. "src > test > java > trello > runners > CukesRunner"
 -> mvn test --> in the IDE console or navigate project path in command line and run.
```
#### REPORT

>- Cucumber report is generated under the target folder: target/cucumber/cucumber-html-reports/overview-features.html
>- Execution log records are inside of execution_log.txt file


- İsmail SONMEZ
- QA Automation Engineer 