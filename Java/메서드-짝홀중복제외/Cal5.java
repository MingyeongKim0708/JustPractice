package 메서드활용;

import java.util.ArrayList;
import java.util.HashSet;

public class Cal5 {

	public ArrayList<Integer> getEven(int[] num) {
		//배열의 값 중 짝수만 골라서 list에 넣어서 리턴. ArrayList<Integer>사용.
		//고정된 크기(5개) -> 배열 사용
		//가변적인 크기 -> 배열 사용 X -> 컬렉션 사용 -> ArrayList<타입>
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer x : num) {
			if (x % 2 == 0) {
				list.add(x); //list 컬렉션에 계쏙 쌓임
			}
		}//for
		return list;
	}
	public ArrayList<Integer> getOdd(int[] num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer x : num) {
			if (x % 2 == 1) {
				list.add(x); //list 컬렉션에 계쏙 쌓임
			}
		}//for
		return list;
	}
	public HashSet<Integer> getUnique(int[] num){
		HashSet<Integer> list = new HashSet<Integer>();
		for (Integer x : num) {
			list.add(x);
		}
		return list;
	}
}
