package com.samickthk.seatreservation.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.samickthk.seatreservation.domain.SeatReservation;
import com.samickthk.seatreservation.exception.SeatReservationException;
import com.samickthk.seatreservation.mapper.SeatMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SeatService {

	@Autowired
	private SeatMapper mapper;
	
	public List<SeatReservation> getSeatReservationInfos(LocalDate date) throws Exception {
		try {
			return mapper.selectSeatReservationInfos(date);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public SeatReservation bookSeatToday(Map<String, Object> param) throws Exception {
		
		/**
		 * 1. 예약된 좌석인지 확인
		 * 2. 이미 예약된 자리가 있다면 삭제
		 * 3. 좌석 예약
		 */
		
		int seatId = (int) param.get("seatId");
		String userId = (String) param.get("userId");
		
		try {
			if (mapper.selectSeatReservationCountTodayBySeatId(seatId) == 1)
				throw new SeatReservationException(2001);
			
			if (mapper.selectSeatReservationCountTodayByUserId(userId) == 1) {
				mapper.deleteSeatReservationTodayByUserId(userId);
			}
			
			if (mapper.insertSeatReservationToday(param) != 1) {
				throw new SeatReservationException(2002);
			}
			
			param.put("date", LocalDate.now());
			
			return mapper.selectSeatReservationInfoByUserId(param);
		} catch (SeatReservationException e) {
			log.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
		
	}
}







