package com.epm.fta.dataprovider;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadTestData {

    XSSFWorkbook excelWorkbook = null;
    XSSFSheet excelSheet = null;
    XSSFRow row = null;
    XSSFCell cell = null;



    public Object[][] getDataObjects( int rowCount, int colCount) {
        Object data[][] = new Object[rowCount-1][colCount];
        for (int rNum = 2; rNum <= rowCount; rNum++)
        {
            for (int cNum = 0; cNum < colCount; cNum++)
            {
                System.out.print(getCellData("ExcelDemo", cNum, rNum) + " "); // Your sheet name
                data[rNum-2][cNum] = getCellData("ExcelDemo", cNum, rNum).toString(); //Your sheet name
            }
            System.out.println("");
        }

        return data;
    }

    public void readData() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Automation-Projects\\FTAFramework\\src\\test\\java\\resources\\TestData.xlsx"); // Your .xlsx file name along with path
        excelWorkbook = new XSSFWorkbook(fis);
        // Read sheet inside the workbook by its name
        excelSheet = excelWorkbook.getSheet("ExcelDemo"); //Your sheet name
        // Find number of rows in excel file
        System.out.println("First Row Number/index:"+ excelSheet.getFirstRowNum() + " *** Last Row Number/index:"
                + excelSheet.getLastRowNum());
    }

    public int getColCount() {
        return excelSheet.getRow(0).getLastCellNum();
    }

    public int getRowCount() {
        return excelSheet.getLastRowNum() - excelSheet.getFirstRowNum()+1;
    }


    // Function will always used as below. It returns the data from a cell - No need to make any changes
    public String getCellData(String sheetName, int colNum, int rowNum)
    {
        try
        {
            if (rowNum <= 0)
                return "";
            int index = excelWorkbook.getSheetIndex(sheetName);
            if (index == -1)
                return "";
            excelSheet = excelWorkbook.getSheetAt(index);
            row = excelSheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(colNum);
            if (cell == null)
                return "";
            if (cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue();
            else if (cell.getCellType() == CellType.NUMERIC
                    || cell.getCellType() == CellType.FORMULA)
            {
                String cellText = String.valueOf(cell.getNumericCellValue());
                return cellText;
            } else if (cell.getCellType() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        } catch (Exception e)
        {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colNum
                    + " does not exist in xls";
        }
    }

}
