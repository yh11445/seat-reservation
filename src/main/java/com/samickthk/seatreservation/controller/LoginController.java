package com.samickthk.seatreservation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samickthk.seatreservation.domain.User;
import com.samickthk.seatreservation.exception.LoginException;
import com.samickthk.seatreservation.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class LoginController {

	@Autowired
	private UserService userService;
	
	/**
	 * 로그인
	 * 
	 * @param lognId
	 * @param loginPw
	 * @return
	 */
	@ApiOperation("로그인")
	@GetMapping("/login")
	public ResponseEntity<Object> login(
			@RequestParam String loginId,
			@RequestParam String loginPw) {
		
		Map<String, Object> result = new HashMap<>();
		
		try {
			User user = userService.getUser(loginId, loginPw);
			
			result.put("responseCode", 2000);
			result.put("user", user);
			
			log.debug("response : " + result);
			
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (LoginException e) {
			result.put("responseCode", 4000);
			result.put("errorObject", e);
			
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
		
	}
			
	
}
