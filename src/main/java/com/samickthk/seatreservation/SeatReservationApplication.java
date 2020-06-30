package com.samickthk.seatreservation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.samickthk.seatreservation.mapper"})
public class SeatReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeatReservationApplication.class, args);
	}

}
