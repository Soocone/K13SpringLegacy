package com.kosmo.springlegacy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import common.StudentDTO;

@Controller
public class RequestMappingController {
	
	//get방식 혹은 post방식의 전송을 위한 인덱스 페이지 매핑
	@RequestMapping("/requestMapping/index.do")
	public String rmIndex() {
		return "02RequestMapping/index";
	}
	
	/*
	 단순히 요청명만 매핑하는 경우에는 value, method를 생략할 수 있으나
	 전송방식까지 명시해야할 경우에는 속성을 제거하면 에러가 발생한다.
	 */
	@RequestMapping(value="/requestMapping/getSearch.do",
			method=RequestMethod.GET)
	public String getSearch(HttpServletRequest req, Model model) {
		/*
		 요청 처리를 위한 메서드를 정의할때 해당 메서드에서 사용하고자 하는
		 내장객체가 있다면 매개변수형태로 선언하면 즉시 사용할 수 있다.
		 즉, 컨트롤러에 정의되는 메서드는 매개변수의 갯수가 큰 의미를 가지지 않는다.
		 */
		System.out.println("RequestMethod.GET방식으로 폼값 전송");
		
		//request 내장객체로 폼값 받기
		String sColumn = req.getParameter("searchColumn");
		String sWord = req.getParameter("searchWord");
		
		//Model 객체에 데이터 저장하기
		model.addAttribute("sColumn", sColumn);
		model.addAttribute("sWord", sWord);
		
		//뷰 호출하기
		return "02RequestMapping/getSearch";
	}
	
	
	@RequestMapping(value="/requestMapping/postLogin.do",
			method=RequestMethod.POST)
	public ModelAndView postLogin(
			@RequestParam("user_id") String id,
			@RequestParam("user_pw") String pw) {
		
		/*
		 MdelAndView 객체
		 	: View로 전송할 데이터의 저장과 View를 호출하는 2가지 기능을
		 	동시에 처리할 수 있는 클래스
		 	- View 설정: 참조변수.setViewName("뷰의 경로 및 파일명")
		 	- model객체에 데이터 저장: 참조변수.addObject("속성명", "속성값")
		 	최종적으로 뷰를 호출할때는 ModelAndView 참조변수를 return한다.
		 */
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("02RequestMapping/postLogin");
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		
		/*
		 ModelAndView 객체를 반환하여 뷰를 호출한다. 따라서 해당 메서드의
		 반환타입도 동일 객체로 지정해야 한다.
		 */
		return mv;
	}
	
	
	/*
	 @ModelAttribute어노테이션
	 	: 뷰로 전달되는 커맨드 객체의 이름을 임의로 변경하고 싶을때
	 	사용한다. studentDTO를 si로 변경하여 뷰로 전달한다.
	 */
	@RequestMapping("/requestMapping/modelAttribute")
	public String studentInfo(
			@ModelAttribute("si") StudentDTO studentDTO) {
		return "02RequestMapping/modelAttribute";
	}
}
