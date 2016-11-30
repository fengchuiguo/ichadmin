/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ichboxoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.ichboxoffice.entity.IchBoxOffice;
import com.thinkgem.jeesite.modules.ichboxoffice.dao.IchBoxOfficeDao;

/**
 * 财盒机构关联表Service
 * @author lhy
 * @version 2016-11-30
 */
@Service
@Transactional(readOnly = true)
public class IchBoxOfficeService extends CrudService<IchBoxOfficeDao, IchBoxOffice> {

	
	public IchBoxOffice get(String id) {
		IchBoxOffice ichBoxOffice = super.get(id);
		return ichBoxOffice;
	}
	
	public List<IchBoxOffice> findList(IchBoxOffice ichBoxOffice) {
		return super.findList(ichBoxOffice);
	}
	
	public Page<IchBoxOffice> findPage(Page<IchBoxOffice> page, IchBoxOffice ichBoxOffice) {
		return super.findPage(page, ichBoxOffice);
	}
	
	@Transactional(readOnly = false)
	public void save(IchBoxOffice ichBoxOffice) {
		super.save(ichBoxOffice);
	}
	
	@Transactional(readOnly = false)
	public void delete(IchBoxOffice ichBoxOffice) {
		super.delete(ichBoxOffice);
	}
	
}