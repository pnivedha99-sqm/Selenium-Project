package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerPage {

    WebDriver driver;

    public registerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    public WebElement email;

    @FindBy(id = "input-telephone")
    WebElement telephone;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='text-danger']")
    public WebElement passwordErrorMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement privacyPolicyErrorMessage;

    public void inputFirstName(String firstname) {
        firstName.sendKeys(firstname);
    }

    public void inputLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void inputEmail(String emailID) {
        email.sendKeys(emailID);
    }

    public void inputTelephone(String telephoneNumber) {
        telephone.sendKeys(telephoneNumber);
    }

    public void inputPassword(String passwordData) {
        password.sendKeys(passwordData);
    }

    public void inputConfirmPassword(String confirmPasswordData) {
        confirmPassword.sendKeys(confirmPasswordData);
    }

    public void clickOnPrivacyPolicyCheckbox() {
        privacyPolicyCheckbox.click();
    }

    public successfulAccountCreationPage ClickSubmitSuccess() {
        submitButton.click();
        return new successfulAccountCreationPage(driver);
    }

    public void clickSubmitError() {
        submitButton.click();
    }

    public String passwordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public String privacyPolicyErrorMessage() {
        return privacyPolicyErrorMessage.getText();
    }
}
