package com.kh.anitest3.domain.member.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.anitest3.domain.member.dto.MemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MemberDAOImpl implements MemberDAO {

	private final JdbcTemplate jdbcTemplate;
	
	/**
	 * 회원가입
	 * 임시로 작동만 되는거 넣음
	 */
	@Override	
	public void join(MemberDTO memberDTO) {

		StringBuffer sql = new StringBuffer();
		String bcategory = "";
		int rows = 0;
		
		//회원 공통정보
		sql.append("insert all ");
		sql.append("into MEMBER(ID,PW,TEL,EMAIL,NAME,NICKNAME,GENDER,ADDRESS,BIRTH,MTYPE) ");
		sql.append("values (?,?,?,?,?,?,?,?,?,?) ");
		
		
		//일반회원 가입 쿼리
		if(memberDTO.getMtype().equals("N")) {
			sql.append("into myani(MNUM,MID,ANIMAL) values(myani_mnum_seq.nextval,?,?) ");
			sql.append("select * from dual");
			
			rows = jdbcTemplate.update(
					sql.toString(),
					memberDTO.getId(),
					memberDTO.getPw(),
					memberDTO.getTel(),
					memberDTO.getEmail(),
					memberDTO.getName(),
					memberDTO.getNickname(),
					memberDTO.getGender(),
					memberDTO.getAddress(),
					memberDTO.getBirth(),
					memberDTO.getMtype(),
					memberDTO.getId(),
					memberDTO.getAnimal()
			);
		}//일반회원가입 쿼리 끝
		
		//전문가회원가입 쿼리
		if(memberDTO.getMtype().equals("P")) {
			sql.append("into profession(PNUM,PID,LICENSENO) values(profession_pnum_seq.nextval,?,?) ");
			sql.append("select * from dual");
			
			rows = jdbcTemplate.update(
					sql.toString(),
					memberDTO.getId(),
					memberDTO.getPw(),
					memberDTO.getTel(),
					memberDTO.getEmail(),
					memberDTO.getName(),
					memberDTO.getNickname(),
					memberDTO.getGender(),
					memberDTO.getAddress(),
					memberDTO.getBirth(),
					memberDTO.getMtype(),
					memberDTO.getId(),
					memberDTO.getLicenseno()
			);
		}//전문가회원가입 쿼리 끝
		
		//사업자회원 전용 정보
		if(memberDTO.getMtype().equals("B")) {
			//병원 카테고리 포함됐을시 병원태그 체크
			String h_tags="";
			String h_tags_value="";
			if(memberDTO.getBhospital() != null) {
				h_tags+=",nightcare,rareani,visitcare,holidayopen,dental";
				
				if(memberDTO.getNightcare() != null)	h_tags_value+=",'Y'";
				else h_tags_value+=",'N'";
				if(memberDTO.getRareani() != null) h_tags_value+=",'Y'";
				else h_tags_value+=",'N'";
				if(memberDTO.getVisitcare() != null) h_tags_value+=",'Y'";
				else h_tags_value+=",'N'";
				if(memberDTO.getHolidayopen() != null) h_tags_value+=",'Y'";
				else h_tags_value+=",'N'";
				if(memberDTO.getDental() != null) h_tags_value+=",'Y'";
				else h_tags_value+=",'N'";
			}
			
			//(체크박스 사용시) 카테고리 체크
			int bc_count=0;
			if(memberDTO.getBhospital() != null) {
				bcategory+=",bhospital";
				bc_count++;
			}
			if(memberDTO.getBpharmacy() != null) {
				bcategory+=",bpharmacy";
				bc_count++;
			}
			if(memberDTO.getBhotel() != null) {
				bcategory+=",bhotel";
				bc_count++;
			}
			if(memberDTO.getBkindergarden() != null) {
				bcategory+=",bkindergarden";
				bc_count++;
			}
			if(memberDTO.getBfood() != null) {
				bcategory+=",bfood";
				bc_count++;
			}
			if(memberDTO.getBtraining() != null) {
				bcategory+=",btraining";
				bc_count++;
			}
			if(memberDTO.getBshop() != null) {
				bcategory+=",bshop";
				bc_count++;
			}
			if(memberDTO.getBplayground() != null) {
				bcategory+=",bplayground";
				bc_count++;
			}
			if(memberDTO.getBhairshop() != null) {
				bcategory+=",bhairshop";
				bc_count++;
			}
			if(memberDTO.getBetc() != null) {
				bcategory+=",betc";
				bc_count++;
			}
			//카테고리 갯수만큼 bcategory values에 'Y' 추가
			String bcategory_values = "";
			for(int i=0; i<bc_count; i++) {
				bcategory_values+=",'Y'";
			}
			
//				sql.append("insert all ");
//				sql.append("into MEMBER(ID,PW,TEL,EMAIL,NAME,NICKNAME,GENDER,ADDRESS,BIRTH,MTYPE) ");
//				sql.append("values (?,?,?,?,?,?,?,?,?,?) ");
			sql.append("into BUSINESS(BNUM,BBNUM,BID,BNAME,BADDRESS,BTELL"+h_tags+") ");
			sql.append("values(business_bnum_seq.nextval,?,?,?,?,?"+h_tags_value+") ");
			sql.append("into BCATEGORY(BNUM"+bcategory+") values(business_bnum_seq.currval"+bcategory_values+") ");
			sql.append("select * from dual");		
			
			rows = jdbcTemplate.update(
													sql.toString(),
													memberDTO.getId(),
													memberDTO.getPw(),
													memberDTO.getTel(),
													memberDTO.getEmail(),
													memberDTO.getName(),
													memberDTO.getNickname(),
													memberDTO.getGender(),
													memberDTO.getAddress(),
													memberDTO.getBirth(),
													memberDTO.getMtype(),
													memberDTO.getBbnum(),
													memberDTO.getId(),
													memberDTO.getBname(),
													memberDTO.getBaddress(),
													memberDTO.getBtell()
			);
			
			
		}// 사업자 회원 끝
	
	}

	/**
	 * 회원조회 by ID
	 */
	@Override
	public MemberDTO findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 회원수정 by ID
	 */
	@Override
	public void update(String id, MemberDTO memberDTO) {
		// TODO Auto-generated method stub

	}

	/**
	 * 회원탈퇴 by ID
	 */
	@Override
	public void out(String id) {
		// TODO Auto-generated method stub

	}

	/**
	 * 회원목록
	 */
	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 로그인
	 */
	@Override
	public MemberDTO findByIdPw(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 아이디찾기
	 */
	@Override
	public String findId(String tel, String birth) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 비밀번호찾기
	 */
	@Override
	public String findPw(String id, String tel, String birth) {
		// TODO Auto-generated method stub
		return null;
	}

}
