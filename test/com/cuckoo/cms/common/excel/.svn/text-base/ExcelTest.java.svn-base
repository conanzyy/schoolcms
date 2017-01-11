package com.cuckoo.cms.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class ExcelTest {
//表单列宽
	private static final int SHEET_COLUMN_WIDTH = 6000;
	//列表初始化大小
	private static final int LIST_SIZE_INIT = 3;
//sheet最大记录数
	private static final int SHEET_MAX_LINE_COUNT = 65535;

	@Test
	public void exportExcel() {

		String curTime=System.currentTimeMillis()+"";
		
		String localPath="d:\\test"+File.separator+curTime;
		
		String fileName="test_"+curTime+"_temp.xls";
		File dir=new File(localPath);
		
		if(!dir.exists()){
			if(!dir.mkdirs()){
				return;
			}
		}
		
		Excel excel=new Excel();
		
		excel.setExcelName(fileName);
		excel.setExcelPath(localPath+File.separator+fileName);
		
		List<List<String[]>> sheetsData=new ArrayList<List<String[]>>(LIST_SIZE_INIT);
		
		
		//要导出的数据集合
		List<String> demoList=new ArrayList<String>();
		demoList.add("test1");
		demoList.add("test2");
		
		getSheet(demoList,sheetsData);
		
		//表单的列名
		String[] sheetColumNames=new String[]{"序号","测试1","测试2"};
		//各个列宽
		int[] sheetColumWidth=new int[]{SHEET_COLUMN_WIDTH,SHEET_COLUMN_WIDTH};
		
		List<SheetPojo> sheetList=new ArrayList<SheetPojo>(LIST_SIZE_INIT);
		
		int sheetDataSize=sheetsData.size();
		
		SheetPojo sheet=null;
		
		
		for(int i=0;i<sheetDataSize;i++){
			sheet=new SheetPojo();
			sheet.setColumNames(sheetColumNames);
			sheet.setColumWidths(sheetColumWidth);
			sheet.setSheetName("测试sheet"+(i+1));
			sheet.setSheetData(sheetsData.get(i));
			sheetList.add(sheet);
			
		}
		
		excel.setSheets(sheetList);
		excel.exportExcel();
	
	}

	
	private static void getSheet(List<String> demoList,List<List<String[]>> sheetsData){
		
		
		List<String[]> sheetData=new ArrayList<String[]>(LIST_SIZE_INIT);
		
		int size=demoList.size();
		for(int i=0;i<size;i++){
			if(i!=0&&i%SHEET_MAX_LINE_COUNT==0){
				sheetsData.add(sheetData);
				sheetData=new ArrayList<String[]>(LIST_SIZE_INIT); 
			}else{
				getSheetData(sheetData,demoList.get(i));
			}
			
	
			
			
		}
	
		if(sheetData.size()>0){
			sheetsData.add(sheetData);
		}
		
	}
	
	
	private static void getSheetData(List<String[]> sheetData,String test){
		
		sheetData.add(new String[]{test,test});
		
	}
	
	
	@Test
	public void loadScoreInfo() throws IOException{  
		String xlsPath="D:\\test\\1481035808631\\test_1481035808631_temp.xls";
	    List<String> temp = new ArrayList<String>();  
	FileInputStream fileIn = new FileInputStream(xlsPath);  

	Workbook wb0 = new HSSFWorkbook(fileIn);  
	//获取Excel文档中的第一个表单  
	Sheet sht0 = (Sheet) wb0.getSheetAt(0);  
	//对Sheet中的每一行进行迭代  
	        for (Row r : sht0) {  
	    
	if(r.getRowNum()<1){  
	continue;  
	}  
	//创建实体类  
	StringBuilder s=new StringBuilder();  
	//取出当前行第1个单元格数据
	s.append(r.getCell(0).getNumericCellValue());  
	s.append(r.getCell(1).getStringCellValue());  
	s.append(r.getCell(2).getStringCellValue()); 
	
	temp.add(s.toString());  
	        }  
	        fileIn.close();      
	     System.out.println(temp.toString());    
	    }  
	
}
