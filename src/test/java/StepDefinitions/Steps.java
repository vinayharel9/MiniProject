package StepDefinitions;

import PageObjectModel.SignInPage;
import PageObjectModel.SignInPassswordPage;
import PageObjectModel.SignInUsernamePage;
import PageObjectModel.gmailHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    WebDriver driver = null;


    @Given("user navigates to gmail login page")
    public void user_navigates_to_gmail_login_page() {

        String project_path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",project_path+"/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        SignInPage sign = new SignInPage(driver);
        driver.get("https://www.google.com/intl/en-GB/gmail/about/");
        sign.clickSignIn();
    }


    @And("enters valid username as {string} and password as {string}")
    public void entersValidUsernameAsAndPasswordAs(String emailId, String password) throws InterruptedException {

        SignInUsernamePage usernamepage = new SignInUsernamePage(driver);
        usernamepage.inputEmail(emailId);
        usernamepage.clickNext();
        SignInPassswordPage passwordpage = new SignInPassswordPage(driver);
        passwordpage.inputpassword(password);
        passwordpage.clickNext();
        Thread.sleep(10000); // Added this wait so that user authorizes by clicking 'yes its me' permission on his gmail registered mobile phone
    }

    @Given("User is landed on gmail home page")
    public void user_is_landed_on_gmail_home_page() {
        gmailHomePage sign = gmailHomePage.getInstanceOfgmailHomePage(driver);
        sign.validateComposeButton();
    }
    @When("User clicks on Compose Button")
    public void user_clicks_on_compose_button() {
        gmailHomePage sign = gmailHomePage.getInstanceOfgmailHomePage(driver);
        sign.clickComposeButton();
    }

    @When("enters email subject as {string}")
    public void enters_email_subject_as(String subject) {
        gmailHomePage sign = gmailHomePage.getInstanceOfgmailHomePage(driver);
        sign.subjectBox(subject);

    }
    @When("body as {string}")
    public void body_as(String message) {
        gmailHomePage sign = gmailHomePage.getInstanceOfgmailHomePage(driver);
        sign.MessageBox(message);

    }
    @And("sender as {string} and clicks on send button")
    public void senderAsAndClicksOnSendButton(String recipient)  {
        gmailHomePage sign = gmailHomePage.getInstanceOfgmailHomePage(driver);
        sign.Recipients(recipient);
    }

    @Then("Mail should be submitted successfully")
    public void mail_should_be_submitted_successfully() {
        gmailHomePage sign = gmailHomePage.getInstanceOfgmailHomePage(driver);
        sign.sentOption();
        sign.sentMessage();
    }

}
