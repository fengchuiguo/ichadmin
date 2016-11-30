/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ichboxoffice.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.ichboxoffice.entity.IchBoxOffice;

/**
 * 财盒机构关联表DAO接口
 * @author lhy
 * @version 2016-11-30
 */
@MyBatisDao
public interface IchBoxOfficeDao extends CrudDao<IchBoxOffice> {
	
}