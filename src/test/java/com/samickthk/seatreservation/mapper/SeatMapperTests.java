package com.samickthk.seatreservation.mapper;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SeatMapperTests {

	@Autowired
	private SeatMapper mapper;
	
	@Test
	public void 오늘자리예약정보_조회() {
		LocalDate date = LocalDate.now();
		
		try {
			log.info("\n"+mapper.selectSeatReservationInfos(date).toString().replace("),", "),\n"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
