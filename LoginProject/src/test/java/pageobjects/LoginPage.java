package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage extends LoadableComponent<LoginPage> {
    WebDriver driver;

    @Override
    public void load() {
    }

    @Override
    public void isLoaded() {
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.ID, using = "Email")
    private WebElement emailField;

    @FindBy(how = How.ID, using = "Password")
    private WebElement passwordField;

    @FindBy(how = How.CSS, using = "button.login-button")
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = "div.message-error.validation-summary-errors")
    private WebElement errorMessage;

    public void setEmailField(String username) {
        emailField.clear();
        emailField.sendKeys(username);
    }

    public void setPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.submit();
    }
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
