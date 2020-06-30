package com.samickthk.seatreservation.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTests {

	@Autowired
	private UserService service;
	
	@Test
	public void getUserTest() {
		String loginId = "admin";
		String loginPw = "0000";
		
		try {
			log.info(service.getUser(loginId, loginPw).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
