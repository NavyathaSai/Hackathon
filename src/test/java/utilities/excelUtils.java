package utilities; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtils{
	public static FileInputStream fileInput;
	public static FileOutputStream fileOutput;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;   
	
	public static String xlfile="./Excel/XLdata.xlsx";
	
	//Workbook--Worksheet--Row--cell<--cellData
	
	public static int getRowCount(String xlsheet) throws IOException 
	{
		fileInput=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fileInput);
		worksheet=workbook.getSheet(xlsheet);
		int rowcount=worksheet.getLastRowNum();
		workbook.close();
		fileInput.close();
		return rowcount;		
	}

	public static int getCellCount(String xlsheet,int rownum) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fileInput);
		worksheet=workbook.getSheet(xlsheet);
		row=worksheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fileInput.close();
		return cellcount;
	}

	public static String[] getCellData(String xlsheet,int rownum,int colnum) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fileInput);
		worksheet=workbook.getSheet(xlsheet);
		row=worksheet.getRow(rownum);
		String[] data=new String[colnum];
		for(int i=0;i<colnum;i++) {
			DataFormatter formatter = new DataFormatter();
			cell=row.getCell(i);
			data[i] = formatter.formatCellValue(cell); 
		}
		workbook.close();
		fileInput.close();
		return data;
	}

	public static void setCellData(String xlsheet,int rownum,int colnum, String data) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fileInput);
		if(workbook.getSheetIndex(xlsheet)==-1) {
			workbook.createSheet(xlsheet);
		}
		worksheet=workbook.getSheet(xlsheet);
		
		row=worksheet.getRow(rownum);
		if(row==null) {
			row=worksheet.createRow(rownum);
		}
		//row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fileOutput=new FileOutputStream(xlfile);
		workbook.write(fileOutput);		
		workbook.close();
		fileInput.close();
		fileOutput.close();
	}


}