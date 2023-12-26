package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private DriverFactory(){

    };

    static WebDriver driver;

    public static void initDriver(BrowserType browser){
        switch(browser){
            case FIREFOX:
                driver=new FirefoxDriver();
                break;
            case EDGE:
                driver=new EdgeDriver();
                break;
            default:
                driver=new ChromeDriver();
                break;
        }
        if(driver!=null)
            DriverManager.setDriver(driver);
        else
            throw new RuntimeException("WebDriver object is not initialized");
    }
}
