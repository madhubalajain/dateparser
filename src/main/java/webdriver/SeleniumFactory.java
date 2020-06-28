package webdriver;

import org.openqa.selenium.WebElement;
import util.Log;

public class SeleniumFactory {

    public static void click(WebElement element, String msg) throws Exception {
        try {
            element.click();
            Thread.sleep(5000);
            Log.info(msg);
        } catch (Exception e) {
            Log.error("Exception - " +msg);
            throw(e);
        }
    }

    public static void sendKeys(WebElement element, String input, String msg) throws Exception {
        try {
            element.sendKeys(input);
            Thread.sleep(1000);
            Log.info(msg + "- " + input);
        } catch (Exception e) {
            Log.error("Exception - " +msg);
            throw(e);
        }
    }

    public static String getText(WebElement element, String msg) throws Exception {
        try {
            String txt = element.getText();
            Log.info(msg+" - " + txt);
            return txt;
        } catch (Exception e) {
            Log.error("Exception - " + msg);
            throw(e);
        }
    }
}
