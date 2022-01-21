package autoscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
service-context.xml에서 component-scan으로 설정된 기본패키지에서
서비스 클래스 역할을 부여하기 위한 어노테이션으로, 스프링 컨테이너가
시작될때 자동으로 빈이 생성된다.
*/
@Service
public class MyService {
	//생성자
	public MyService() {
		System.out.println("MyService 생성자 호출");
	}
	
	/*
	 서비스 객체는 클라이언트의 요청을 처리하기 위해 주로 Model(DAO)을
	 호출하여 비즈니스 로직을 처리한다.
	 작업을 위해 DAO 객체를 자동주입 받는다.
	 */
	MyDAO myDAO;
	
	@Autowired
	public void msetMyDAO(MyDAO myDAO) {
		this.myDAO = myDAO;
		System.out.println("setMyDAO() 호출-MyService");
	}
	
	//요청 처리를 위한 메서드라 가정한다.
	public void execute() {
		//DB처리를 위해 DAO의 메서드를 호출한다.
		myDAO.selectList();
	}
}
