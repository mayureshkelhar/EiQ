
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;
    WaitHelper waitHelper;
    public LoginPage (WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
        waitHelper= new WaitHelper(ldriver);
    }
    @FindBy(xpath = "//img[@class='l-login__logo']")
    WebElement logoElevate;

    @FindBy(xpath = "//form[@id='newUser']/h2")
    WebElement titleLogin;

    @FindBy(xpath = "//label[@for='user_email']")
    WebElement labelEmail;

    @FindBy(xpath = "//label[@for='user_password']")
    WebElement labelPassword;

    @FindBy(id = "user_email")
    WebElement fieldEmail;

    @FindBy(id = "user_password")
    WebElement fieldPassword;

    @FindBy(id = "login-btn")
    WebElement btnLogin;

    @FindBy(xpath = "(//div[@class='card card--inline card--row '])[1]")
    WebElement AuditSummaryCard;

    public void setCredential(String userName,String password) throws InterruptedException{
        waitHelper.WaitForElement(logoElevate,60000);
        Assert.assertTrue(titleLogin.isDisplayed());
        Assert.assertTrue(labelEmail.isDisplayed());
        Assert.assertTrue(labelPassword.isDisplayed());
        fieldEmail.sendKeys(userName);
        fieldPassword.sendKeys(password);

    }
    public void clickLogin(){
        btnLogin.click();
        waitHelper.WaitForElement(AuditSummaryCard,60000);
        Assert.assertTrue(AuditSummaryCard.isDisplayed());
    }
}
