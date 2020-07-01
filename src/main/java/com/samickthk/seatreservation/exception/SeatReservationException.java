package com.samickthk.seatreservation.exception;

import lombok.Getter;

@Getter
public class SeatReservationException extends Exception {

	private static final long serialVersionUID = 1L;
	private int code;
	
	public SeatReservationException(int code) {
		super(getMessage(code));
		this.code = code;
	}
	
	private static String getMessage(int code) {
		switch (code) {
		case 2001:
			return "이미 예약된 자리입니다.";
		case 2002:
			return "자리 예약에 실패했습니다.";
		default:
			return "Internal Server Error";
		}
	}
}
