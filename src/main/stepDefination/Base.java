import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Base {
    public WebDriver driver;
    public LoginPage loginPage;
    public RisklandscapePage risklandscapePage;

    public static Logger logger;
    public Properties configProp;

}