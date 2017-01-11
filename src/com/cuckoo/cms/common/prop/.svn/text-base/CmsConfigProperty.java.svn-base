package com.cuckoo.cms.common.prop;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * 
 * @author tsx270129
 *
 */
@Component("cmsConfigProperty")
public class CmsConfigProperty {
	@Value("#{configProperties['reserved.xss.script.words']}")
	private String xssWords;
	@Value("#{configProperties['url.auth.resource.whiteList']}")
	private String urlWhiteList;
	@Value("#{configProperties['counselor.image.dir']}")
	private String counselorImageLocalPath;
	@Value("#{configProperties['counselor.image.url']}")
	private String counselorImageUrl;
	@PostConstruct
	public void init() {

	}

	public String getXssWords() {
		return xssWords;
	}

	public void setXssWords(String xssWords) {
		this.xssWords = xssWords;
	}

	public String getUrlWhiteList() {
		return urlWhiteList;
	}

	public void setUrlWhiteList(String urlWhiteList) {
		this.urlWhiteList = urlWhiteList;
	}

	public String getCounselorImageLocalPath() {
		return counselorImageLocalPath;
	}

	public void setCounselorImageLocalPath(String counselorImageLocalPath) {
		this.counselorImageLocalPath = counselorImageLocalPath;
	}

	public String getCounselorImageUrl() {
		return counselorImageUrl;
	}

	public void setCounselorImageUrl(String counselorImageUrl) {
		this.counselorImageUrl = counselorImageUrl;
	}

}
