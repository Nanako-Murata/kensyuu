package com.example.mimpaku.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mimpaku.entity.House;

public interface HouseRepository extends JpaRepository<House, Integer> {
//名前でも住所でも検索できる！
	public Page<House> findByNameContainingOrAddressContaining(String nameKeyword, String addressKeyword,
			Pageable pageable);
//名前だけで検索したいとき
//	public Page<House> findByNameContaining(String keyword, Pageable pageable);
//住所だけで検索したいとき
//	public Page<House> findByAddressContaining(String area, Pageable pageable);

	public Page<House> findByPriceLessThanEqual(Integer price, Pageable pageable);

}
