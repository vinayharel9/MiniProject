package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInUsernamePage {

    private WebDriver driver;

    public SignInUsernamePage(WebDriver driver) {
        this.driver=driver;
         PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@type='email']")
    WebElement emailInputBox;

    @FindBy(xpath="//*[text()='Next']")
    WebElement nextButton;

    public void inputEmail(String email)
    {
        emailInputBox.click();
        emailInputBox.sendKeys(email);
    }

    public void clickNext()
    {
        nextButton.click();
    }
}
