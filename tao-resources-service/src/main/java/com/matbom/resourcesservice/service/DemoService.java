package com.matbom.resourcesservice.service;

import com.matbom.entity.base.TUser;
import com.matbom.utils.IdWorker;
import com.matbom.resourcesservice.dao.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DemoService {
	@Autowired
	private IdWorker idWorker;
	@Autowired
	private TUserMapper tUserMapper;

	public List<TUser> selectAll() {
		return tUserMapper.selectByExample(null);
	}


}
