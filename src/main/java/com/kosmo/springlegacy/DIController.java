package com.kosmo.springlegacy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import di.AnnotationBean;
import di.Circle;
import di.Person;

@Controller
public class DIController {
	@RequestMapping("/di/mydi1.do")
	public ModelAndView mydi1(Model model) {
		//Model에 저장과 View 경로를 동시에 설정할 수 있는 객체
		ModelAndView mv = new ModelAndView();
		
		//XML 설정파일의 위치를 설정
		String configLocation = "classpath:my_di1.xml";
		
		//설정파일을 통해 스프링 컨테이너 생성
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		//컨테이너에 생성된 빈을 getBean()을 통해 주입받는다
		Circle circle = ctx.getBean("circle", Circle.class);
		
		//뷰의 경로 및 모델에 데이터 저장
		mv.setViewName("04DI/mydi1");
		mv.addObject("circle", circle);
		
		return mv;
	}
	
	
	@RequestMapping("/di/mydi2.do")
	public ModelAndView mydi2(Model model) {
		//Model에 저장과 View 경로를 동시에 설정할 수 있는 객체
		ModelAndView mv = new ModelAndView();
		
		//XML 설정파일을 기반으로 생성한 컨텍스트를 통해 빈을 주입받는다.
		String configLocation = "classpath:my_di2.xml";
		
		//설정파일을 통해 스프링 컨테이너 생성
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		//컨테이너에 생성된 빈을 getBean()을 통해 주입받는다
		Person person = ctx.getBean("person", Person.class);
		
		//뷰의 경로 및 모델에 데이터 저장
		mv.setViewName("04DI/mydi2");
		mv.addObject("person", person.getInfo());
		
		return mv;
	}
	
	
	//어노테이션을 통한 빈 생성 및 주입받기
	@RequestMapping("/di/mydi3.do")
	public ModelAndView mydi3(Model model) {
		//Model에 저장과 View 경로를 동시에 설정할 수 있는 객체
		ModelAndView mv = new ModelAndView();
		
		//어노테이션을 통해 생성된 빈을 주입받기 위한 컨텍스트 선언
		AnnotationConfigApplicationContext aCtx = 
				new AnnotationConfigApplicationContext(AnnotationBean.class);
		
		//생성된 빈을 getBean()을 통해 주입받는다
		Circle circle1 = aCtx.getBean("circleBean", Circle.class);
		Person person1 = aCtx.getBean("personBean", Person.class);
		
		//뷰의 경로 및 모델에 데이터 저장
		mv.setViewName("04DI/mydi3");
		mv.addObject("person", person1.getInfo());
		mv.addObject("circle", circle1);
		
		return mv;
	}
}
