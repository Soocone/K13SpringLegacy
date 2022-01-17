package com.kosmo.springlegacy;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.MemberDTO;

/*
 사용자의 요청을 제일 먼저 받는 DispatcherServlet은 기본패키지로 지정된
 com.kosmo.springlegacy를 스캔하여 컨트롤러 클래스를 찾아낸다. 그리고 해당
 요청명에 매핑된 메서드를 찾아 요청을 전달하고 로직을 수행한다.
 
 @Controller
 	: 해당 클래스를 컨트롤러로 사용하고 싶을때 클래스명 앞에 선언한다.
 	패키지를 스캔할때 해당 어노테이션이 있는 클래스를 찾아서 요청을 전달한다.
 @RequestMapping
 	: 요청명을 매핑한다. 요청명은 서블릿과 마찬가지고 컨택스트루트를 제외한
 	나머지 경로명으로 이루어진다. 바깥에서 요청명의 매핑정보로 메서드를 
 	호출하므로 여기서 메서드명은 큰 의미가 없다. 개발자가 구분하기 좋은 
 	정도의 이름으로 설정하면 된다.
 */
@Controller
public class FormController {
	/*
	 폼값받기1] 파라미터로 전달된 값을 HttpServletRequest 내장객체를 통해 받는다.
	 JSP나 Servlet에서 주로 사용하는 방식이다.
	 */
	@RequestMapping("/form/servletRequest")
	public String loginMember(HttpServletRequest req, Model model) {
		//request 내장객체의 getParameter()를 사용한다.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//View로 전달한 데이터를 Model 객체에 저장한다.
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("message", "로그인 정보가 전달되었습니다.");
		
		/*
		 View의 페이지 경로를 반환한다. 아래처럼 String으로 반환하면
		 ViewResolver가 전체 경로를 조립하여 웹브라우저에 출력한다.
		 */
		return "01Form/servletRequest";
	}
	
	/*
	 폼값받기2] @RequestParam 어노테이션으로 폼값받기
	 	파라미터 형식으로 아래와 같이 사용한다. 이와 같이 하면
	 	해당 메서드 내에서 변수명을 그대로 사용할 수 있다.
	 */
	@RequestMapping("/form/requestParam.do")
	public String joinMember(Model model,
			@RequestParam("name") String name,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("email") String email) {
		
		//getParamater()로 받는 대신 어노테이션으로 받은 후 변수에 저장한다.
		
		//받은 폼값을 DTO 객체에 저장한다.
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setEmail(email);
		memberDTO.setName(name);
		
		//DTO 객체를 Model 객체에 저장한 후 View 호출
		model.addAttribute("memberDTO", memberDTO);

		//View 호출
		return "01Form/requestParam";
	}
	
	
	/*
	 폼값받기3] 커맨드 객체를 이용해서 폼값 한번에 받기
	 조건1: 쿼리스트링으로 전달되는 파라미터의 갯수와 폼값을 저장할 객체
	 	(DTO 혹은 VO)의 멤버변수의 갯수가 동일한 것을 권장한다.
	 조건2: 커맨드 객체를 사용할때는 클래스명 앞글자를 소문자로 바꾼 형태의
	 	매개변수를 사용해야 한다. 
	 	Ex) MemberDTO -> memberDTO
	 조건3: 커맨드객체를 만들때 파라미터의 갯수는 달라도 상관없으나
	 	파라미터명과 멤버변수명은 동일해야되고 이에 해당하는
	 	getter/setter가 반드시 생성되어야 한다.
	 */
	@RequestMapping("/form/commandObjGet.do")
	public String commandObjGet(MemberDTO memberDTO) {
		return "01Form/commandObjGet";
	}
	
	
	/*
	 폼값받기4] @PathVariable 어노테이션 사용하기
	 요청명 뒤에 경로처럼 붙은 값이 실제 사용 가능한 파라미터가 된다.
	 파라미터를 마치 경로명처럼 사용하게 되고, 이때 주의해야 할 점은
	 웹브라우저는 요청명을 경로로 인식하므로 리소스를 사용할때 경로를
	 주의해야 한다. 또한 파라미터의 갯수가 틀려지면 404에러가 발생된다.
	 */
	@RequestMapping("/form/{memberId}/{memberName}")
	public String pathVariable(Model model,
			@PathVariable String memberId,
			@PathVariable String memberName) {
		
		model.addAttribute("memberId", memberId);
		model.addAttribute("memberName", memberName);
		
		return "01Form/pathVariable";
	}
}
