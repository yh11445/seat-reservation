package com.samickthk.seatreservation.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class User {
	
	private String userId;
	private String loginId;
	private String loginPw;
	private String name;
	private String email;
	private String enable;
	private Timestamp regDate;
	private Timestamp udtDate;

}
