package common;

import java.util.Random;

public class LottoCreater {

	//난수 생성을 위한 객체 생성
	Random rnd = new Random();
	
	//난수를 통해 6개의 번호를 생성한다.
	public void randomCreate(int[] arrParam) {
		rnd.setSeed(System.currentTimeMillis());
		while(true) {
			//배열 크기만큼 반복해서 난수 생성
			for(int i=0 ; i<arrParam.length ; i++) {
				arrParam[i] = rnd.nextInt(45) + 1;
			}
			//배열에 중복된 값이 있는지 확인한다.
			boolean rndFlag = false;
			for(int i=0 ; i<arrParam.length ; i++) {
				for(int j=0 ; j<arrParam.length ; j++) {
					if(i!=j && arrParam[i]==arrParam[j]) {
						rndFlag = true;
					}
				}
			}
			//만약 중복된 값이 없다면 while loop를 탈출한다.
			if(rndFlag==false) break;
		}
	} 
	//생성된 난수를 오름차순 정렬한다.(버블정렬)
	public static void bubbleSort(int[] arrParam) {
		int temp;
		for(int i=0 ; i<arrParam.length-1 ; i++) {
			for(int j=0 ; j<(arrParam.length-1)-i ; j++) {
				if(arrParam[j] > arrParam[j+1]) {
					temp = arrParam[j];
					arrParam[j] = arrParam[j+1];
					arrParam[j+1] = temp;
				}
			}
		}
	}
	//6개의 난수 생성후 오름차순 정렬해서 호출한 지점으로 반환한다.
	public int[] lotto() {
		int[] arr = new int[6];
		randomCreate(arr);		
		bubbleSort(arr);
		return arr;
	}
}
