package healthcare.popups;

import healthcare.elements.AbstractElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CommentPopup extends AbstractElement {
    By textAreSelector = By.xpath("//textarea[@placeholder='Comment here']");

    public CommentPopup(WebDriver driver, WebDriverWait wait, WebElement element) {
        super(driver, wait, element);
    }

    public String getTextFromTextArea() {

        WebElement textAreaElement = wait.until(visibilityOfElementLocated(textAreSelector));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return textAreaElement.getAttribute("value");
    }
}
