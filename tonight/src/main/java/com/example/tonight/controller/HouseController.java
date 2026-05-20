package com.example.tonight.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tonight.entity.House;
import com.example.tonight.repository.HouseRepository;

@Controller
@RequestMapping("/houses")

public class HouseController {
	private final HouseRepository houseRepository;

	public HouseController(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

	@GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String kw,
			@RequestParam(name = "area", required = false) String area,
			@RequestParam(name = "sort", required = false) String sort,
			@RequestParam(name = "price", required = false) Integer price,
			@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable, Model model) {

		// 並び替え設定
		if ("priceAsc".equals(sort)) {
			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
					Sort.by(Direction.ASC, "price"));
		} else {
			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
					Sort.by(Direction.DESC, "createdAt"));

		}
		Page<House> housePage;

		if (kw != null && !kw.isBlank()) {
			housePage = houseRepository.findByNameContainingOrAddressContaining(kw, kw, pageable);

		} else if (price != null) {
			housePage = houseRepository.findByPriceLessThanEqual(price, pageable);
		} else if (area != null) {
			housePage = houseRepository.findByAddressContaining(area, pageable);

		} else {
			housePage = houseRepository.findAll(pageable);

		}
		model.addAttribute("housePage", housePage);
		model.addAttribute("sort", sort);
		model.addAttribute("keyword", kw);
		model.addAttribute("price", price);
		model.addAttribute("area", area);

		return "houses/index";

	}

	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		House house = houseRepository.findById(id).orElseThrow();
		model.addAttribute("house", house);
		return "houses/show";
	}
}