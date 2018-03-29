package com.bigwang.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bigwang.web.mapper.UserTMapper;
import com.bigwang.web.model.UserT;
import com.bigwang.web.service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource  
    private UserTMapper userDao;
	
	@Override
	public UserT getUserById(int userId) {
		// TODO Auto-generated method stub
		return  this.userDao.selectByPrimaryKey(userId);
	}

}
