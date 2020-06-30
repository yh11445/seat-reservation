package com.samickthk.seatreservation.exception;

import lombok.Getter;

@Getter
public class LoginException extends Exception {

	private static final long serialVersionUID = 1L;
	private int code;
	
	public LoginException(int code) {
		super(getMessage(code));
		this.code = code;
	}
	
	private static String getMessage(int code) {
		switch (code) {
		case 1001:
			return "회원정보가 없거나 비밀번호가 틀렸습니다.";
		default:
			return "Internal Server Error";
		}
	}
}
