package com.cuckoo.cms.common.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;

@Data
public class Excel {
	private static final Logger LOGGER = LoggerFactory.getLogger(Excel.class);
	private String excelName;

	private String excelPath;

	private List<SheetPojo> sheets;

	public Excel() {

	}

	public Excel(String excelName, String excelPath, List<SheetPojo> sheetList) {

		this.setExcelName(excelName);
		this.setSheets(sheetList);
		this.setExcelPath(excelPath);
	}

	public String exportExcel() {

		if (sheets == null) {
			return excelName;
		}

		HSSFWorkbook wb = new HSSFWorkbook();

		int size = sheets.size();

		SheetPojo sheet = null;

		HSSFSheet sheetExcel = null;

		List<String[]> sheetData = null;

		String[] sheetColumNames = null;
		int[] sheetColumWidths = null;

		HSSFRow row = null;
		HSSFRow rowContent = null;
		String[] data = null;
		int sizeLen = 0;

		for (int i = 0; i < size; i++) {
			sheet = sheets.get(i);
			sheetExcel = wb.createSheet(sheet.getSheetName());

			sheetData = sheet.getSheetData();
			sheetColumNames = sheet.getColumNames();
			sheetColumWidths = sheet.getColumWidths();

			row = sheetExcel.createRow(0);

			if (sheetColumNames != null) {
				for (int j = 0; j < sheetColumNames.length; j++) {

					if (sheetColumWidths != null && sheetColumWidths.length > j) {
						sheetExcel.setColumnWidth(j, sheetColumWidths[j]);
					} else {
						sheetExcel.setColumnWidth(j, 5000);
					}

					row.createCell(j).setCellValue(sheetColumNames[j]);

				}
			}

			if (sheetData != null) {
				sizeLen = sheetData.size();

				for (int j = 0; j < sizeLen; j++) {
					rowContent = sheetExcel.createRow(j + 1);
					data = sheetData.get(j);
					rowContent.createCell(0).setCellValue(j + 1);

					for (int k = 0; k < data.length; k++) {
						rowContent.createCell(k + 1).setCellValue(data[k]);
					}
				}

			}
		}

		writeExcelFile(wb, excelPath);

		return excelName;

	}

	private static void writeExcelFile(HSSFWorkbook wb, String excelPath) {

		FileOutputStream fileOut = null;

		try {
			File file = FileUtils.getFile(new String[] { excelPath });

			fileOut = FileUtils.openOutputStream(file);

			wb.write(fileOut);
		} catch (IOException e) {

			LOGGER.error("wb IOException.");
		}

		finally {

			if (fileOut != null) {
				try {
					fileOut.close();
				} catch (IOException e) {
					LOGGER.error("close wb failed.");
				}
			}
		}

	}

	public void exportExcel(HttpServletResponse response) {

		if (sheets == null) {
			LOGGER.error("导出失败");
			return;
		}

		HSSFWorkbook wb = new HSSFWorkbook();

		int size = sheets.size();

		SheetPojo sheet = null;

		HSSFSheet sheetExcel = null;

		List<String[]> sheetData = null;

		String[] sheetColumNames = null;
		int[] sheetColumWidths = null;

		HSSFRow row = null;
		HSSFRow rowContent = null;
		String[] data = null;
		int sizeLen = 0;

		for (int i = 0; i < size; i++) {
			sheet = sheets.get(i);
			sheetExcel = wb.createSheet(sheet.getSheetName());

			sheetData = sheet.getSheetData();
			sheetColumNames = sheet.getColumNames();
			sheetColumWidths = sheet.getColumWidths();

			row = sheetExcel.createRow(0);

			if (sheetColumNames != null) {
				for (int j = 0; j < sheetColumNames.length; j++) {

					if (sheetColumWidths != null && sheetColumWidths.length > j) {
						sheetExcel.setColumnWidth(j, sheetColumWidths[j]);
					} else {
						sheetExcel.setColumnWidth(j, 5000);
					}

					row.createCell(j).setCellValue(sheetColumNames[j]);

				}
			}

			if (sheetData != null) {
				sizeLen = sheetData.size();

				for (int j = 0; j < sizeLen; j++) {
					rowContent = sheetExcel.createRow(j + 1);
					data = sheetData.get(j);
					rowContent.createCell(0).setCellValue(j + 1);

					for (int k = 0; k < data.length; k++) {
						rowContent.createCell(k + 1).setCellValue(data[k]);
					}
				}

			}
		}
		try {
			System.out.println(excelName);
			System.out.println(excelPath);
			response.setContentType("application/vnd.ms-excel");   
		    response.setHeader("Content-disposition", "attachment;filename=" + excelName);   
			wb.write(response.getOutputStream());
		} catch (IOException e) {
			LOGGER.error("导出失败");
		}
	}
}
