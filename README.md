 #### 3. Project Structure   
 📦 SampleProject
├─ .github
│  └─ workflows
│     └─ maven.yml
├─ .gitignore
├─ LICENSE
├─ README.md
├─ build.gradle
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ script
│  └─ install_chrome.sh
├─ settings.gradle
└─ src
   ├─ main
   │  └─ java
   │     └─ io
   │        └─ github
   │           └─ tahanima
   │              ├─ config
   │              │  ├─ Configuration.java
   │              │  └─ ConfigurationManager.java
   │              ├─ dto
   │              │  ├─ BaseDto.java
   │              │  ├─ LoginDto.java
   │              │  └─ ProductsDto.java
   │              ├─ factory
   │              │  ├─ BasePageFactory.java
   │              │  └─ BrowserFactory.java
   │              ├─ report
   │              │  └─ ExtentReportManager.java
   │              └─ ui
   │                 ├─ component
   │                 │  ├─ BaseComponent.java
   │                 │  ├─ Header.java
   │                 │  └─ SideNavMenu.java
   │                 └─ page
   │                    ├─ BasePage.java
   │                    ├─ LoginPage.java
   │                    └─ ProductsPage.java
   └─ test
      ├─ java
      │  └─ io
      │     └─ github
      │        └─ tahanima
      │           ├─ e2e
      │           │  ├─ BaseTest.java
      │           │  ├─ LoginTest.java
      │           │  └─ ProductsTest.java
      │           └─ util
      │              ├─ DataProviderUtil.java
      │              ├─ TestListener.java
      │              └─ TestRetry.java
      └─ resources
      |─ testfiles
            ├─ test1.txt
            ├─ test2.txt
      ├─ login.xlsx
