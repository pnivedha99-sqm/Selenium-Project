package Base;

import Pages.titlePage;
import Utils.commonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Properties;

public class baseClass {

    protected WebDriver driver;
    protected Properties prop;
    protected WebDriverWait wait;

    //Browser and URL
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        prop = commonUtils.userdata();
        driver.get(prop.getProperty("URL"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Quit the browser
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
