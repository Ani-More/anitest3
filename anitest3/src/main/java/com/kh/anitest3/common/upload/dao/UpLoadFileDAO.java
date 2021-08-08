package com.kh.anitest3.common.upload.dao;

import java.util.List;

import com.kh.anitest3.common.upload.dto.UpLoadFileDTO;

public interface UpLoadFileDAO {
	
	/**
	 * 업로드 파일추가
	 * @param list
	 */
	void addFile(UpLoadFileDTO uploadFileDTO);
	void addFiles(List<UpLoadFileDTO> list);
	
	/**
	 * 업로드 파일 조회
	 * @param pid
	 * @return
	 */
	List<UpLoadFileDTO> getFiles(String pid);
	List<UpLoadFileDTO> getFiles(String pid,String code);
	
	/**
	 * 업로드파일 삭제 by 상품
	 * @param pid
	 */
	void deleteFileByPid(String pid);
	void deleteFileByPid(String pid,String code);
	
	List<String> getStore_Fname(String pid);
	
//	/**
//	 * 업로드파일 삭제 by FID
//	 * @param fid
//	 */
//	void deleteFileByFid(String fid);
	
}