package com.samickthk.seatreservation.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samickthk.seatreservation.domain.SeatReservation;
import com.samickthk.seatreservation.exception.LoginException;
import com.samickthk.seatreservation.exception.SeatReservationException;
import com.samickthk.seatreservation.service.SeatService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class SeatController {

	@Autowired
	private SeatService seatService;
	
	/**
	 * 오늘자 자리 예약 정보 조회
	 * 
	 * @return
	 */
	@ApiOperation("오늘자 자리 예약 정보 조회")
	@GetMapping(value = "/seat/reservation/today", produces = "application/json")
	public ResponseEntity<Object> getSeatReservationInfosToday() {
		Map<String, Object> result = new HashMap<>();
		LocalDate today = LocalDate.now();
		
		try {
			List<SeatReservation> seatReservationInfos = seatService.getSeatReservationInfos(today);
			
			result.put("responseCode", 2000);
			result.put("seatReservationInfos", seatReservationInfos);
			
			log.debug("response : " + result);
			
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (LoginException e) {
			result.put("responseCode", 4000);
			result.put("errorMessage", e.getMessage());
			
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}
	
	/**
	 * 자리 예약
	 * 
	 * @param userId
	 * @param seatId
	 * 
	 * @return
	 */
	@ApiOperation("자리 예약")
	@PostMapping(value = "/seat/book", produces = "application/json")
	public ResponseEntity<Object> booSeatToday(
			@RequestParam String userId,
			@RequestParam int seatId) {
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> param = new HashMap<>();
		
		try {
			param.put("userId", userId);
			param.put("seatId", seatId);
			
			SeatReservation seatReservationInfo = seatService.bookSeatToday(param);
			
			result.put("responseCode", 2000);
			result.put("seatReservationInfo", seatReservationInfo);
			
			log.debug("response : " + result);
			
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (SeatReservationException e) {
			result.put("responseCode", 4000);
			result.put("errorMessage", e.getMessage());
			
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}
}
