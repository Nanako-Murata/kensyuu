package com.example.mimpaku.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.example.mimpaku.entity.House;
import com.example.mimpaku.entity.Reservation;
import com.example.mimpaku.entity.User;
import com.example.mimpaku.form.ReservationRegisterForm;
import com.example.mimpaku.repository.HouseRepository;
import com.example.mimpaku.repository.ReservationRepository;
import com.example.mimpaku.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final UserRepository userRepository;
	private final HouseRepository houseRepository;

	public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, HouseRepository houseRepository) {
		this.reservationRepository = reservationRepository;
		this.userRepository = userRepository;
		this.houseRepository = houseRepository;
	}

	public boolean isWithinCapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}

	public Integer calcAmount(LocalDate checkinDate, LocalDate checkoutDate, Integer price) {
		// betweenはlongを返す
		long numberOfNights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
		// 計算ではintを使いたい
		int amount = price * (int) numberOfNights;
		return amount;
		// return Math.toIntExact(amount)でもいい
	}

	@Transactional
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();
		House house = houseRepository.findById(reservationRegisterForm.getHouseId()).orElseThrow();
		User user = userRepository.findById(reservationRegisterForm.getUserId()).orElseThrow();
		LocalDate checkinDate = LocalDate.parse(reservationRegisterForm.getCheckinDate());
		LocalDate checkoutDate = LocalDate.parse(reservationRegisterForm.getCheckoutDate());
		Integer numberOfPeople = reservationRegisterForm.getNumberOfPeople();
		Integer amount = reservationRegisterForm.getAmount();
		reservation.setHouse(house);
		reservation.setUser(user);
		reservation.setCheckinDate(checkinDate);
		reservation.setCheckoutDate(checkoutDate);
		reservation.setNumberOfPeople(numberOfPeople);
		reservation.setAmount(amount);
		
		reservationRepository.save(reservation);

	}

}
