package com.example.samuraitravel.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	@Transactional
	public void create(HouseRegisterForm form) {

		House house = new House();
		MultipartFile imageFile = form.getImageFile();

		if (imageFile != null && !imageFile.isEmpty()) {

			String imageName = imageFile.getOriginalFilename();
			String hashed = generateNewFileName(imageName);

			// ★絶対ここにする（プロジェクト直下にstorage）
			Path uploadPath = Paths.get(System.getProperty("user.dir"), "storage");

			try {
				Files.createDirectories(uploadPath);

				Path filePath = uploadPath.resolve(hashed);
				Files.copy(imageFile.getInputStream(), filePath);

			} catch (IOException e) {
				throw new RuntimeException("画像保存失敗", e);
			}

			house.setImageName(hashed);
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

	// UUIDでファイル名生成
	public String generateNewFileName(String fileName) {
		String[] fileNames = fileName.split("\\.");

		for (int i = 0; i < fileNames.length - 1; i++) {
			fileNames[i] = UUID.randomUUID().toString();
		}

		return String.join(".", fileNames);
	}

	public void update(HouseEditForm houseEditForm) {

	    House house = houseRepository.getReferenceById(houseEditForm.getId());

	    house.setName(houseEditForm.getName());
	    house.setDescription(houseEditForm.getDescription());
	    house.setPrice(houseEditForm.getPrice());
	    house.setCapacity(houseEditForm.getCapacity());
	    house.setPostalCode(houseEditForm.getPostalCode());
	    house.setAddress(houseEditForm.getAddress());
	    house.setPhoneNumber(houseEditForm.getPhoneNumber());

	    houseRepository.save(house);
	}
}