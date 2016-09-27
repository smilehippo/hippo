/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.smilehippo.test.dao;

import com.smilehippo.test.entity.TestTree;
import com.smilehippo.common.persistence.TreeDao;
import com.smilehippo.common.persistence.annotation.MyBatisDao;

/**
 * 树结构生成DAO接口
 * @author ThinkGem
 * @version 2015-04-06
 */
@MyBatisDao
public interface TestTreeDao extends TreeDao<TestTree> {
	
}