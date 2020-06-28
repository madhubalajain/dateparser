package util;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import webdriver.BrowserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestFramework {

    public WebDriver driver;
    private String testcaseName;


    @BeforeSuite
    public void beforeSuite() {
        //Set the Logger
        PropertyConfigurator.configure("log4j.properties");
        //Load the property from application.properties
        PropertyLoader.loadProperty();
    }


    @BeforeMethod
    public void beforeClass() {
        String browser = PropertyLoader.getProperty(Constant.BROWSER);
        driver = BrowserFactory.getBrowser(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = PropertyLoader.getProperty(Constant.URL);
        driver.get(url);
    }


    @DataProvider(name = "data")
    public Object[][] dataSupplier() throws Exception {

        String fileLoc = System.getProperty("user.dir")+ Constant.Path_TestData + Constant.File_TestData;
        File file = new File(fileLoc);
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        Object[][] obj = new Object[lastRowNum][1];

        for (int i = 0; i < lastRowNum; i++) {
            Map<Object, Object> datamap = new HashMap<Object, Object>();
            for (int j = 0; j < lastCellNum; j++) {

                String key = sheet.getRow(0).getCell(j).toString();
                if (key.equals(Constant.STATUS) || key.equals(Constant.ACTUAL_OUTPUT) || key.equals(Constant.UPDATED_ON)) {
                    ExcelUtils.setCellData("", i + 1, j);
                } else {
                    String value = sheet.getRow(i + 1).getCell(j).toString();
                    datamap.put(key, value);
                }
            }
            datamap.put("row", i + 1);
            datamap.put("col", lastCellNum - 3);

            obj[i][0] = datamap;

        }
        return obj;
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
