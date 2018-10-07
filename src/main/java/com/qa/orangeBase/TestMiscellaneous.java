package com.qa.orangeBase;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.util.OrangeUtil;

public class TestMiscellaneous {

	public static void main(String[] args) 
	{
		OrangeUtil.getData("orange");
		//getData("orange"); 
	}
		public static Object[][] getData(String sheetname) 
		{
			Sheet s = null;
			int datasets=0;
			int colNums =0;
			File f = new File("C:\\Users\\Maahi\\eclipse-workspace\\OHRM\\src\\main\\java\\com\\qa\\util\\testdata.xlsx");
			try {
				Workbook book = null;
				try {
					book = WorkbookFactory.create(f);
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 s = book.getSheet(sheetname);
				datasets = s.getLastRowNum();
				colNums = s.getRow(0).getLastCellNum();
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Object[][] data = new Object[datasets][colNums];
			for(int i=0;i<=datasets;i++) 
			{
				for(int j=0;j<datasets;j++)
				{
					data[i][j] = s.getRow(i).getCell(j).getStringCellValue();
					System.out.println(data[i][j]);
				}
						
			}
			
			return data;
			
		}

	}


