package stepdefinitions;


import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageobjects.HomePage;
import pageobjects.LoginPage;


import java.util.List;
import java.util.Map;


public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;

    HomePage homePage;

    @Before(order = 1)
    public void setup_driverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @Before(order = 2)
    public void launch_chrome_browser(Scenario sc) {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

//    @BeforeStep("@Smoke")
//    public void printBeforeEcveryStep() {
//        System.out.println("Hello step");
//    }

    @When("User opens URL as {string}")
    public void user_opens_url_as(String URL) {
        driver.get(URL);
    }


    @And("User enters email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String username, String password) {
        System.out.println(Thread.currentThread().getId());
        loginPage = new LoginPage(driver);
        loginPage.setEmailField(username);
        loginPage.setPasswordField(password);
        System.out.println();
    }

    @And("click on Login button")
    public void click_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @When("click on Logout button")
    public void click_on_logout_button() {
        homePage = new HomePage(driver);
        homePage.clickOnLogoutButton();
    }

    @After
    public void close_browser() {
        driver.quit();
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> signInForm = dataTable.asLists(String.class);
        String userName = signInForm.get(0).get(0);
        String passWord = signInForm.get(0).get(1);
        loginPage = new LoginPage(driver);
        loginPage.setEmailField(userName);
        loginPage.setPasswordField(passWord);
    }

    @When("User enters valid login credentials")
    public void user_enters_valid_login_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> signInForm = dataTable.asMaps(String.class, String.class);
        String userName = signInForm.get(0).get("Username");
        String passWord = signInForm.get(0).get("Password");
        loginPage = new LoginPage(driver);
        loginPage.setEmailField(userName);
        loginPage.setPasswordField(passWord);
    }

    @When("User enters login credentials")
    public void user_enters_login_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> signInForm = dataTable.asMaps(String.class, String.class);
        String userName = signInForm.get(0).get("Username");
        String passWord = signInForm.get(0).get("Password");
        loginPage = new LoginPage(driver);
        loginPage.setEmailField(userName);
        loginPage.setPasswordField(passWord);
    }

    @Then("Error message should contain the message {string}")
    public void error_message_should_contain_the_message(String errorMessage) {
        String loginErrorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(loginErrorMessage.contains(errorMessage));
    }

    @When("User enters invalid login credentials multiple times")
    public void user_enters_invalid_login_credentials_multiple_times(io.cucumber.datatable.DataTable dataTable) throws Exception {
        List<Map<String, String>> signInForm = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> user : signInForm) {
            String userName = user.get("Username");
            String passWord = user.get("Password");
            loginPage = new LoginPage(driver);
            loginPage.setEmailField(userName);
            loginPage.setPasswordField(passWord);
            loginPage.clickOnLoginButton();
            Assert.assertTrue(loginPage.getErrorMessage().contains("Login was unsuccessful"));
        }
    }

    @When("User search for {string}")
    public void user_search_for(String string) {
        System.out.println("Search for iPhone");
        System.out.println(Thread.currentThread().getId());
    }

    @When("click on Enter button in the keyboard")
    public void click_on_enter_button_in_the_keyboard() {
        System.out.println("Press enter button in the keyboard");
    }
//    @AfterStep("@Smoke")
//    public void close() {
//        System.out.println("Closing test");
//    }
}
