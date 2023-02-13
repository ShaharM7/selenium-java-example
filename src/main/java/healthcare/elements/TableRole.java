package healthcare.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TableRole extends AbstractElement {

    By tableHeaderTableSelector = By.className("oxd-table-header");
    By tableHeadersSelector = By.cssSelector("[role=\"columnheader\"]");
    By tableBodyTableSelector = By.className("oxd-table-body");
    By tableRowsSelector = By.className("oxd-table-card");
    By tableCellSelector = By.cssSelector("[role=\"cell\"]");

    public TableRole(WebDriver driver, WebDriverWait wait, WebElement element) {
        super(driver, wait, element);
    }

    public WebElement returnRowByUniqueIndexCellName(int cellTypeIndex, String cellText) {

        for (WebElement row : getTableRows()) {

            WebElement expectedCell = row.findElements(tableCellSelector).get(cellTypeIndex);

            if (Objects.equals(expectedCell.getText(), cellText))
                return row;
        }

        return null;
    }

    private List<WebElement> getTableRows() {
        WebElement table = wait.until(visibilityOf(element));
        WebElement tableBody = table.findElement(tableBodyTableSelector);
        wait.until(numberOfElementsToBeMoreThan(tableRowsSelector, 1));
        return tableBody.findElements(tableRowsSelector);
    }

    private int getNumberOfColumns() {
        WebElement table = wait.until(visibilityOf(element));
        WebElement tableHeader = table.findElement(tableHeaderTableSelector);
        return tableHeader.findElements(tableHeadersSelector).size();
    }


}
