package Entity;

import util.Constant;

import java.util.Map;

public class DateEntity {

    public String testcaseName;
    public String testcaseDescription;
    public String input;
    public String expectedOutput;
    public int row;
    public int col;

    public DateEntity(Map<Object, Object> map) {
        testcaseName = map.get(Constant.TESTCASE_NAME).toString();
        testcaseDescription = map.get(Constant.TESTCASE_DESCRIPTION).toString();
        input = map.get(Constant.INPUT).toString();
        expectedOutput = map.get(Constant.EXPECTED_OUTPUT).toString();
        row = (Integer) map.get(Constant.ROW);
        col = (Integer) map.get(Constant.COL);
    }

    public String getTestcaseName() {
        return testcaseName;
    }

    public String getTestcaseDescription() {
        return testcaseDescription;
    }

    public String getInput() {
        return input;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
