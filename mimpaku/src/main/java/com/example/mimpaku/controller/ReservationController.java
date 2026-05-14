package com.example.mimpaku.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.mimpaku.entity.Reservation;
import com.example.mimpaku.entity.User;
import com.example.mimpaku.repository.ReservationRepository;
import com.example.mimpaku.security.UserDetailsImpl;

@Controller
public class ReservationController {
	private final ReservationRepository reservationRepository;

	public ReservationController(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@GetMapping("/reservations")
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			@PageableDefault(page = 0, size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
			Model model) {
		User user =userDetailsImpl.getUser();
		Page<Reservation> reservationPage = reservationRepository.findByUserOrderByCreatedAtDesc(user, pageable);
		model.addAttribute("reservationPage", reservationPage);
		return "reservations/index";
	}

}
