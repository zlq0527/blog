package com.myblog.blog.service;

import com.myblog.blog.dao.ProjectMapper;
import com.myblog.blog.model.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName:ProjectServiceImp
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2021/9/10 23:06
 * @com.chuangmei
 */
@Service
public class ProjectServiceImp implements ProjectService {

	@Resource
	private ProjectMapper projectMapper;

	@Override
	public Project[] queryProjects() {


		return projectMapper.selectProject();
	}
}
