How to run the code -

1. From Terminal, run following command from project root folder
mvn clean install

2. From IDE,
Run class, DateParser or Run testng.xml

How to check the results -
The Test results are updated itself in testdata.xls everytime, when the testcases are run. Please ckeck the Status,ActualOutput,UpdatedOn coloumns in testdata.xls once the test exceution is completed. The location of testdata.xls is - /src/test/resources/testdata.

For more details on the execution logs, please check TestExecution.logs in root folder



Enhancements -

1. Currently the code works fine on MAC or Linux based operation system. For window, the code need to be enhanced, as the directory structure works dirrently on it.

2. The code is tested on Chrome and chromedriver is already included. For firefox and IE, this need to be tested.
If you wish to test on IE or Firfox, please update application.properties accordingly.




