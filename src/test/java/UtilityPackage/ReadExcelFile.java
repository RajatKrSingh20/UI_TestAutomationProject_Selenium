package UtilityPackage;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcelFile {

    FileInputStream fileInputStream;
    XSSFWorkbook workbook;
    Object[][] arr ;

    public ReadExcelFile(String fileName){

        try{
            fileInputStream = new FileInputStream("C:\\Users\\rajat\\IdeaProjects\\UI_TestAutomationProject_Selenium\\src\\test\\TestData\\"+fileName+".xlsx");
            workbook = new XSSFWorkbook(fileInputStream);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }

    public int totalRows( int SheetIndex ){

       return workbook.getSheetAt(SheetIndex).getLastRowNum()+1;

    }

    public int totalCells( int SheetIndex ){

        return workbook.getSheetAt(SheetIndex).getRow(0).getLastCellNum();

    }

    public Object[][] getExcelData(  int SheetIndex){

        int rows  = totalRows(SheetIndex);
        int cells = totalCells(SheetIndex);

        arr = new Object[rows][cells];

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cells; j++){

                String cellValue = workbook.getSheetAt(SheetIndex).getRow(i).getCell(j).toString();

                arr[i][j] = cellValue;
            }
        }
        return arr ;

    }







}
