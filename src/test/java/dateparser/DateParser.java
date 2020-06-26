package dateparser;

import Entity.DateEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Map;

import util.Constant;
import util.ExcelUtils;
import util.Log;
import util.TestFramework;

public class DateParser extends TestFramework {


    @Test(dataProvider = "data")
    public void verifyDateParser(Map<Object, Object> map) throws Exception {

        DateEntity testData = new DateEntity(map);
        String actualOutput="";
        String expectedOutput="";
        try{

        Log.startTestCase(testData.getTestcaseName());

        HomePage homepage = new HomePage(driver);
        homepage.inputDate(testData.getInput());
        homepage.clickSubmit();

        actualOutput = homepage.getResult();
        expectedOutput = testData.getExpectedOutput();
        Assert.assertEquals(actualOutput, expectedOutput, "Pass");
        ExcelUtils.updateResults(Constant.PASS,actualOutput,testData);
        Log.info("PASSED - Date formatting successul");
        Log.endTestCase(testData.getTestcaseName());

        }catch (AssertionError e) {
            ExcelUtils.updateResults(Constant.FAIL,actualOutput,testData);
            Log.error("FAILED - Assertion Error Occurred " +e.getMessage());
            throw(e);
        }
        catch (Exception e) {
            ExcelUtils.updateResults(Constant.FAIL,actualOutput,testData);
            Log.error("Exception Occurred" +e.getMessage());
            throw(e);
        }
    }
}

