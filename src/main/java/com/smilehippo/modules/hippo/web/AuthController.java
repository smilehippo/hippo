/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.smilehippo.modules.hippo.web;

import com.google.common.collect.Maps;
import com.smilehippo.common.config.Global;
import com.smilehippo.common.security.shiro.session.SessionDAO;
import com.smilehippo.common.servlet.ValidateCodeServlet;
import com.smilehippo.common.utils.CacheUtils;
import com.smilehippo.common.utils.CookieUtils;
import com.smilehippo.common.utils.IdGen;
import com.smilehippo.common.utils.StringUtils;
import com.smilehippo.common.web.BaseController;
import com.smilehippo.modules.hippo.utils.ResponseUtil;
import com.smilehippo.modules.sys.security.FormAuthenticationFilter;
import com.smilehippo.modules.sys.security.SystemAuthorizingRealm;
import com.smilehippo.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 登录Controller
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
public class AuthController extends BaseController {

	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public ModelAndView signin(HttpServletRequest request, HttpServletResponse response) {
		return ResponseUtil.RenderTpl(request, "SignIn", "pages/auth/SignIn");
	}
}
