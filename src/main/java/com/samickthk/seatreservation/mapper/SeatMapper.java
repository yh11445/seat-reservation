package com.samickthk.seatreservation.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.samickthk.seatreservation.domain.SeatReservation;

public interface SeatMapper {

	public List<SeatReservation> selectSeatReservationInfos(LocalDate date) throws Exception;
	
	public int selectSeatReservationCountTodayBySeatId(int seatId) throws Exception;
	
	public int selectSeatReservationCountTodayByUserId(String userId) throws Exception;
	
	public int deleteSeatReservationTodayByUserId(String userId) throws Exception;
	
	public int insertSeatReservationToday(Map<String, Object> param) throws Exception;
	
	public SeatReservation selectSeatReservationInfoByUserId(Map<String, Object> param) throws Exception;
}
