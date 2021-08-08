package com.kh.anitest3.common.upload.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.anitest3.common.upload.dto.UpLoadFileDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UpLoadFileDAOImpl implements UpLoadFileDAO{
	
	private final JdbcTemplate jt;
	
	@Override
	public void addFile(UpLoadFileDTO uploadFileDTO) {
		List<UpLoadFileDTO> list = new ArrayList<>();
		list.add(uploadFileDTO);
		addFiles(list);
	}
	
	@Override
	public void addFiles(List<UpLoadFileDTO> list) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into uploadfile ( ");
		sql.append("  fid, ");
		sql.append("  pid, ");
		sql.append("  code, ");
		sql.append("  store_fname,  ");
		sql.append("  upload_fname, ");
		sql.append("  fsize,  ");
		sql.append("  ftype ");
		sql.append(") ");
		sql.append("values( ");
		sql.append("  uploadfile_fid_seq.nextval, ");
		sql.append("  ?, ");
		sql.append("  ?, ");
		sql.append("  ?, ");
		sql.append("  ?, ");
		sql.append("  ?, ");
		sql.append("  ? ");
		sql.append(") ");		
		
		jt.batchUpdate(sql.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {

				ps.setString(1, list.get(i).getPid());
				ps.setString(2, list.get(i).getCode());
				ps.setString(3, list.get(i).getStore_fname());
				ps.setString(4, list.get(i).getUpload_fname());
				ps.setString(5, list.get(i).getFsize());
				ps.setString(6, list.get(i).getFtype());
				
			}
			
			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
		
	}

	@Override
	public List<UpLoadFileDTO> getFiles(String pid) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select fid,pid,code,store_fname,upload_fname, ");
		sql.append("       fsize,ftype,cdate,udate ");
		sql.append("  from uploadfile  ");
		sql.append(" where pid = ? ");
		
		List<UpLoadFileDTO> list = 
				jt.query( sql.toString(), 
									new BeanPropertyRowMapper<>(UpLoadFileDTO.class), 
									pid );
		
		return list;
	}

	@Override
	public List<UpLoadFileDTO> getFiles(String pid, String code) {

		StringBuffer sql = new StringBuffer();
		sql.append("select fid,pid,code,store_fname,upload_fname, ");
		sql.append("       fsize,ftype,cdate,udate ");
		sql.append("  from uploadfile  ");
		sql.append(" where pid  = ? ");		
		sql.append("   and code = ? ");		

		List<UpLoadFileDTO> list = 
				jt.query( sql.toString(), 
									new BeanPropertyRowMapper<>(UpLoadFileDTO.class), 
									pid, code );
		
		return list;
	}
	
	/**
	 * 첨부파일 삭제 by pid
	 */
	@Override
	public void deleteFileByPid(String pid) {
		String sql = "delete from uploadfile where pid = ? ";
		jt.update(sql, pid);
	}

	/**
	 * 첨부파일 삭제 by pid, code
	 */
	@Override
	public void deleteFileByPid(String pid, String code) {
		String sql = "delete from uploadfile where pid = ? and code = ? ";
		jt.update(sql, pid, code);
	}
	
	/**
	 * 서버보관 파일명 가져오기 by pid
	 */
	@Override
	public List<String> getStore_Fname(String pid) {
		
		String sql = "select store_fname from uploadfile where pid = ? ";
		
		List<String> store_fnames =
				jt.queryForList(sql, String.class, pid);
		
		return store_fnames;
	}


}