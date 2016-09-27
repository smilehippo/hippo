/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.smilehippo.modules.cms.service;

import com.smilehippo.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smilehippo.modules.cms.dao.ArticleDataDao;
import com.smilehippo.modules.cms.entity.ArticleData;

/**
 * 站点Service
 * @author ThinkGem
 * @version 2013-01-15
 */
@Service
@Transactional(readOnly = true)
public class ArticleDataService extends CrudService<ArticleDataDao, ArticleData> {

}
