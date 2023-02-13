package healthcare.ui;

import healthcare.page.EmployeeViewPage;
import healthcare.page.LoginPage;
import healthcare.page.MainPage;
import healthcare.page.manuPages.TimePage;
import healthcare.popups.CommentPopup;
import healthcare.utils.Tabels.TimesheetViewEmployee;
import org.testng.annotations.Test;

import static healthcare.utils.Constants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


public class SeleniumTests extends BaseTest {

    @Test
    public void whenLookForCommentTextInEmployeePage_ThenTextAsExpected() {

        LoginPage loginPage = pageNavigation.navigateToLoginPage();

        loginPage.fillUserName(CORRECT_USERNAME);
        loginPage.fillPassword(CORRECT_PASSWORD);
        MainPage mainPage = loginPage.login();
        TimePage timePage = mainPage.goToTimePage();

        EmployeeViewPage employeeViewPage = timePage.clickViewOfTimeSheetPeriod(EXAMPLE_TIME_SHEET_PERIOD);
        CommentPopup commentPopup = employeeViewPage.addComment(FIRST_ROW_INDEX, TimesheetViewEmployee.FIFTEEN_DAY_MONTH.ordinal());

        System.out.println(commentPopup.getTextFromTextArea());
        assertEquals(commentPopup.getTextFromTextArea(), "Leadership Development");
    }

    @Test
    public void whenLookForCommentTextInEmployeePage_ThenTextNotAsExpected() {

        LoginPage loginPage = pageNavigation.navigateToLoginPage();

        loginPage.fillUserName(CORRECT_USERNAME);
        loginPage.fillPassword(CORRECT_PASSWORD);
        MainPage mainPage = loginPage.login();
        TimePage timePage = mainPage.goToTimePage();

        EmployeeViewPage employeeViewPage = timePage.clickViewOfTimeSheetPeriod(EXAMPLE_TIME_SHEET_PERIOD);
        CommentPopup commentPopup = employeeViewPage.addComment(FIRST_ROW_INDEX, TimesheetViewEmployee.FIFTEEN_DAY_MONTH.ordinal());

        System.out.println(commentPopup.getTextFromTextArea());
        assertNotEquals(commentPopup.getTextFromTextArea(), "Incorrect Message");
    }
}
