package autoscan;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class LottoDAO {
	public LottoDAO(){
		System.out.println("LottoDAO 생성자 호출");
	}
	
	public int getLottoNumber() {
		//1~6 사이의 난수를 생성한다.
		Random rand = new Random();
		//생성된 난수는 서비스 객체로 반환된다.
		return rand.nextInt(6)+1;
	}
}
