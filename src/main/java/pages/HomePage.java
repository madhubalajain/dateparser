package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import webdriver.SeleniumFactory;


public class HomePage extends Page {

    private final String DATE_INPUT = "date";
    //ToDo - Enhance the use ID or Name
    private final String SUBMIT_BUTTON = "/html/body/div[2]/div/div[1]/form/input";
    private final String RESULT_TXT = "/html/body/div[2]/div/div[2]/div";

    @FindBy(how = How.NAME, using = DATE_INPUT)
    private WebElement txtbox_date;

    @FindBy(how = How.XPATH, using = SUBMIT_BUTTON)
    private WebElement btn_submit;

    @FindBy(how = How.XPATH, using = RESULT_TXT)
    private WebElement txt_result;

    public HomePage(WebDriver webDriver) {

        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void inputDate(String date) throws Exception {
        SeleniumFactory.sendKeys(txtbox_date, date, "Entering date in the input box");
    }

    public void clickSubmit() throws Exception {
        SeleniumFactory.click(btn_submit, "Clicking submit button");
    }

    public String getResult() throws Exception {
        return SeleniumFactory.getText(txt_result, "Reading formatted date output");
    }
}
