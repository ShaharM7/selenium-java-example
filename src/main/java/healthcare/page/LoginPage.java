package healthcare.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Component
public class LoginPage extends AbstractPage {

    private final By userNameTextbox = By.name("username");
    private final By passwordTextbox = By.name("password");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");
    private MainPage mainPage;

    public LoginPage(WebDriver driver, WebDriverWait wait, MainPage mainPage) {
        super(driver, wait);
        this.mainPage = mainPage;
    }

    public void fillUserName(String userName) {
        wait.until(visibilityOfElementLocated(userNameTextbox)).sendKeys(userName);
    }

    public void fillPassword(String password) {
        wait.until(visibilityOfElementLocated(passwordTextbox)).sendKeys(password);
    }

    public MainPage login() {
        wait.until(elementToBeClickable(loginButton)).click();
        return mainPage;
    }
}
