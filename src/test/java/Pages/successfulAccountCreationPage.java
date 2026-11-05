package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class successfulAccountCreationPage {

    WebDriver driver;

    public successfulAccountCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(successfulAccountCreationTitle));
    }

    @FindBy (xpath = "//div[@id='content']//h1")
    WebElement successfulAccountCreationTitle;

    @FindBy (xpath="(//div[@id='content']//p)[1]")
    WebElement accountCreationMessageOne;

    @FindBy (xpath="(//div[@id='content']//p)[2]")
    WebElement accountCreationMessageTwo;

    @FindBy (xpath="(//div[@id='content']//p)[3]")
    WebElement accountCreationMessageThree;

    @FindBy (xpath="(//div[@id='content']//p)[4]")
    WebElement accountCreationMessageFour;

    public String accountCreationTitle() {
        return successfulAccountCreationTitle.getText();
    }

    public String accountCreationMessageOne(){
        return accountCreationMessageOne.getText();
    }

    public String accountCreationMessageTwo(){
        return accountCreationMessageTwo.getText();
    }

    public String accountCreationMessageThree(){
        return accountCreationMessageThree.getText();
    }

    public String accountCreationMessageFour(){
        return accountCreationMessageFour.getText();
    }

}

