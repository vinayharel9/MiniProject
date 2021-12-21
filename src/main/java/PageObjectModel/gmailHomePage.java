package PageObjectModel;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class gmailHomePage {

    public WebDriver driver;

    public gmailHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    // declaring an instance of class gmailHomePage which is null initially means not initialized.
    private static gmailHomePage instanceOfgmailHomePage= null;

    // Declaring constructor as private to restrict object creation outside of class
    private gmailHomePage()
    {
    }

    // static method to create instance of class gmailHomePage
    public static gmailHomePage getInstanceOfgmailHomePage(WebDriver driver)
    {
        if (instanceOfgmailHomePage == null)
            instanceOfgmailHomePage = new gmailHomePage(driver);

        return instanceOfgmailHomePage;
    }

    @FindBy(xpath="//div[@id=':m5']/div/div")
    WebElement ComposeButton;

    @FindBy(xpath="//*[text()='Recipients']")
    WebElement Recipients;

    @FindBy(xpath="//input[@name='subjectbox']")
    WebElement SubjectBox;

    @FindBy(xpath="//div[@id=':sx']")
    WebElement MessageBox;

    @FindBy(xpath="//div[@id=':rh']")
    WebElement SendButton;

    @FindBy(xpath="//*[text()='Sent']")
    WebElement Sent;

    @FindBy(xpath="//*[text()='Message sent']")
    WebElement SentMessage;

    public void validateComposeButton()
    {
        if(ComposeButton.isDisplayed())
        {
            System.out.println("Compose Button is displayed");
        }
        else
        {
            throw new ElementNotVisibleException("Compose button is not visible");
        }
    }

    public void clickComposeButton()
    {
        ComposeButton.click();
    }

    public void Recipients(String recipient)
    {
        Recipients.click();
        Recipients.sendKeys();
        SendButton.click();
    }

    public void subjectBox(String Subject)
    {
        SubjectBox.click();
        SubjectBox.sendKeys(Subject);
    }

    public void MessageBox(String Message)
    {
        MessageBox.click();
        MessageBox.sendKeys(Message);
    }

    public void sentOption()
    {
        Sent.click();
    }
    public void sentMessage()
    {
        if(SentMessage.isDisplayed())
        {
            System.out.println("Message is sent successfully");
        }
        else
        {
            throw new ElementNotVisibleException("Message is not sent successfully");
        }
    }

}
