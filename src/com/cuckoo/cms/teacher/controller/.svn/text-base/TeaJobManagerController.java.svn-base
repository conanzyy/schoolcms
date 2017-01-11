package com.cuckoo.cms.teacher.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import javax.validation.Valid;

import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
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

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.excel.Excel;
import com.cuckoo.cms.common.excel.SheetPojo;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.teacher.pojo.Job;
import com.cuckoo.cms.teacher.pojo.req.TeaJobAddReq;
import com.cuckoo.cms.teacher.service.TeaJobService;

@Controller
public class TeaJobManagerController {
	
	//注入service对象
	@Autowired
	private TeaJobService teaJobService;
	
	//获取学生就业信息列表
	@RequestMapping(value = "/getTeaJobList" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeaJobList(HttpServletRequest request) 
			throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String userId=SessionUtil.getUserInfo(request).getUserId();
		String tenantId=SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		//System.out.println(1111);
		responseMap.put("data",teaJobService.getTeaJobList(userId,tenantId));
		//System.out.println(responseMap);
		return responseMap;
	}
	
	//获取学生就业信息
	@RequestMapping(value = "/getTeaJob" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeaJob(@RequestParam(value="jobId") String jobId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("data",teaJobService.getTeaJob(jobId));
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//编辑学生就业信息
	@RequestMapping(value = "/updateTeaJobInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateTeaJobInfo(@Valid  TeaJobAddReq teaJobAddReq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		teaJobService.updateTeaJobInfo(teaJobAddReq);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//删除学生就业信息
	@RequestMapping(value = "/deleteTeaJobInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteTeaJobInfo(@Valid  String jobId, 
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		teaJobService.deleteTeaJobInfo(jobId);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//删除多条学生就业信息
		@RequestMapping(value = "/deleteTeaJobInfoAll", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> deleteTeaJobInfoAll(@Valid @RequestBody HashMap<String,Object> jobIdMap, 
				HttpServletRequest request) throws MsgException {
			ArrayList<String>  jobIds = (ArrayList<String>) jobIdMap.get("jobIds");
			for(String jobId : jobIds){
				teaJobService.deleteTeaJobInfo(jobId);
			}
			Map<String, Object> responseMap = new HashMap<String, Object>();
			responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
			return responseMap;
		}
		
		//导出所有的就业信息
		@RequestMapping(value = "/exportTeaJob", method = RequestMethod.GET)
		public void exportTeaJob(HttpServletRequest request, HttpServletResponse response) {
			String userId=SessionUtil.getUserInfo(request).getUserId();
			String tenantId=SessionUtil.getUserInfo(request).getTenantId();
			
			List<Job> teaJobList = teaJobService.getTeaJobList(userId,tenantId);
			List<SheetPojo> sheetPojos = new ArrayList<>();
			//sheet中各列的的名称
			String[] columNames = {"序号", "姓名", "专业", "班级", "就业类别", "工作（升学）单位名称", "单位性质", "单位地址", "单位联系电话"};
			//sheet的名称
			String sheetName = "就业信息表";
			//sheet中各行的数据
			List<String[]> sheetData = new ArrayList<>();
			for (int i = 0; i < teaJobList.size(); i++) {
				String[] columnData = {teaJobList.get(i).getStuName(), teaJobList.get(i).getProName(), 
						teaJobList.get(i).getClassName(), teaJobList.get(i).getJobType(), 
						teaJobList.get(i).getCompanyName(), teaJobList.get(i).getCompanyNature(), 
						teaJobList.get(i).getAddress(), teaJobList.get(i).getPhone()};
				sheetData.add(columnData);
			}
			sheetPojos.add(new SheetPojo(columNames, sheetName, sheetData));
			new Excel("job.xls", FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + "/就业信息表" + System.currentTimeMillis() + ".xls" , sheetPojos).exportExcel(response);
		}
		
		//导入就业信息
		@RequestMapping(value = "importTeaJob", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> importTeaJob(@RequestParam(value = "file", required = false) MultipartFile file) throws MsgException {
			Workbook wookbook = null;
			Map<String, Object> responseMap = new HashMap<String, Object>();
			try {
				if (file.getOriginalFilename().endsWith(".xls")) {
					wookbook = new HSSFWorkbook(file.getInputStream());
					Sheet sheet = wookbook.getSheetAt(0);
					int lastRowNum = sheet.getLastRowNum();
					List<Job> jobs = new ArrayList<>();
					List<String> stuNums = new ArrayList<>();
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
						Double jobType = row.getCell(1).getNumericCellValue();
						String companyName = row.getCell(2).getStringCellValue();
						Double companyNature = row.getCell(3).getNumericCellValue();
						String address = row.getCell(4).getStringCellValue();
						Double phone = row.getCell(5).getNumericCellValue();
						Job job = new Job(Integer.toString(jobType.intValue()), Integer.toString(companyNature.intValue()), companyName, address, Integer.toString(phone.intValue()));
						jobs.add(job);
						stuNums.add(stuNum);
					}
					teaJobService.batchAdd(jobs, stuNums);
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
		@RequestMapping(value = "importTeaJobTamplate", method = RequestMethod.GET)
		public void importTeaJobTamplate(HttpServletRequest request, HttpServletResponse response) {
			List<SheetPojo> sheetPojos = new ArrayList<>();
			//sheet中各列的的名称
			String[] columNames = {"学号", "就业类别", "公司名称", "单位性质", "单位地址", "单位联系电话"};
			//sheet的名称
			String sheetName = "就业信息表模板";
			sheetPojos.add(new SheetPojo(columNames, sheetName, new ArrayList<String[]>()));
			new Excel("jobTamplate.xls", FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + "jobTamplate.xls", sheetPojos).exportExcel(response);
		}
}
