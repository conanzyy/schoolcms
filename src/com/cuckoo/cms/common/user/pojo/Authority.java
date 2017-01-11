package com.cuckoo.cms.common.user.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.cuckoo.cms.common.BasePojo;

@Data
@EqualsAndHashCode(callSuper = true)
public class Authority extends BasePojo implements Comparable<Authority> {
	private String authId;
	private String parentId;
	private String authValue;
	private String path;
	private String authName;
	@Override
	public int compareTo(Authority auth) {
		return Integer.parseInt(this.authId)-Integer.parseInt(auth.getAuthId());
	}
}
