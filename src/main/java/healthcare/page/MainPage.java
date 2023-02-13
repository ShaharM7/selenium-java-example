package healthcare.page;

import healthcare.page.manuPages.TimePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

@Component
public class MainPage extends AbstractPage {

    private TimePage timePage;
    private final By timeSelector = By.cssSelector("aside[class='oxd-sidepanel'] li:nth-child(4)");

    public MainPage(WebDriver driver, WebDriverWait wait, TimePage timePage) {
        super(driver, wait);
        this.timePage = timePage;
    }

    public TimePage goToTimePage() {
        wait.until(elementToBeClickable(timeSelector)).click();
        return timePage;
    }
}
