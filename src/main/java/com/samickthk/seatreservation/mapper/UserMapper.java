package com.samickthk.seatreservation.mapper;

import java.util.Map;

import com.samickthk.seatreservation.domain.User;

public interface UserMapper {

	public int selectOne();
	
	public User selectUserByIdPw(Map<String, Object> param) throws Exception;
}
