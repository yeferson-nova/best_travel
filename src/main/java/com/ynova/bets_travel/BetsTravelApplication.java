package com.ynova.bets_travel;

import com.ynova.bets_travel.domain.repositories.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
@Slf4j
public class BetsTravelApplication implements CommandLineRunner {


	private final FlyRepository flyRepository;
	private final HotelRepository hotelRepository;
	private final TicketRepository ticketRepository;
	private final ReservationRepository reservationRepository;
	private final TourRepository tourRepository;
	private final CustomerRepository customerRepository;

    public BetsTravelApplication(FlyRepository flyRepository, HotelRepository hotelRepository, TicketRepository ticketRepository, ReservationRepository reservationRepository, TourRepository tourRepository, CustomerRepository customerRepository) {
        this.flyRepository = flyRepository;
        this.hotelRepository = hotelRepository;
        this.ticketRepository = ticketRepository;
        this.reservationRepository = reservationRepository;
        this.tourRepository = tourRepository;
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(BetsTravelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var ticket = ticketRepository.findById(UUID.fromString("12345678-1234-5678-2236-567812345678"));
		var reservation = reservationRepository.findById(UUID.fromString("12345678-1234-5678-1234-567812345678"));
		var customer = customerRepository.findById("BBMB771012HMCRR022");
		var fly = flyRepository.findById(15L).get();
		var hotel = hotelRepository.findById(7L).get();

		log.info(String.valueOf(customer));
		log.info(String.valueOf(ticket));
		log.info(String.valueOf(reservation));
		log.info(String.valueOf(fly));
		log.info(String.valueOf(hotel));
	}
}
