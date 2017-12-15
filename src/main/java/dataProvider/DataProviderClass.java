package dataProvider;

import org.testng.annotations.DataProvider;
import excelRead.ExcelReadClass;
import utility.utility;

public class DataProviderClass {

	@DataProvider(name = "LoginFunctionality")
    public static Object[][] FetchData() throws Exception{
		String ExcelPath = utility.getDataRepoFilePath();
        Object[][] retObjArr= ExcelReadClass.getTableArray(ExcelPath ,
                "Sheet1", "testdata1");
        return(retObjArr);
    }
}
