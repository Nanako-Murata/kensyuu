package com.example.samuraitravel.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.form.HouseEditForm;
import com.example.samuraitravel.form.HouseRegisterForm;
import com.example.samuraitravel.repository.HouseRepository;

@Service
public class HouseService {

	private final HouseRepository houseRepository;

	public HouseService(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

	// =========================================
	// 新規登録
	// =========================================
	@Transactional
	public void create(HouseRegisterForm form) {

		House house = new House();
		MultipartFile imageFile = form.getImageFile();

		if (imageFile != null && !imageFile.isEmpty()) {

			String originalFileName = imageFile.getOriginalFilename();
			String fileName = generateNewFileName(originalFileName);

			Path uploadPath = Paths.get(System.getProperty("user.dir"), "storage");

			try {
				Files.createDirectories(uploadPath);

				Path filePath = uploadPath.resolve(fileName);
				Files.copy(imageFile.getInputStream(), filePath);

			} catch (IOException e) {
				throw new RuntimeException("画像保存失敗", e);
			}

			house.setImageName(fileName);
		}

		house.setName(form.getName());
		house.setDescription(form.getDescription());
		house.setPrice(form.getPrice());
		house.setCapacity(form.getCapacity());
		house.setPostalCode(form.getPostalCode());
		house.setAddress(form.getAddress());
		house.setPhoneNumber(form.getPhoneNumber());

		houseRepository.save(house);
	}

	// =========================================
	// 更新
	// =========================================
	@Transactional
	public void update(HouseEditForm form) {

		House house = houseRepository.getReferenceById(form.getId());

		house.setName(form.getName());
		house.setDescription(form.getDescription());
		house.setPrice(form.getPrice());
		house.setCapacity(form.getCapacity());
		house.setPostalCode(form.getPostalCode());
		house.setAddress(form.getAddress());
		house.setPhoneNumber(form.getPhoneNumber());

		houseRepository.save(house);
	}

	// =========================================
	// 最新10件
	// =========================================
	public List<House> findTop10() {
		return houseRepository.findTop10ByOrderByCreatedAtDesc();
	}

	// =========================================
	// エリア検索
	// =========================================
	public List<House> findByAddressLike(String area) {
		return houseRepository.findByAddressContaining(area);
	}

	// =========================================
	// ファイル名生成（UUID）
	// =========================================
	public String generateNewFileName(String fileName) {

		String extension = "";

		int dotIndex = fileName.lastIndexOf(".");
		if (dotIndex != -1) {
			extension = fileName.substring(dotIndex);
		}

		return UUID.randomUUID().toString() + extension;
	}

	public House findById(Integer id) {
		return houseRepository.findById(id).orElseThrow(() -> new RuntimeException("House not found"));
	}
}