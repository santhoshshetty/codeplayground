package demo.customassert;

import Drivers.BrowserType;
import Drivers.DriverFactory;
import Drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void launchTest(){
        DriverFactory.initDriver(BrowserType.CHROME);
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void quitTest(){
        DriverManager.getDriver().quit();
        DriverManager.dropDriverObj();
    }
}
