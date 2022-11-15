# Test automation project for [Meduza](https://meduza.io/)

<p  align="center">
<img src="src/test/resources/images/logos/meduza_logo.png" alt="MeduzaLogo" width="900">
</p>

# <a name="TableOfContents">Table of contents</a>
+ [Description](#Description)
  + [Tools and technologies](#Technology)
+ [How to run](#Jenkins)
    + [Gradle command](#GradleCommand)
    + [Property files](#PropertyFiles)
        + [Default property files](#PropertyFilesDefaults)
    + [Run in Jenkins](#RunInJenkins)
+ [Telegram Notifications](#TelegramNotifications)
+ [Test results report in Allure Report](#AllureReport)
    + [Project in Allure TestOps](#AllureTestOpsProject)
    + [Start a run of custom set of tests](#AllureTestOpsStartTests)
    + [Dashboards](#Dashboards)
+ [Video of running tests](#Video)


# <a name="Description">Description</a>
The test project consists of Web tests.Tests check both russian and english versions of the website.
<p  align="center">
<img src="src/test/resources/images/screenshots/main_page.png" alt="MeduzaMainPage" width="455">
<img src="src/test/resources/images/screenshots/footer_eng.png" alt="FooterEng" width="450">
<img src="src/test/resources/images/screenshots/auth_ru.png" alt="AuthRu" width="470">
</p>
Test-run GIF
<p  align="center">
<img src="src/test/resources/images/screenshots/test_gif.gif" alt="test_run_gif" width="700">
</p>

## <a name="Technology">Tools and a technologies</a>
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="src/test/resources/images/logos/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="src/test/resources/images/logos/java-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="src/test/resources/images/logos/selenide-logo.svg"></code>
  <code><img width="5%" title="Selenoid" src="src/test/resources/images/logos/selenoid-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="src/test/resources/images/logos/gradle-logo.svg"></code>
  <code><img width="5%" title="JUnit5" src="src/test/resources/images/logos/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="src/test/resources/images/logos/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Github" src="src/test/resources/images/logos/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="src/test/resources/images/logos/jenkins-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="src/test/resources/images/logos/Telegram.svg"></code>
</p>

The autotests in this project are written in `Java` using `Selenide` framework.\
`Gradle` - is used as a build automation tool.  \
`JUnit5` - to execute tests.\
`Jenkins` - CI/CD for running tests remotely.\
`Selenoid` - to remote launching browsers in `Docker` containers.\
`Allure Report` - for test results visualisation.\
`Telegram Bot` - for test results notifications.

[Back to the table of contents ⬆](#TableOfContents)

# <a name="HowToRun">How to run</a>

## <a name="GradleCommand">Gradle command</a>
To run locally and in Jenkins the following command is used:
```
gradle clean <tests_to_be_executed>   
```
tests_to_be_executed:
>`test` - all tests\
>`ru` - russian version only\
>`eng` - english version only\
>`header` - header tests\
>`footer` - footer tests

Additional parameters:
> `-Dbrowser=browser` - browser\
> `-DbrowserSize=browserSize` - browser size\
> `-DremoteUrl=remoteUrl` - remote URL

[Back to the table of contents ⬆](#TableOfContents)




## <a name="RunInJenkins">Run in [Jenkins](https://jenkins.autotests.cloud/job/C15-anna_rkchv-Unit15_Project_HW/)</a>
Main page of the build and parameters for Jenkins job:
<p  align="center">
<img src="src/test/resources/images/screenshots/jenkins_mainpage.png" alt="JenkinsBuildMainPage" width="600">
<img src="src/test/resources/images/screenshots/jenkins_params.png" alt="JenkinsBuildParameters" width="420">
</p>

After the build is done the test results are available in <code>Allure Report</code>
<p  align="center">
<img src="src/test/resources/images/screenshots/allure_mainpage.png" alt="JenkinsBuildParameters" width="600">
<img src="src/test/resources/images/screenshots/allure_tests.png" alt="JenkinsBuildParameters" width="600">
</p>

[Back to the table of contents ⬆](#TableOfContents)


# <a name="TelegramNotifications">Telegram Notifications</a>
Results of each build are sent to a specified telegram chat.
<p  align="center">
<img src="src/test/resources/images/screenshots/telegram_notification.png" alt="TelegramNotificaton" width="450">
</p>


[Back to the table of contents ⬆](#TableOfContents)
