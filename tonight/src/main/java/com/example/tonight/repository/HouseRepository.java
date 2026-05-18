package com.example.tonight.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tonight.entity.House;

public interface HouseRepository extends JpaRepository<House, Integer> {
	public Page<House> findByNameContaining(String keyword, Pageable pageable);

}
