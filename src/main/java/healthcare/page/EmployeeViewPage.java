package healthcare.page;

import healthcare.elements.Table;
import healthcare.popups.CommentPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class EmployeeViewPage extends AbstractPage {

    private final By tableSelector = By.tagName("table");
    private final By commentButtonSelector = By.tagName("button");
    private final By commentPopupBySelector = By.cssSelector("div[role='document']");

    public EmployeeViewPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CommentPopup addComment(int rowIndex, int cellIndex) {

        Table employeeTimeSheetTable = initEmployeeTimeSheetTable();
        WebElement cellElement = employeeTimeSheetTable.getCellElementFromRow(rowIndex, cellIndex);
        cellElement.findElement(commentButtonSelector).click();
        return new CommentPopup(driver, wait, driver.findElement(commentPopupBySelector));
    }

    private Table initEmployeeTimeSheetTable() {
        return new Table(driver, wait, driver.findElement(tableSelector));
    }


}
