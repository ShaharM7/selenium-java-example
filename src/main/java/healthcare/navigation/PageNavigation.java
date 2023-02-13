package healthcare.navigation;

import healthcare.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PageNavigation {

    private WebDriver driver;
    private LoginPage loginPage;

    @Value("${navigation.url}")
    private String url;

    @Value("${navigation.loginRoute}")
    private String loginRoute;


    public PageNavigation(WebDriver driver, LoginPage loginPage) {
        this.driver = driver;
        this.loginPage = loginPage;
    }

    public LoginPage navigateToLoginPage() {

        navigateTo(url);
        return loginPage;
    }

    private void navigateTo(String pageUrl) {
        driver.navigate().to(pageUrl);
    }
}
