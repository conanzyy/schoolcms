package com.cuckoo.cms.common.excel;

import java.util.List;

import lombok.Data;
@Data
public class SheetPojo {
	//sheet中各列的宽
private int[]columWidths;
//sheet中各列的的名称
private String[]columNames;
//sheet中各行的数据
private List<String[]> sheetData;
//sheet的名称
private String sheetName;

private List<Object[]> cellData;


public SheetPojo(){
	
}

public SheetPojo(String[]columNames,String sheetName,List<String[]>data){
this.setColumNames(columNames);
this.setSheetName(sheetName);
this.setSheetData(data);
}



}