
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RisklandscapePage {
    public WebDriver ldriver;
    WaitHelper waitHelper;
    public RisklandscapePage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
        waitHelper= new WaitHelper(ldriver);
    }

    @FindBy (xpath = "//div[@class='card card--inline card--column card--five']")
    List<WebElement> listOfcountriesInNewSupplyChainRiskTrends;

    @FindBy (xpath = "//div[@class='l-cell-m-12 u-mb-20']//a[contains(text(),'View all trends')]")
    WebElement bttnViewAllTrends;

    @FindBy (xpath = "//h1[contains(text(),'Geography risk landscape')]")
    WebElement titleGeographyRiskLandscape;

    @FindBy (xpath = "//h1[contains(text(),'Global risk landscape')]")
    WebElement titleGlobalRiskLandscape;

    @FindBy (xpath = "//label[contains(text(),'Select country or region')]/..//span[@class='Select-value-label']")
    WebElement valueFilterGeographyrisklandscape;

    @FindBy (xpath = "(//div[@class='card card--inline card--column card--five'])[1]//label")
    WebElement countryNameOnCard;

    @FindBy (xpath = "(//div[@class='card card--inline card--column card--five'])[1]//a")
    WebElement bttnViewScoreBoard;

    String countryName;

    public void verifyUserIsOnDashboardScreen(){
        Assert.assertEquals(5,listOfcountriesInNewSupplyChainRiskTrends.size());
        Assert.assertTrue(bttnViewAllTrends.isDisplayed());
    }

    public void clickViewScoreBoardForSpecificCountry(String country) {
        waitHelper.WaitForElement(countryNameOnCard,30000);
        countryName= countryNameOnCard.getText();
        bttnViewScoreBoard.click();
    }
    public void verifyUserNavigateToGeographylandscape(){
        waitHelper.WaitForElement(titleGeographyRiskLandscape,30000);
        Assert.assertTrue(titleGeographyRiskLandscape.isDisplayed());
        waitHelper.WaitForElement(valueFilterGeographyrisklandscape,30000);
        Assert.assertEquals(countryName,valueFilterGeographyrisklandscape.getText());
    }
    public void verifyUserNavigateToGloballandscape(){
        waitHelper.WaitForElement(titleGlobalRiskLandscape,30000);
        Assert.assertTrue(titleGlobalRiskLandscape.isDisplayed());
    }
    public void clickOnViewAlltrends() {
        waitHelper.WaitForElement(bttnViewAllTrends,30000);
        bttnViewAllTrends.click();
    }
}
