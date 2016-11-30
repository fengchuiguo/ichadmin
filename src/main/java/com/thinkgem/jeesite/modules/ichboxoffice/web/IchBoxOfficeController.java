/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ichboxoffice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.ichboxoffice.entity.IchBoxOffice;
import com.thinkgem.jeesite.modules.ichboxoffice.service.IchBoxOfficeService;

/**
 * 财盒机构关联表Controller
 * @author lhy
 * @version 2016-11-30
 */
@Controller
@RequestMapping(value = "${adminPath}/ichboxoffice/ichBoxOffice")
public class IchBoxOfficeController extends BaseController {

	@Autowired
	private IchBoxOfficeService ichBoxOfficeService;
	
	@ModelAttribute
	public IchBoxOffice get(@RequestParam(required=false) String id) {
		IchBoxOffice entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ichBoxOfficeService.get(id);
		}
		if (entity == null){
			entity = new IchBoxOffice();
		}
		return entity;
	}
	
	@RequiresPermissions("ichboxoffice:ichBoxOffice:view")
	@RequestMapping(value = {"list", ""})
	public String list(IchBoxOffice ichBoxOffice, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<IchBoxOffice> page = ichBoxOfficeService.findPage(new Page<IchBoxOffice>(request, response), ichBoxOffice); 
		model.addAttribute("page", page);
		return "modules/ichboxoffice/ichBoxOfficeList";
	}

	@RequiresPermissions("ichboxoffice:ichBoxOffice:view")
	@RequestMapping(value = "form")
	public String form(IchBoxOffice ichBoxOffice, Model model) {
		model.addAttribute("ichBoxOffice", ichBoxOffice);
		return "modules/ichboxoffice/ichBoxOfficeForm";
	}

	@RequiresPermissions("ichboxoffice:ichBoxOffice:edit")
	@RequestMapping(value = "save")
	public String save(IchBoxOffice ichBoxOffice, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ichBoxOffice)){
			return form(ichBoxOffice, model);
		}
		ichBoxOfficeService.save(ichBoxOffice);
		addMessage(redirectAttributes, "保存财盒机构信息成功");
		return "redirect:"+Global.getAdminPath()+"/ichboxoffice/ichBoxOffice/?repage";
	}
	
	@RequiresPermissions("ichboxoffice:ichBoxOffice:edit")
	@RequestMapping(value = "delete")
	public String delete(IchBoxOffice ichBoxOffice, RedirectAttributes redirectAttributes) {
		ichBoxOfficeService.delete(ichBoxOffice);
		addMessage(redirectAttributes, "删除财盒机构信息成功");
		return "redirect:"+Global.getAdminPath()+"/ichboxoffice/ichBoxOffice/?repage";
	}

}