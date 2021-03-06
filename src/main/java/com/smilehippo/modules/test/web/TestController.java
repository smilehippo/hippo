/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.smilehippo.modules.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smilehippo.common.web.BaseController;
import com.smilehippo.modules.hippo.utils.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smilehippo.common.persistence.Page;
import com.smilehippo.common.utils.StringUtils;
import com.smilehippo.modules.sys.entity.User;
import com.smilehippo.modules.sys.utils.UserUtils;
import com.smilehippo.modules.test.entity.Test;
import com.smilehippo.modules.test.service.TestService;

/**
 * 测试Controller
 * @author ThinkGem
 * @version 2013-10-17
 */
@Controller
@RequestMapping(value = "${adminPath}/test/test")
public class TestController extends BaseController {

	@Autowired
	private TestService testService;
	
	@ModelAttribute
	public Test get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return testService.get(id);
		}else{
			return new Test();
		}
	}
	
	/**
	 * 显示列表页
	 * @param test
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequiresPermissions("test:test:view")
	@RequestMapping(value = {"list", ""})
	public String list(Test test, HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/test/testList";
	}
	
	/**
	 * 获取硕正列表数据（JSON）
	 * @param test
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequiresPermissions("test:test:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Test> listData(Test test, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			test.setCreateBy(user);
		}
        Page<Test> page = testService.findPage(new Page<Test>(request, response), test); 
        return page;
	}
	
	/**
	 * 新建或修改表单
	 * @param test
	 * @param model
	 * @return
	 */
	@RequiresPermissions("test:test:view")
	@RequestMapping(value = "form")
	public String form(Test test, Model model) {
		model.addAttribute("test", test);
		return "modules/test/testForm";
	}

	/**
	 * 表单保存方法
	 * @param test
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("test:test:edit")
	@RequestMapping(value = "save")
	public String save(Test test, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, test)){
			return form(test, model);
		}
//		testService.save(test);
		addMessage(redirectAttributes, "保存测试'" + test.getName() + "'成功");
		return "redirect:" + adminPath + "/test/test/?repage";
	}
	
	/**
	 * 删除数据方法
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("test:test:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Test test, RedirectAttributes redirectAttributes) {
//		testService.delete(test);
//		addMessage(redirectAttributes, "删除测试成功");
//		return "redirect:" + adminPath + "/test/test/?repage";
		return "true";
	}


	/**
	 * 删除数据方法
	 * @param request
	 * @param response
	 * @return
	 */
//	@RequiresPermissions("test:test:edit")
	@RequestMapping(value = "hippo/login", method = RequestMethod.GET)
//	@ResponseBody
	public String hippo(HttpServletRequest request, HttpServletResponse response) {
//		testService.delete(test);
//		addMessage(redirectAttributes, "删除测试成功");
//		return "redirect:" + adminPath + "/test/test/?repage";
		return "hippo/modules/auth/login";
	}

	//	@RequiresPermissions("test:test:edit")
	@RequestMapping(value = "hippo/signin", method = RequestMethod.GET)
//	@ResponseBody
	public ModelAndView signin(HttpServletRequest request, HttpServletResponse response) {
		return ResponseUtil.RenderTpl(request, "SignIn", "pages/auth/SignIn");
//		return new ModelAndView("hippo/modules/auth/login");
	}
}
