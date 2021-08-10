package com.kh.anitest3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.anitest3.domain.member.dto.MemberDTO_old;
import com.kh.anitest3.domain.member.svc.MemberSVC;
import com.kh.anitest3.web.form.JoinNormalForm;
import com.kh.anitest3.web.form.JoinSpecialForm;
import com.kh.anitest3.web.form.LoginMember;
import com.kh.anitest3.web.form.MyPageModi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	
	private final MemberSVC memberSVC;
	
	/**
	 * 회원가입유형선택
	 */
	@GetMapping("/join")
	public String joinSelectMtype() {
		
		return "/member/joinSelectMtype";
	}
	/**
	 * 회원가입폼
	 * @return
	 */
	@GetMapping("/join/{mtype}")
	public String joinForm(
			@PathVariable("mtype") String mtype, Model model) {
		
		//회원유형 선택화면에서 회원유형값 받아서 조인폼으로 넘겨야됨.
		//조인폼에서 받은 회원유형 값으로 보여줄 항목, 안보여줄 항목 선택되도록
		
		if(mtype.equals("일반"))	mtype="N";
		if(mtype.equals("특수"))	mtype="S";
		
		model.addAttribute("mtype", mtype);
		return "/member/joinForm";
	}
	
	//임시
	@PostMapping("/join")
	public String join(MemberDTO_old memberDTO) {
		
		memberSVC.join(memberDTO);
//		처리하고 인덱스로
		return "redirect:/main";
	}
	
	/**
	 * 일반회원가입처리
	 */
	@PostMapping("/join/N")
	public String joinNormal(JoinNormalForm joinNF) {
		
		memberSVC.join(joinNF);
		return "redirect:/main";
	}
	/**
	 * 특수회원가입처리
	 */
	@PostMapping("/join/S")
	public String joinSpecial(JoinSpecialForm joinSF) {
		
		memberSVC.join(joinSF);
		return "redirect:/main";
	}
	
	
	//마이페이지 뷰
	@GetMapping("/mypage/{mpMenuName}")
	public String mypage(
			@PathVariable("mpMenuName") String mpMenuName,
			Model model) {
		
//		메뉴에 따라 적합한 데이터를 받아서 모델에 담는다
//		정보수정, 회원탈퇴 이외에는 게시판 형식으로 비슷한 형태인 페이지들.
		switch (mpMenuName) {
		case "mypageFavorites":
//		memberSVC.~~
			break;
		case "mypageReview":
			
			break;
		case "mypagePost":
			
			break;
		case "mypageReply":
			
			break;
		case "mypageGood":
			
			break;
		case "mypageCopon":
			
			break;
		default:
			break;
		}
		
		
		
		model.addAttribute(mpMenuName);
//		return "/mypage/mypageBoardStylePages";
		return "/mypage/"+mpMenuName;
	}
	
	/**
	 * 회원조회 by ID
	 */
	@GetMapping("/member/{id}")
	public String findByID(String id) {
		
		MemberDTO_old memberDTO = memberSVC.findByID(id);
		
		return "";
	}
	
	/**
	 * 회원수정 진입전 비밀번호 재확인폼 by ID, PW
	 */
	@PostMapping("/member/{id}/modify")
	public String mypageModi(
			@PathVariable("id") String id,
			@SessionAttribute(name="loginMember",required = false) LoginMember loginMember,
			MyPageModi mpmf, RedirectAttributes redirectAttributes,
			Model model) {
		
		if(loginMember != null) {
			//로그인 되어있으면 콘솔창에 닉네임 출력
			log.info("별칭:{}", loginMember.getNickname());
		}else {
			//로그인 안했으면 로그인페이지로 보내기
			return "redirect:/login/loginForm";
		}
		
		//pathvariable의 id값, 세션정보의 id값 동일한지 확인하기
		//같지 않으면
		if(!loginMember.getId().equals(id)) {
			
			//돌려보내기
			return "redirect:/";
		}
		
		//id,pw 검색결과 확인
		MemberDTO_old memberDTO = memberSVC.findByIdPw(loginMember.getId(), mpmf.getPw());
		//결과가 null이면 (일치하는 정보가 없으면)
		if(memberDTO == null) {
			//돌려보내기
			return "redirect:/";
		}
		//회원수정양식에 전달하기 위해 모델에 담기
		model.addAttribute(memberDTO);
		redirectAttributes.addAttribute(memberDTO);
		//회원수정양식
		return "redirect:/mypage/{id}/modify";
	}
	
	@GetMapping("/member/{id}/modify")
	public String mypageModiForm() {
		
		
		
		return "";
	}
	
	
	
	/**
	 * 회원수정 by ID
	 */
	@PatchMapping("/member/{id}")
	public String update(String id,MemberDTO_old memberDTO) {
		
		
		return "redirect:/";
	}

	/**
	 * 회원탈퇴 by ID
	 */
	@DeleteMapping("/member/{id}")
	public String out(String id) {
		
		return "redirect:/";
	}

	/**
	 * 회원목록
	 */
	@GetMapping("/member/list")
	public String list() {
		
		return "";
	}
	

//	//로그인
//	MemberDTO findByIdPw(String id,String pw);
//	
//	//아이디찾기
//	String findId(String tel, String birth);
//	
//	//비밀번호찾기
//	String findPw(String id, String tel, String birth);
	
	
}
