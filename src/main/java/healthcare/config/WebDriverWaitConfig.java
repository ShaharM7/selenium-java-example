package healthcare.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static java.time.Duration.ofSeconds;

@Configuration
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class WebDriverWaitConfig {

    @Value("${wait.durationTimeout}")
    private int durationTimeout;

    @Value("${wait.intervalTimeout}")
    private int intervalTimeout;

    @Value("${wait.implicitlyTimeout}")
    private int implicitlyTimeout;

    @Value("${wait.scriptTimeout}")
    private int scriptTimeout;

    @Value("${wait.pageLoadTimeout}")
    private int pageLoadTimeout;

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(ofSeconds(implicitlyTimeout));
        driver.manage().timeouts().scriptTimeout(ofSeconds(scriptTimeout));
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(pageLoadTimeout));

        WebDriverWait webDriverWait = new WebDriverWait(driver, ofSeconds(durationTimeout));
        webDriverWait.withTimeout(ofSeconds(durationTimeout)).pollingEvery(ofSeconds(intervalTimeout));
        return webDriverWait;
    }
}
