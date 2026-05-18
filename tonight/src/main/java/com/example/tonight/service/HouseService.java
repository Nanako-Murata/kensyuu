package com.example.tonight.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.tonight.entity.House;
import com.example.tonight.form.HouseEditForm;
import com.example.tonight.form.HouseRegisterForm;
import com.example.tonight.repository.HouseRepository;

@Service
public class HouseService {
	private final HouseRepository houseRepository;

	public HouseService(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

	@Transactional
	public void create(HouseRegisterForm form) {
		House house = new House();

		final MultipartFile imageFile = form.getImageFile();

		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			if (imageName == null) {
				return;
			}
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("storage", hashedImageName);
			copyImageFile(imageFile, filePath);
			house.setImageName(hashedImageName);

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

//UUIDのファイル名をつける
	public String generateNewFileName(String imageName) {
		if (imageName == null || !imageName.contains(".")) {
			return UUID.randomUUID().toString();
		}

		String extension = imageName.substring(imageName.lastIndexOf("."));
		return UUID.randomUUID() + extension;
//		String[] fileNames = fileName.split("\\.");
//		for (int i = 0; i < fileNames.length - 1; i++) {
//			fileNames[i] = UUID.randomUUID().toString();
//
//		}
//		return String.join(".", fileNames);

	}

	// 画像保存
	public void copyImageFile(MultipartFile imageFile, Path filePath) {
		try {
			Files.copy(imageFile.getInputStream(), filePath);

		} catch (IOException e) {
			throw new RuntimeException(e);

		}
	}

	@Transactional
	public void update(HouseEditForm form) {
		House house = houseRepository.findById(form.getId()).orElseThrow();
		final MultipartFile imageFile = form.getImageFile();
		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			if (imageName == null) {
				return;
			}
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("storage", hashedImageName);
			copyImageFile(imageFile, filePath);
			house.setImageName(hashedImageName);

		}
		house.setName(form.getName());
		house.setDescription(form.getDescription());
		house.setCapacity(form.getCapacity());
		house.setPrice(form.getPrice());
		house.setPostalCode(form.getPostalCode());
		house.setAddress(form.getAddress());
		house.setPhoneNumber(form.getPhoneNumber());

		houseRepository.save(house);

	}

}