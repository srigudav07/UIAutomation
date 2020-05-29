package com.epm.fta.dataprovider;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class TestDataProviderFromExcel {

    @DataProvider // supplying data for a test method.
    public Object[][] getData() throws IOException
    {
        ReadTestData readTestData = new ReadTestData();
        readTestData.readData();
        System.out.println("Row Count is: " +readTestData.getRowCount()
                + " *** Column count is: " + readTestData.getColCount());
        Object[][] data = readTestData.
                getDataObjects( readTestData.getRowCount(),readTestData.getRowCount() );
        System.out.println("data"+  data.length);
        return data;
    }


@DataProvider
    public Object[][] getDataa() throws IOException
    {
        Object[][] data = new Object[][] { { "data one" }, { "data two" } };
        return data;
    }


}

