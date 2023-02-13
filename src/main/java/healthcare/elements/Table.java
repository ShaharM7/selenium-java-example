package healthcare.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Table extends AbstractElement {

    private final By tableSelector = By.className("orangehrm-timesheet-table");
    private final By tableHeaderSelector = By.className("orangehrm-timesheet-table-header");
    private final By tableBodySelector = By.className("orangehrm-timesheet-table-body");
    private final By tableRowSelector = By.tagName("tr");
    private final By tableCellSelector = By.tagName("td");

    public Table(WebDriver driver, WebDriverWait wait, WebElement element) {
        super(driver, wait, element);
    }

    public WebElement getCellElementFromRow(int rowIndex, int cellIndex) {
        return getRowElementByIndex(rowIndex).findElements(tableCellSelector).get(cellIndex);
    }

    public WebElement getRowElementByIndex(int rowIndex) {

        return element.findElement(tableBodySelector).findElements(tableRowSelector).get(rowIndex);
    }
}
