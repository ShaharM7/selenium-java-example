package healthcare.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractElement {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected WebElement element;

    public AbstractElement(WebDriver driver, WebDriverWait wait, WebElement element) {
        this.driver = driver;
        this.wait = wait;
        this.element = element;
    }

    public Boolean clickOnElement(By elem) {
        try {
            driver.findElement(elem).click();
            return true;
        } catch (Exception e) {
            System.out.println("Element " + elem + " was not clicked");
            return false;
        }
    }

    public Boolean clearAndTypeTextToElem(By elem, String text) {
        try {
            WebElement textField = driver.findElement(elem);
            textField.clear();
            textField.sendKeys(text);
            return true;
        } catch (Exception e) {
            System.out.println("Element " + elem + " was not clear and text was not sent to");
            return false;
        }
    }

    public String getTextFromElement(By elem) {
        return driver.findElement(elem).getText();
    }

    public List<String> getTextFromElements(By elem) {
        List<WebElement> elementList = driver.findElements(elem);
        List<String> stringList = new ArrayList<>();
        for (WebElement element : elementList) {
            stringList.add(element.getText());
        }
        return stringList;
    }

    public List<String> getHrefFromElements(By elem) {
        List<WebElement> elementList = driver.findElements(elem);
        List<String> hrefList = new ArrayList<>();
        for (WebElement element : elementList) {
            hrefList.add(element.getAttribute("href"));
        }
        return hrefList;
    }

    public Boolean getElementWithColorRed(By elem) {
        List<WebElement> elementList = driver.findElements(elem);
        for (WebElement element : elementList) {
            if (element.getCssValue("background-color").equalsIgnoreCase("rgba(255, 104, 114, 0.15)")) {
                return true;
            }
        }
        return false;
    }

    public Boolean navigateToPreviousPage() {
        try {
            driver.navigate().back();
            return true;
        } catch (Exception e) {
            System.out.println("Navigation back wasn't succeeded");
            return false;
        }
    }

    public boolean scrollToElement(By elemToScroll) {
        try {
            WebElement element1 = driver.findElement(elemToScroll);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
            return true;
        } catch (Exception e) {
            System.out.println("Scroll to element was not worked correct");
            return false;
        }
    }
}
