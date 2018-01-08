<h1> AdidasTask-1-ll: API-Tests for the adidas homepage CMS response </h1>

This project is also the first task mention in the doc, however I have used here a different framwork and different approaches to extract the details from the json file. The framework I have used here is hybrid with the use of testNG, cucumber and Extent report for reporting. You can run  this project from runner class without any problem, if testNG is not found while running the AdidasQATaskRunner class then please select new testNG build from the run configuration and run it, in the end report can be seen in the report folder.

Report Location: Adidas-QA-Task1-ll\src\test\resources\ExtentReport\AllReport.html



<Strong>About Task</Strong>:

1. Response Ame should be bellow 1s<br>
Test Case Status: Pass
2. Images should be accessible (no 404/401s)<br>
Test Case Status: Pass
3. Every component has at least analyAcs data “analytics_name” in it<br>
Test Case status: Fail : analytics_name is not present in all of the Componenets
