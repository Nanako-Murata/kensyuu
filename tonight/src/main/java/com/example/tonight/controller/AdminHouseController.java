package com.example.tonight.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.tonight.entity.House;
import com.example.tonight.form.HouseEditForm;
import com.example.tonight.form.HouseRegisterForm;
import com.example.tonight.repository.HouseRepository;
import com.example.tonight.service.HouseService;

@Controller
@RequestMapping("admin/houses")
public class AdminHouseController {

	private final HouseRepository houseRepository;
	private final HouseService houseService;

	public AdminHouseController(HouseRepository houseRepository, HouseService houseService) {
		this.houseRepository = houseRepository;
		this.houseService = houseService;
	}

	@GetMapping
	public String index(Model model,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			@RequestParam(name = "keyword", required = false) String keyword) {
		Page<House> housePage;
		if (keyword != null && !keyword.isBlank()) {
			housePage = houseRepository.findByNameContaining(keyword, pageable);

		} else {
			housePage = houseRepository.findAll(pageable);

		}
		model.addAttribute("housePage", housePage);
		model.addAttribute("keyword", keyword);

		return "admin/houses/index";

	}

	// 詳細画面
	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		House house = houseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
		model.addAttribute("house", house);
		return "admin/houses/show";
	}

	// 新規民泊登録
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("houseRegisterForm", new HouseRegisterForm());
		return "admin/houses/register";
	}

	// 新規登録
	@PostMapping("/create")
	public String cerate(@ModelAttribute @Validated HouseRegisterForm form, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "admin/houses/register";

		}
		houseService.create(form);
		attributes.addFlashAttribute("successMessage", "Regitered mimpaku");
		return "redirect:/admin/houses";

	}

	// edit mimpaku
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable(name = "id") Integer id, Model model) {
		House house = houseRepository.findById(id).orElseThrow();
		HouseEditForm form = new HouseEditForm(house.getId(), house.getName(), null, house.getDescription(),
				house.getPrice(), house.getCapacity(), house.getPostalCode(), house.getAddress(),
				house.getPhoneNumber());
		model.addAttribute("houseEditForm", form);
		model.addAttribute("imageName", house.getImageName());
		return "admin/houses/edit";

	}

	@PostMapping("/{id}/update")
	public String update(@ModelAttribute @Validated HouseEditForm form, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "admin/houses/edit";
		}
		houseService.update(form);
		attributes.addFlashAttribute("successMessage", "Updated mimpaku.");
		return "redirect:/admin/houses";

	}

	// delete mimpaku
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes attributes) {
		House house = houseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid house ID."));

		houseRepository.delete(house);
		attributes.addFlashAttribute("successMessage", "The house has been deleted.");
		return "redirect:/admin/houses";
	}
}
