package PageObjectModel;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[text()='Sign in']")
    WebElement SignInButton;

    public void clickSignIn()
    {
        SignInButton.click();
    }

}
