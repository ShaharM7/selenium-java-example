package healthcare.page.manuPages;

import healthcare.elements.TableRole;
import healthcare.page.AbstractPage;
import healthcare.page.EmployeeViewPage;
import healthcare.utils.Tabels.TimeSheetsCellIndex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class TimePage extends AbstractPage {

    private final By tableSelector = By.cssSelector("div[role='table']");
    private final By tableCellViewButton = By.tagName("button");

    private EmployeeViewPage employeeViewPage;

    public TimePage(WebDriver driver, WebDriverWait wait, EmployeeViewPage employeeViewPage) {
        super(driver, wait);
        this.employeeViewPage = employeeViewPage;
    }

    public EmployeeViewPage clickViewOfEmployeeName(String employeeName) {

        TableRole employeeTableRole = new TableRole(driver, wait, driver.findElement(tableSelector));

        WebElement rowWithEmployeeName = employeeTableRole.
                returnRowByUniqueIndexCellName(TimeSheetsCellIndex.EMPLOYEE_NAME_CELL_INDEX.ordinal(), employeeName);

        rowWithEmployeeName.findElement(tableCellViewButton).click();

        return employeeViewPage;
    }

    public EmployeeViewPage clickViewOfTimeSheetPeriod(String timeSheetPeriod) {

        TableRole employeeTableRole = new TableRole(driver, wait, driver.findElement(tableSelector));

        WebElement rowAsTimeSheetPeriodSelector = employeeTableRole.
                returnRowByUniqueIndexCellName(TimeSheetsCellIndex.TIME_SHEETS_CELL_INDEX.ordinal(), timeSheetPeriod);

        rowAsTimeSheetPeriodSelector.findElement(tableCellViewButton).click();

        return employeeViewPage;
    }


}
