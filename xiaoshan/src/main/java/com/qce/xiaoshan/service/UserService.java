package com.qce.xiaoshan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qce.xiaoshan.Root;
import com.qce.xiaoshan.User;
import com.qce.xiaoshan.Mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired

	private UserMapper userMapper;

	public String insertUser(Integer id,String name, Integer age) {
		Integer insertUserReuslt = userMapper.insert(id,name,age);
		log.info("####insertUserResult:{}##########", insertUserReuslt);
		System.out.println(insertUserReuslt);
		return insertUserReuslt.toString();
	}
	public List<User> selectUserbyname(String name) {		
		List<User> selectUserReuslt = userMapper.findByName(name);	
		log.info("####selectUserResult:{}##########", selectUserReuslt);
		System.out.println(selectUserReuslt.toString());		
		return selectUserReuslt;
	}
	public String selectUserbyid(Integer id) {		
		User selectUserReuslt = userMapper.findByid(id);	
		log.info("####selectUserResult:{}##########", selectUserReuslt);				
		return selectUserReuslt.toString();
	}
	public List<User>flash(){
		List<User>selectUserReuslt=userMapper.flash();
		log.info("####selectUserResult:{}##########", selectUserReuslt);
		return selectUserReuslt;
			
	}
	public String insertRoot(String accountnumber,String password) {
		Integer insertUserReuslt = userMapper.insertroot(accountnumber,password);
		return insertUserReuslt.toString();
	}
	public List<Root>rootMap(){
		List<Root>selectUserReuslt=userMapper.rootmap();
		return selectUserReuslt;
	}
	
}
