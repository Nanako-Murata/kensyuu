package com.example.mimpaku.controller;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mimpaku.entity.House;
import com.example.mimpaku.entity.Reservation;
import com.example.mimpaku.entity.User;
import com.example.mimpaku.form.ReservationInputForm;
import com.example.mimpaku.form.ReservationRegisterForm;
import com.example.mimpaku.repository.HouseRepository;
import com.example.mimpaku.repository.ReservationRepository;
import com.example.mimpaku.repository.UserRepository;
import com.example.mimpaku.security.UserDetailsImpl;
import com.example.mimpaku.service.ReservationService;

@Controller
public class ReservationController {
	private final ReservationRepository reservationRepository;
	private final HouseRepository houseRepository;
	private final UserRepository userRepository;
	private final ReservationService reservationService;

	public ReservationController(ReservationRepository reservationRepository, HouseRepository houseRepository,
			UserRepository userRepository, ReservationService reservationService) {
		this.reservationRepository = reservationRepository;
		this.houseRepository = houseRepository;
		this.userRepository = userRepository;
		this.reservationService = reservationService;

	}

	@GetMapping("/reservations")
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			@PageableDefault(page = 0, size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
			Model model) {
		User user = userDetailsImpl.getUser();
		Page<Reservation> reservationPage = reservationRepository.findByUserOrderByCreatedAtDesc(user, pageable);
		model.addAttribute("reservationPage", reservationPage);
		return "reservations/index";
	}

	@GetMapping("/houses/{id}/reservations/input")
	public String input(@PathVariable Integer id, @Validated ReservationInputForm reservationInputForm,
			BindingResult result, RedirectAttributes attributes, Model model) {
		House house = houseRepository.findById(id).orElseThrow();
		Integer numberOfPeople = reservationInputForm.getNumberOfPeople();
		Integer capacity = house.getCapacity();

		if (numberOfPeople != null && !reservationService.isWithinCapacity(numberOfPeople, capacity)) {
			FieldError error = new FieldError(result.getObjectName(), "numberOfPeople", "Capacity exceeded.");
			result.addError(error);

		}

//		if (numberOfPeople != null) {
//			if (!reservationService.isWithinCapacity(numberOfPeople, capacity)) {
//				FieldError error = new FieldError(result.getObjectName(), "numberOfPeople", "Exceeded capacity.");
//				result.addError(error);
//
//			}
		if (result.hasErrors()) {
			model.addAttribute("errorMessage", "Incorrect reservation");
			model.addAttribute("house", house);
			return "houses/show";
		}

		attributes.addFlashAttribute("reservationInputForm", reservationInputForm);

		return "redirect:/houses/{id}/reservations/confirm";
	}

	@GetMapping("/houses/{id}/reservations/confirm")
	public String confirm(@PathVariable Integer id, @ModelAttribute ReservationInputForm reservationInputForm,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		House house = houseRepository.findById(id).orElseThrow();
		User user = userDetailsImpl.getUser();
		// チェックイン日を取得
		LocalDate checkinDate = reservationInputForm.getCheckinDate();
		LocalDate checkoutDate = reservationInputForm.getCheckoutDate();
		// 宿泊料金計算
		Integer price = house.getPrice();
		Integer amount = reservationService.calcAmount(checkinDate, checkoutDate, price);
		ReservationRegisterForm reservationRegisterForm = new ReservationRegisterForm(house.getId(), user.getId(),
				checkinDate.toString(), checkoutDate.toString(), reservationInputForm.getNumberOfPeople(), amount);
		model.addAttribute("house", house);
		model.addAttribute("reservationRegisterForm", reservationRegisterForm);
		return "reservations/confirm";

	}

	@PostMapping("/houses/{id}/reservations/create")
	public String create(@ModelAttribute ReservationRegisterForm reservationRegisterForm) {
		reservationService.create(reservationRegisterForm);
		return "redirect:/reservations?reserved";
	}

}
