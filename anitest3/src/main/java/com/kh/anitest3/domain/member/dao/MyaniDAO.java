package com.kh.anitest3.domain.member.dao;

import java.util.List;

import com.kh.anitest3.domain.member.dto.MyaniDTO;

public interface MyaniDAO {
	
	/**
	 * 키우는동물 목록 보기
	 * @return
	 */
	List<MyaniDTO> myaniList();
	
	/**
	 * 키우는동물 추가
	 * @param myaniDTO
	 */
	MyaniDTO myaniAdd(MyaniDTO myaniDTO);
	
	/**
	 * 키우는동물 삭제
	 * @param myaniDTO
	 * @return
	 */
	MyaniDTO myaniDelete(MyaniDTO myaniDTO);
}
