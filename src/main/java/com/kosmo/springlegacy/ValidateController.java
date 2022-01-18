package com.kosmo.springlegacy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import common.MemberDTO;
import common.MemberValidator;

@Controller
public class ValidateController {
	//회원가입폼에 대한 매핑만 처리
	@RequestMapping("/validate/memberRegist.do")
	public String memberRegist() {
		return "03Validate/memberRegist";
	}
	
	
	//폼값을 전송했을때의 요청 처리
	/*
	 메서드의 첫번째 파라미터
	 	: 폼값을 커맨드 객체를 통해 한번에 받은 후 어노테이션으로
	 	모델객체에 저장시 mInfo로 이름을 변경한다.
	 두번째 파라미터
	 	: BindingResult 객체는 validator를 통해 폼값을 검증한 후 해당 결과를
	 	전송받을 객체로, 폼값에 문제가 있다면 해당 객체를 통해 확인할 수 있다.
	 세번째 파라미터
	 	: 데이터를 저장할 Model 객체
	 */
	@RequestMapping("/validate/registProc.do")
	public String registProc(
			@ModelAttribute("mInfo") MemberDTO memberDTO,
			BindingResult result,
			Model model) {
		
		//폼값 검증 완료시 이동할 페이지의 경로  
		String viewPage = "03Validate/memberDone";
		
		/*
		 유효성 검증을 위해 정의한 클래스의 객체를 생성한 후 전송된 폼값을
		 저장한 커맨드 객체를 통해 폼값의 유효성 체크를 실시한다. 매개변수로
		 유효성 체크를 할 커맨드 객체와 바인딩 결과(검증결과)를 저장할 객체를
		 인수로 전달한다.
		 */
		MemberValidator validator = new MemberValidator();
		validator.validate(memberDTO, result);
		
		//만약 유효성 검증에 실패했다면
		if(result.hasErrors()) {
			System.out.println("유효성 체크 실패:"+ result.toString());
			//Model 객체에 에러메세지를 저장한 후
			model.addAttribute("formError", "폼값 유효성 체크에 실패하였습니다.");
			//가입 페이지로 다시 이동한다.
			viewPage = "03Validate/memberRegist";
		}
		return viewPage;
	}
	
}
