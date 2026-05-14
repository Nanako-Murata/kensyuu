package com.example.mimpaku.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.example.mimpaku.entity.House;
import com.example.mimpaku.form.ReservationInputForm;
import com.example.mimpaku.repository.HouseRepository;

@Controller
@RequestMapping("/houses")
public class HouseController {

	private final HouseRepository houseRepository;

	public HouseController(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

	@GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "area", required = false) String area,
			@RequestParam(name = "price", required = false) Integer price,
			@RequestParam(name = "order", required = false) String order,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {
		Sort sort;

		// 並び替え条件
		if ("priceAsc".equals(order)) {
			sort = Sort.by(Direction.ASC, "price");
		} else {
			sort = Sort.by(Direction.DESC, "createdAt");
		}

		// pageableにsortを設定
		pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

		Page<House> housePage;

		// キーワード検索
		if (keyword != null && !keyword.trim().isEmpty()) {
			housePage = houseRepository.findByNameContainingOrAddressContaining(keyword.trim(), keyword.trim(),
					pageable);
			// 価格検索

		} else if (price != null) {
			housePage = houseRepository.findByPriceLessThanEqual(price, pageable);
			// 全件検索

		} else if (area != null && !area.trim().isEmpty()) {
			housePage = houseRepository.findByAddressContaining(area.trim(), pageable);
		} else {

			housePage = houseRepository.findAll(pageable);

		}
//		} else {
//			housePage = houseRepository.findAll(pageable);
//		}
//		model.addAttribute("housePage", housePage);
//		model.addAttribute("keyword", keyword);
//		model.addAttribute("price", price);
//		return "houses/index";
//	
		model.addAttribute("housePage", housePage);
		model.addAttribute("keyword", keyword);
		model.addAttribute("area", area);
		model.addAttribute("price", price);
		model.addAttribute("order", order);
		return "houses/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable Integer id, Model model) {
		House house = houseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		model.addAttribute("house", house);
		model.addAttribute("reservationInputForm", new ReservationInputForm());
		return "houses/show";
	}
}