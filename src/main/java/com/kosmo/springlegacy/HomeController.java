package com.kosmo.springlegacy;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*
	 컨트롤러 만드는 순서
	 1. 요청명을 먼저 생성한다.
	 2. 요청명을 통해 컨트롤러를 찾아 매핑된 메서드를 호출한다.
	 	컨트롤러에서는 매핑명을 통해 메서드를 호출하므로 메서드명은
	 	중복되지 않는 정도의 이름을 사용하면 된다.
	 	매핑시에는 @RequestMapping 어노테이션을 사용한다.
	 * */
	@RequestMapping("/home/helloSpring")
	public String helloSpring(Model model) {
		/*
		 3. 요청을 처리한다.
		 	Spring에서는 4가지 영역과 비슷한 Model 객체를 사용해서 
		 	속성을 저장한다. 사용법은 거의 동일하다.
		 */
		String firstMessage = "My First Spring MVC Controller";
		model.addAttribute("firstMessage", firstMessage);
		
		/*
		 4. 뷰의 이름을 반환한다. 서블릿에서의 포워드와 비슷한 개념이다.
		 해당 뷰의 이름을 ViewResolver가 조립하여 최종적으로 뷰를 웹브라우저에
		 출력한다. 뷰의 기본 경로는 /webapp/WEB-INF/views 하위이다.
		 */
		return "HelloSpring";
	}
	
	
}
