package com.samickthk.seatreservation.domain;

import lombok.Data;

@Data
public class SeatReservation {
	private int seatId;
	private String seatName;
	private String userId;
	private String userName;
}
