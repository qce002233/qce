package com.qce.xiaoshan.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.SynchronossPartHttpMessageReader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qce.xiaoshan.Root;
import com.qce.xiaoshan.User;
import com.qce.xiaoshan.service.UserService;

//测试mybatis整合springboot	 	
@RestController
@CrossOrigin
public class UserController {
	Map<String, String> root = new TreeMap<String, String>();

	@Autowired
	private UserService userService;

	@CrossOrigin
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(@RequestBody(required = false) String params) {
		String[] v = params.split("&");
		String a = v[0];
		String name = v[1];
		String b = v[2];
		int id = Integer.parseInt(a);
		int age = Integer.parseInt(b);

		return userService.insertUser(id, name, age);

	}

	@CrossOrigin
	@RequestMapping(value = "/selectbyname", method = RequestMethod.POST)
	public List<User> selectUserbyname(@RequestBody(required = false) String name) {
		System.out.println(name);
		return userService.selectUserbyname(name);
	}

	@CrossOrigin
	@RequestMapping(value = "/selectbyid", method = RequestMethod.POST)
	public String selectUserbyid(@RequestBody(required = false) Integer id) {
		System.out.println(id);
		return userService.selectUserbyid(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/flash", method = RequestMethod.POST)
	public List<User> selectUserflash() {
		return userService.flash();
	}

	@CrossOrigin
	@RequestMapping(value = "/flashroot", method = RequestMethod.POST)
	public String selectRootflash() {
		for (int i = 0; i < userService.rootMap().size(); i++) {
			root.put(userService.rootMap().get(i).getAccountnumber(), userService.rootMap().get(i).getPassword());
		}
		return root.toString();
	}

	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String regiset(@RequestBody(required = false) String param) {
		System.out.println(param);
		String[] v = param.split("-");
		String accountNumber = v[0];
		String password = v[1];
		boolean containskey = root.containsKey(accountNumber);

		if (containskey) {

			System.out.println(root.toString() + "++++");
			return "该账号已被注册";
		} else {
			root.put(accountNumber, password);
			System.out.println(root.toString() + "====");

			return "注册成功" + userService.insertRoot(accountNumber, password);
		}
	}

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody(required = false) String param) {
		String[] v = param.split("-");
		if (v.length <= 1) {
			return "false";
		} else {
			String accountNumber = v[0];
			String password = v[1];			
			boolean containskey = false;
			containskey = root.containsKey(accountNumber);
			if (containskey) {
				if (root.get(accountNumber).equals(password)) {
					return "true";
				} else {
					return "false";
				}
			} else {
				return "false";
			}
		}

	}

}