/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.smilehippo.modules.cms.dao;

import com.smilehippo.modules.cms.entity.Site;
import com.smilehippo.common.persistence.CrudDao;
import com.smilehippo.common.persistence.annotation.MyBatisDao;

/**
 * 站点DAO接口
 * @author ThinkGem
 * @version 2013-8-23
 */
@MyBatisDao
public interface SiteDao extends CrudDao<Site> {

}
