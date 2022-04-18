package com.myblog.blog.service;

import com.myblog.blog.dao.TypeMapper;
import com.myblog.blog.model.Pager;
import com.myblog.blog.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:TypeServiceImp
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2020/7/27 13:42
 * @com.chuangmei
 */
@Service
public class TypeServiceImp implements TypeService {

	//dao
	@Resource
	private TypeMapper typeDao;


	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int setType(Type type) {

		//插入type
		int count = typeDao.insertSelective(type);

		return count;
	}

	/*检查typename是否重复*/
	@Override
	public int queryTypeBynameCount(String typename) {

		//查询
		Type type = typeDao.selctTypeByname(typename);

		//返回值
		int result = 0;
		if (type != null) {
			result = 1;
		}

		return result;
	}

	@Override
	public List<Type> queryAllType() {

		//调用dao接口查询
		List<Type> types = typeDao.selectAllType();

		return types;
	}

	//查询类型通过id
	@Override
	public Type queryTypeById(String id) {

		//调用dao接口进行查询
		Type type = typeDao.selectByPrimaryKey(Long.valueOf(id));

		return type;
	}

	//修改类型
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateTypeByType(Type type) {

		//调用dao层修改
		int count = typeDao.updateByPrimaryKey(type);

		return count;
	}

	//删除分类
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteTypeById(String id) {

		//删除
		int count = typeDao.deleteByPrimaryKey(Long.valueOf(id));

		return count;
	}

	//查询type以及在blog中对应的数量
	@Override
	public List<Type> queryTypeAndNumber() {

		List<Type> types = typeDao.selectTypeAndNumber();

		return types;
	}

	//查询总条数
	@Override
	public int queryAllCount() {
		int count = typeDao.selectAllCount();
		return count;
	}

	//分页查询
	@Override
	public List<Type> queryAllTypePage(Pager typePager) {

		List<Type> types = typeDao.selectAllTypePage((typePager.getStartpage() - 1) * typePager.getDATA_NUMBER(), typePager.getDATA_NUMBER());

		return types;
	}
}
