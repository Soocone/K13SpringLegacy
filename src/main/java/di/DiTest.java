package di;

class Persons{
	String name;
	int age;
	
//	public Persons() {
//		//public 생성자 정의
//	}
	
	private Persons() {
		//public 생성자 정의
	}
}
public class DiTest {
	
	/*
	 강한결합(독립성 낮음): new를 통해 직접 객체를 생성한다.
	 	결합도가 높기 때문에 person 클래스의 변화에 직접적인 영향을 받는다.
	 */
	public static void aPerson() {
		//생성자가 private이 되는 순간 에러가 발생한다.
		Persons persons1 = new Persons();
		persons1.age = 11;
		persons1.name = "성유겸";
	}
	
	
	/*
	 약한결합(독립성 높음): 미리 생성된 객체를 주입(Injection)받음
	 	결합도가 낮아지기 때문에 Perosons 클래스에 변화가 생기더라도
	 	직접적인 영향을 받지 않는다. 또한 코드도 좀 더 간결해진다.
	 */
	public static void bPerson(Persons p) {
		p.age = 30;
		p.name = "개똥이";
	}
}
