package tests;

import Base.baseClass;
import Pages.registerPage;
import Pages.successfulAccountCreationPage;
import Pages.titlePage;
import Utils.commonUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Register extends baseClass {

    @Test (priority = 1)
    public void userRegistration() throws InterruptedException {
        titlePage titlePageObject = new titlePage(driver);
        titlePageObject.clickOnMyAccountDropDown();
        registerPage registerPage = titlePageObject.clickOnRegisterButton();
        registerPage.inputFirstName(prop.getProperty("firstName"));
        registerPage.inputLastName(prop.getProperty("lastName"));
        registerPage.inputEmail(commonUtils.emailGeneration());
        registerPage.inputTelephone(prop.getProperty("telephoneNumber"));
        registerPage.inputPassword(prop.getProperty("password"));
        registerPage.inputConfirmPassword(prop.getProperty("confirmPassword"));
        registerPage.clickOnPrivacyPolicyCheckbox();
        successfulAccountCreationPage successfulAccountCreationPage = registerPage.ClickSubmitSuccess();
        String expectedMessageOne = "Your Account Has Been Created!";
        String actualMessageOne = successfulAccountCreationPage.accountCreationTitle();
        Assert.assertEquals(actualMessageOne, expectedMessageOne);
    }

    @Test (priority = 2)
    public void checkingSuccessfulMessagesOfRegistration() {
        titlePage titlePage = new titlePage(driver);
        titlePage.clickOnMyAccountDropDown();
        registerPage registerPage = titlePage.clickOnRegisterButton();
        registerPage.inputFirstName(prop.getProperty("firstName"));
        registerPage.inputLastName(prop.getProperty("lastName"));
        registerPage.inputEmail(commonUtils.emailGeneration());
        registerPage.inputTelephone(prop.getProperty("telephoneNumber"));
        registerPage.inputPassword(prop.getProperty("password"));
        registerPage.inputConfirmPassword(prop.getProperty("confirmPassword"));
        registerPage.clickOnPrivacyPolicyCheckbox();
        successfulAccountCreationPage AccountCreationPage = registerPage.ClickSubmitSuccess();
        String accountCreationtitle = "Your Account Has Been Created!";
        String expectedMessageTwo = "Congratulations! Your new account has been successfully created!";
        String expectedMessageThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String expectedMessageFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String expectedMessageFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
        Assert.assertEquals(AccountCreationPage.accountCreationTitle(), accountCreationtitle);
        Assert.assertEquals(AccountCreationPage.accountCreationMessageOne(), expectedMessageTwo);
        Assert.assertEquals(AccountCreationPage.accountCreationMessageTwo(), expectedMessageThree);
        Assert.assertEquals(AccountCreationPage.accountCreationMessageThree(), expectedMessageFour);
        Assert.assertEquals(AccountCreationPage.accountCreationMessageFour(), expectedMessageFive);
    }

    @Test (priority = 3)
    public void userLoginWithMismatchPassword() {
        titlePage titlePage = new titlePage(driver);
        titlePage.clickOnMyAccountDropDown();
        registerPage registerPage = titlePage.clickOnRegisterButton();
        registerPage.inputFirstName(prop.getProperty("firstName"));
        registerPage.inputLastName(prop.getProperty("lastName"));
        registerPage.inputEmail(commonUtils.emailGeneration());
        registerPage.inputTelephone(prop.getProperty("telephoneNumber"));
        registerPage.inputPassword(prop.getProperty("password"));
        registerPage.inputConfirmPassword(prop.getProperty("mismatchPassword"));
        registerPage.clickOnPrivacyPolicyCheckbox();
        registerPage.clickSubmitError();
        String ErrorMessage = "Password confirmation does not match password!";
        wait.until(ExpectedConditions.visibilityOf(registerPage.passwordErrorMessage));
        Assert.assertEquals(registerPage.passwordErrorMessage(), ErrorMessage);
    }

    @Test (priority = 4)
    public void invalidEmailIDRegistration() {
        titlePage titlePage = new titlePage(driver);
        titlePage.clickOnMyAccountDropDown();
        registerPage registerPage = titlePage.clickOnRegisterButton();
        registerPage.inputFirstName(prop.getProperty("firstName"));
        registerPage.inputLastName(prop.getProperty("lastName"));
        registerPage.inputEmail("naveensean");
        registerPage.inputTelephone(prop.getProperty("telephoneNumber"));
        registerPage.inputPassword(prop.getProperty("password"));
        registerPage.inputConfirmPassword(prop.getProperty("confirmPassword"));
        registerPage.clickOnPrivacyPolicyCheckbox();
        registerPage.clickSubmitError();
        String expectedMessageOne = "Please include an '@' in the email address. 'naveensean' is missing an '@'.";
        Assert.assertEquals(registerPage.email.getAttribute("validationMessage"), expectedMessageOne);
        registerPage.email.clear();
        registerPage.email.sendKeys("naveensean@");
        registerPage.clickSubmitError();
        String expectedMessageTwo = "Please enter a part following '@'. 'naveensean@' is incomplete.";
        Assert.assertEquals(registerPage.email.getAttribute("validationMessage"),expectedMessageTwo);
        registerPage.email.clear();
        registerPage.email.sendKeys("naveensean@email.");
        registerPage.clickSubmitError();
        String expectedMessageThree = "'.' is used at a wrong position in 'email.'.";
        Assert.assertEquals(registerPage.email.getAttribute("validationMessage"),expectedMessageThree);
    }

    @Test (priority = 5)
    public void registerWithoutTermsAndConditions() {
        titlePage titlePage = new titlePage(driver);
        titlePage.clickOnMyAccountDropDown();
        registerPage registerPage = titlePage.clickOnRegisterButton();
        registerPage.inputFirstName(prop.getProperty("firstName"));
        registerPage.inputLastName(prop.getProperty("lastName"));
        registerPage.inputEmail(commonUtils.emailGeneration());
        registerPage.inputTelephone(prop.getProperty("telephoneNumber"));
        registerPage.inputPassword(prop.getProperty("password"));
        registerPage.inputConfirmPassword(prop.getProperty("confirmPassword"));
        registerPage.clickSubmitError();
        String actualMessage = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(registerPage.privacyPolicyErrorMessage(),actualMessage);
    }
}
