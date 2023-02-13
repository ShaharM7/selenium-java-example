package healthcare.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

@Configuration
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class WebDriverConfig {

    @Value("${seleniumGrid.useSeleniumGrid}")
    private boolean useSeleniumGrid;

    @Value("${seleniumGrid.url}")
    private String seleniumGridUrl;

    @Value("${seleniumGrid.osName}")
    private String osName;

    @Value("${seleniumGrid.osVersion}")
    private String osVersion;

    @Value("${seleniumGrid.browserName}")
    private String browserName;

    @Value("${seleniumGrid.browserVersion}")
    private String browserVersion;

    @Value("#{'${browser.options}'.split(',')}")
    private List<String> browserOptions;

    @Bean
    public WebDriver driver() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(browserOptions);

        if (useSeleniumGrid) {

            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", browserName);
            capabilities.setCapability("browserVersion", browserVersion);
            HashMap<String, Object> browserstackOptions = new HashMap<>();
            browserstackOptions.put("os", osName);
            browserstackOptions.put("osVersion", osVersion);
            capabilities.setCapability("bstack:options", browserstackOptions);

            RemoteWebDriver driver = new RemoteWebDriver(new URL(seleniumGridUrl), capabilities);
            driver.manage().window().maximize();
            return driver;
        } else {

            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            return driver;
        }
    }
}