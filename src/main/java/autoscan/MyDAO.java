package autoscan;

import org.springframework.stereotype.Repository;
/*
service-context.xml에서 component-scan으로 설정된 기본패키지에서
모델(저장소) 클래스 역할을 부여하기 위한 어노테이션으로, 스프링 컨테이너가
시작될때 자동으로 빈이 생성된다.
*/
@Repository
public class MyDAO {
	//생성자
	public MyDAO() {
		System.out.println("MyDAO 생성자 호출");
	}
	//데이터베이스에서 CRUD 작업을 처리한다고 가정한다.
	public void selectList() {
		System.out.println("게시판의 리스트를 출력합니다.");
	}
}
