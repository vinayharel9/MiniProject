package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPassswordPage {

    private WebDriver driver;

    public SignInPassswordPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@type='password']")
    WebElement passwordInputBox;

    @FindBy(xpath="//*[text()='Next']")
    WebElement nextButton;


    public void inputpassword(String password)
    {
        passwordInputBox.sendKeys(password);
    }

    public void clickNext()
    {
        nextButton.click();
    }
}
