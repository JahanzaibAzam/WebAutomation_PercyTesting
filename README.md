# automation

Pre-requisites:
  - Java JDK 8 should be installed
  - JAVA_HOME environment variable should be set

Steps to setup:
  - Clone repo: https://github.com/zglue/automation.git
  - Open project on IntelliJ through pom.xml file
  - Checkout develop branch
      - Git checkout -f develop

Steps to execute script:
  - Right click TestSuite1.xml and Run it
  - Wait for full execution
  - After execution is completed, open /reports/ExtentReport.html on Chrome browser to view results

Setup of Jenkins Locally:
Jenkins setup: 
  * Tutorial link: https://www.guru99.com/download-install-jenkins.html
  - Click on Manage Jenkins
  - Click on Global Tool Configuration
  - Under Maven, add Name (“mvnLatest”) and check Install automatically
  - Click on Apply and then Save 
  
  Framework Understanding Video:
  https://drive.google.com/drive/folders/0BwmieK6G4SFUfm9jMVBGd3YtSlFMVExTV3ZVOTlrOUszcjBMUXRrX1ZGNkotNnowRnNHSGM
  
  Reports created under Report folder, sample report provided under report folder
  

