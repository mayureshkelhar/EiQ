import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class LoginSteps extends Base{

    @Before
    public void setup() throws IOException,InterruptedException {
        configProp = new Properties();
        FileInputStream configPropfile= new FileInputStream("config.properties");
        configProp.load(configPropfile);

        logger = Logger.getLogger("EiQ Anlysis");
        PropertyConfigurator.configure("log4j.properties");

        String browserName = configProp.getProperty("browser");
        System.out.println("browser name:"+browserName);

        //~~~~~ As of now property defined for chrome browser only ~~~~~~~~

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
            driver = new ChromeDriver();
            logger.info("launching browser");
            driver.manage().window().maximize();
            Thread.sleep(4000);
        }

        loginPage=new LoginPage(driver);
        driver.get (configProp.getProperty("url"));
        logger.info ("launching URL");
        Thread.sleep(30000);
        risklandscapePage = new RisklandscapePage(driver);

    }

    @After
    public void endOfScenario(){
        driver.quit();
    }

    @Given("Login to EiQ application with valid username")
    public void loginToWebsite() throws InterruptedException {
        loginPage.setCredential(configProp.getProperty("username"),configProp.getProperty("password"));
        loginPage.clickLogin();
        logger.info("user click login button");
    }

    @Given("user is on dashboard screen")
    public void user_is_on_dashboard_screen() {

        risklandscapePage.verifyUserIsOnDashboardScreen();
        logger.info("user is on Dashboard screen");
    }
    @When("user select country {string} View scorecard from the countries list of New Supply chain risk trends section")
    public void user_select_country_view_scorecard_from_the_countries_list_of_new_supply_chain_risk_trends_section(String countryToBeSelect) {
        risklandscapePage.clickViewScoreBoardForSpecificCountry(countryToBeSelect);
        logger.info("user click on view score button");
    }
    @Then("verify user navigate to Geography risk landscape screen")
    public void verify_user_navigate_Geography_risk_landscape() {
        risklandscapePage.verifyUserNavigateToGeographylandscape();
        logger.info("user navigate to Geography risk");
    }
    @Then("user click on View All Trends button")
    public void userclickOnViewAlltrends() {
        risklandscapePage.clickOnViewAlltrends();
        logger.info("user is on Viewall button ");
    }
    @Then("verify user navigate to Global risk landscape screen")
    public void verify_user_navigate_Global_risk_landscape() {
        risklandscapePage.verifyUserNavigateToGloballandscape();
        logger.info("user navigate to global risk landscape ");
    }
}
