package Drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

    public static void setDriver(WebDriver driverObj){
        driver.set(driverObj);
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void dropDriverObj(){
        driver.remove();
    }

}
