package healthcare.ui;

import healthcare.GeHealthCareAutomation;
import healthcare.navigation.PageNavigation;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(classes = GeHealthCareAutomation.class)
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected PageNavigation pageNavigation;

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
