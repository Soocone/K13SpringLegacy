package di;

import java.util.ArrayList;

public class Person {
	//3가지 형태의 멤버변수를 가진 클래스 생성
	private String name;
	private int age;
	private ArrayList<String> hobbys;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<String> getHobbys() {
		return hobbys;
	}
	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	//멤버변수 출력용 메서드
	public String getInfo() {
		return String.format("이름:%s<br/>"
				+ "나이:%s<br/>"
				+ "취미:%s<br/>", name, age, hobbys);
	}
}
