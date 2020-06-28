package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import util.Constant;
import util.PropertyLoader;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    /*
     * Factory method for getting browsers
     */
    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;
        String projectLoc = System.getProperty("user.dir");

        if (browserName.equalsIgnoreCase(Constant.BROWSER_FIREFOX)) {
            driver = drivers.get(Constant.BROWSER_FIREFOX);
            if (driver == null) {
                driver = new FirefoxDriver();
                drivers.put(Constant.BROWSER_FIREFOX, driver);
            }
        } else if (browserName.equalsIgnoreCase(Constant.BROWSER_IE)) {
            driver = drivers.get(Constant.BROWSER_IE);
            if (driver == null) {
                System.setProperty("webdriver.ie.driver",
                        projectLoc + "/src/main/resources/drivers/ie/iedriver");
                driver = new InternetExplorerDriver();
                drivers.put(Constant.BROWSER_IE, driver);
            }
        } else if (browserName.equalsIgnoreCase(Constant.BROWSER_CHROME)) {
            driver = drivers.get(Constant.BROWSER_CHROME);
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver",
                        projectLoc + "/src/main/resources/drivers/chrome/chromedriver");
                driver = new ChromeDriver();
                drivers.put(Constant.BROWSER_CHROME, driver);
            }
        }
        return driver;
    }
}