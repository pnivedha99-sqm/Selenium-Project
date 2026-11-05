package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class titlePage {

    protected WebDriver driver;
    public titlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//a[@title='My Account']")
    WebElement myAccountDropDown;

    @FindBy (xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
    WebElement registerButton;

    public void clickOnMyAccountDropDown() {
        myAccountDropDown.click();
    }

    public registerPage clickOnRegisterButton() {
        registerButton.click();
        return new registerPage(driver);
    }
}
