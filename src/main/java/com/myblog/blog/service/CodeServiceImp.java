package com.myblog.blog.service;

import com.myblog.blog.dao.CodeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName:CodeServiceImp
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2021/9/11 1:06
 * @com.chuangmei
 */
@Service
public class CodeServiceImp implements CodeService {

	@Resource
	private CodeMapper codeMapper;


	@Override
	public Integer verificationCode(String code) {

		return codeMapper.selectByCode(code);
	}
}
