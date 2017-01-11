package com.cuckoo.cms.teacher.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cuckoo.cms.common.BaseController;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.excel.Excel;
import com.cuckoo.cms.common.excel.SheetPojo;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.teacher.pojo.Job;
import com.cuckoo.cms.teacher.pojo.MentalHealth;
import com.cuckoo.cms.teacher.pojo.req.MentalHealthReq;
import com.cuckoo.cms.teacher.service.MentalHealthService;

@Controller
public class MentalHealthController extends BaseController {
	@Autowired
	private MentalHealthService mentalHealthService;
	//教师获取心理健康信息列表
	@RequestMapping(value = "/getMentalHealthList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMentalHealthList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", mentalHealthService.getMentalHealthList(tenantId));
		return responseMap;
	}
	
	//教师获取心理健康信息详情
	@RequestMapping(value = "/getMentalHealthInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMentalHealthInfo(
			@RequestParam(value="healthId") String healthId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMapin = new HashMap<String, Object>();
		//User user = SessionUtil.getUserInfo(request);
		responseMapin.put("stuName",mentalHealthService.getMentalHealthInfo(healthId).getMentalHealthInfo().getStuName());
		responseMapin.put("stuNum",mentalHealthService.getMentalHealthInfo(healthId).getMentalHealthInfo().getStuNum());
		responseMapin.put("proName",mentalHealthService.getMentalHealthInfo(healthId).getMentalHealthInfo().getProName());
		responseMapin.put("className",mentalHealthService.getMentalHealthInfo(healthId).getMentalHealthInfo().getClassName());
		responseMapin.put("result",mentalHealthService.getMentalHealthInfo(healthId).getMentalHealthInfo().getResult());
		responseMapin.put("createTime",mentalHealthService.getMentalHealthInfo(healthId).getMentalHealthInfo().getCreateTime());
		responseMapin.put("way",mentalHealthService.getMentalHealthInfo(healthId).getMentalHealthInfo().getWay());
		responseMapin.put("record",mentalHealthService.getMentalHealthInfo(healthId).getMentalHealthInfo().getRecord());
		responseMapin.put("step",mentalHealthService.getMentalHealthInfo(healthId).getMentalHealthInfo().getStep());
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		responseMap.put("data",responseMapin);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	//教师编辑学生心理健康信息
	@RequestMapping(value = "/updateMentalHealth", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateMentalHealth(@Valid  MentalHealthReq mentalHealthReq,BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		mentalHealthService.updateMentalHealth(mentalHealthReq);
		//practiceService.updatePractice(practiceDelReq, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//删除心理健康信息
	@RequestMapping(value = "/deleteMentalHealth", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteMentalHealth(@Valid String healthId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		mentalHealthService.deleteMentalHealth(healthId);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}

	//删除多条心理健康信息
	@RequestMapping(value = "/deleteMentalHealthAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteMentalHealthAll(@Valid @RequestBody HashMap<String, Object> healthIdMap,
			HttpServletRequest request) throws MsgException {
		System.out.println(healthIdMap);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		ArrayList<String> healthIds= (ArrayList<String>) healthIdMap.get("healthIds");
		for(String healthId : healthIds){
			mentalHealthService.deleteMentalHealth(healthId);
		}
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//导出所有的健康信息列表
	@RequestMapping(value = "/exportMentalHealthAll", method = RequestMethod.GET)
	public void exportMentalHealthAll(HttpServletRequest request, HttpServletResponse response) {
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		List<MentalHealth> mentalHealthList = mentalHealthService.getMentalHealthList(tenantId);
		List<SheetPojo> sheetPojos = new ArrayList<>();
		//sheet中各列的的名称
		String[] columNames = {"序号", "姓名", "学号", "专业", "班级", "心理普查结果", "排查时间", "排查方式", "信息记录", "采取措施"};
		//sheet的名称
		String sheetName = "健康信息表";
		//sheet中各行的数据
		List<String[]> sheetData = new ArrayList<>();
		for (int i = 0; i < mentalHealthList.size(); i++) {
			String[] columnData = {mentalHealthList.get(i).getStuName(), 
					mentalHealthList.get(i).getStuNum(), mentalHealthList.get(i).getProName(), 
					mentalHealthList.get(i).getClassName(), mentalHealthList.get(i).getResult(), 
					mentalHealthList.get(i).getCreateTime(), mentalHealthList.get(i).getWay(), 
					mentalHealthList.get(i).getRecord(), mentalHealthList.get(i).getStep()};
			sheetData.add(columnData);
		}
		sheetPojos.add(new SheetPojo(columNames, sheetName, sheetData));
		new Excel("health.xls", FileSystemView.getFileSystemView().getHomeDirectory().getPath() + "/健康信息表" + System.currentTimeMillis() + ".xls" , sheetPojos).exportExcel(response);
	}

	//导入就业信息
	@RequestMapping(value = "importMentalHealth", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> importTeaJob(@RequestParam(value = "file", required = false) MultipartFile file) throws MsgException {
		Workbook wookbook = null;
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try {
			if (file.getOriginalFilename().endsWith(".xls")) {
				wookbook = new HSSFWorkbook(file.getInputStream());
				Sheet sheet = wookbook.getSheetAt(0);
				int lastRowNum = sheet.getLastRowNum();
				List<MentalHealth> mentalHealths = new ArrayList<>();
				List<String> stuNums = new ArrayList<>();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for (int i = 1; i <= lastRowNum; i ++) {
					Row row = sheet.getRow(i);
					String stuNum = "";
					if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
						Double value = row.getCell(0).getNumericCellValue();
						stuNum = Integer.toString(value.intValue());
					}
					else if (row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
						stuNum = row.getCell(0).getStringCellValue();
					}
					String result = row.getCell(1).getStringCellValue();
//					String createTime = row.getCell(2).getStringCellValue();
					double date = row.getCell(2).getNumericCellValue();
					String createTime = simpleDateFormat.format(DateUtil.getJavaDate(date));
					String way = row.getCell(3).getStringCellValue();
					String record = row.getCell(4).getStringCellValue();
					String step = row.getCell(5).getStringCellValue();
					MentalHealth mentalHealth = new MentalHealth(result, createTime, way, record, step);
					stuNums.add(stuNum);
					mentalHealths.add(mentalHealth);
				}
				mentalHealthService.batchAdd(mentalHealths, stuNums);
			}
			else {
				throw new MsgException("上传的非excel文件");
			}
		} catch (IOException e) {
			responseMap.put(Constants.RTN_CODE, Constants.FAIL);
			responseMap.put(Constants.ERROR_MSG, "导入失败");
			return responseMap;
		} catch (MsgException e) {
			responseMap.put(Constants.RTN_CODE, Constants.FAIL);
			responseMap.put(Constants.ERROR_MSG, e.getMessage());
			return responseMap;
		}
		
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//下载导入excel模板
	@RequestMapping(value = "importMentalHealthTamplate", method = RequestMethod.GET)
	public void importTeaJobTamplate(HttpServletRequest request, HttpServletResponse response) {
		List<SheetPojo> sheetPojos = new ArrayList<>();
		//sheet中各列的的名称
		String[] columNames = {"学号", "心理普查结果", "排查时间", "排查方式", "信息记录", "采取措施"};
		//sheet的名称
		String sheetName = "心理健康模板";
		sheetPojos.add(new SheetPojo(columNames, sheetName, new ArrayList<String[]>()));
		new Excel("mentalHealthTamplate.xls", FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + "mentalHealthTamplate.xls", sheetPojos).exportExcel(response);
	}
}
