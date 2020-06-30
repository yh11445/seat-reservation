package com.samickthk.seatreservation.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samickthk.seatreservation.domain.User;
import com.samickthk.seatreservation.exception.LoginException;
import com.samickthk.seatreservation.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserMapper mapper;

	public User getUser(String loginId, String loginPw) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("loginId", loginId);
		param.put("loginPw", loginPw);
		
		User user = null;
		try {
			user = mapper.selectUserByIdPw(param);
			
			if (user == null) throw new LoginException(1001);
			
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
