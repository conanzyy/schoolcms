package com.cuckoo.cms.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cuckoo.cms.admin.pojo.Counselor;
import com.cuckoo.cms.admin.pojo.req.CounselorDelReq;
import com.cuckoo.cms.admin.service.CounselorService;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.prop.CmsConfigProperty;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;

@Controller
public class CounselorController {
	@Autowired
	private CounselorService counselorService;
	@Resource
	private CmsConfigProperty cmsConfigProperty;
	@RequestMapping(value = "/getCounselorList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getCounselorList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", counselorService.getCounselorList(tenantId));
		return responseMap;

	}
	
	@RequestMapping(value = "/uploadCounselorImage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadCounselorImage(HttpServletRequest request,@RequestParam("file")MultipartFile file) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		if(file.isEmpty()){
			responseMap.put(Constants.RTN_CODE, Constants.FAIL);
			responseMap.put(Constants.ERROR_MSG, "文件不能为空!");
		}
		String fileName = file.getOriginalFilename();
		int point = fileName.indexOf(".");
		if(point<=0){
			responseMap.put(Constants.RTN_CODE, Constants.FAIL);
			responseMap.put(Constants.ERROR_MSG, "图片类型不支持!");
		}
		if( Arrays.asList(Constants.imageType).contains(fileName.substring(point, fileName.length()-1))){
			responseMap.put(Constants.RTN_CODE, Constants.FAIL);
			responseMap.put(Constants.ERROR_MSG, "图片类型不支持!");
		}
	
		String imageTempDir = cmsConfigProperty.getCounselorImageLocalPath();
		String imageDir=imageTempDir+File.separator+tenantId+File.separator+"counselor";
		String fileNewName=UUID.randomUUID().toString();
		File imageFile = new File(imageDir+File.separator+fileNewName);
		if(!imageFile.exists()&&!imageFile.mkdirs()){
			responseMap.put(Constants.RTN_CODE, Constants.FAIL);
			responseMap.put(Constants.ERROR_MSG, "图片地址不存在!");
		}
		BufferedOutputStream stream=null;
		try {
			 stream = new BufferedOutputStream(new FileOutputStream(imageFile));
		  try {
			IOUtils.write(file.getBytes(), stream);
		} catch (IOException e) {
			responseMap.put(Constants.RTN_CODE, Constants.FAIL);
			responseMap.put(Constants.ERROR_MSG, "图片地址不存在!");
			return responseMap;
		}
		} catch (FileNotFoundException e) {
			responseMap.put(Constants.RTN_CODE, Constants.FAIL);
			responseMap.put(Constants.ERROR_MSG, "图片地址不存在!");
			return responseMap;
		}finally{
			IOUtils.closeQuietly(stream);
		}
		String imageUrl = cmsConfigProperty.getCounselorImageUrl()+File.separator+tenantId+File.separator+"counselor"+File.separator+fileNewName;
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("imageUrl", imageUrl);
		return responseMap;
	}
	
	@RequestMapping(value = "/createCounselor", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createCounselor(@Valid @RequestBody Counselor req, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		req.setTenantId(user.getTenantId());
		counselorService.createCounselor(user,req);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	@RequestMapping(value = "/updateCounselor", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateCounselor(@Valid @RequestBody Counselor req, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		req.setTenantId(user.getTenantId());
		counselorService.updateCounselor(req);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	@RequestMapping(value = "/deleteCounselor", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteCounselor(@Valid @RequestBody CounselorDelReq req, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		counselorService.deleteCounselor(req, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
}
