package com.samickthk.seatreservation.mapper;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapperTests {

	@Autowired
	private UserMapper mapper;
	
	@Test
	public void test() {
		Map<String, Object> param = new HashMap<>();
		param.put("loginId", "admin");
		param.put("loginPw", "0000");
		
		try {
			log.info(mapper.selectUserByIdPw(param).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
