/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ichboxoffice.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.Office;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 财盒机构关联表Entity
 * @author lhy
 * @version 2016-11-30
 */
public class IchBoxOffice extends DataEntity<IchBoxOffice> {
	
	private static final long serialVersionUID = 1L;
	private String ichId;		// ICHID
	private Office office;		// 归属公司
	
	public IchBoxOffice() {
		super();
	}

	public IchBoxOffice(String id){
		super(id);
	}

	@Length(min=1, max=100, message="ICHID长度必须介于 1 和 100 之间")
	public String getIchId() {
		return ichId;
	}

	public void setIchId(String ichId) {
		this.ichId = ichId;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
}