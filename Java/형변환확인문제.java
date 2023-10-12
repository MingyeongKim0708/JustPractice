package 형변환개념;

import java.util.ArrayList;

public class 형변환확인문제 {

	public static void main(String[] args) {
		ArrayList me = new ArrayList();
		me.add(1000);// Object <--업캐스팅(자동형변환)-- Integer(클래스) <--(오토박싱)-ㄴ- int(기본형)
		me.add(189.1);
		me.add(false);
		me.add('남');

		System.out.println(me);
		int money = (int) me.get(0); // int <-(자동으로 바꿈)- Integer <-(강제형변환필요)- Object
		int moneyR = money + 2000;
		System.out.println(moneyR);

		double height = (double) me.get(1); // double <-- Double <-- Object
		double heightR = height + 10;
		System.out.println(heightR);

		boolean breakfast = (boolean) me.get(2); // boolean <-- Boolean <-- Object
		if (breakfast == true) {
			System.out.println("배불러요");
		} else {
			System.out.println("배고파요.");
		}

		char gender = (char) me.get(3); // char <-(오토언박싱)- Character <-(다운캐스팅. 강제형변환)- Object
		if (gender == '남') {
			System.out.println("주민번호는 1, 3이예요.");
		} else {
			System.out.println("주민번호는 2, 4이예요.");

			// ArrayList에는 다양한 타입을 넣을 수 있긴 하다.
			// 실제 코드할 때 다양한 타입을 넣는 경우가 정말 흔치않다.
			// 매번 넣을때마다 형변환을 해야할까?
			ArrayList<String> list = new ArrayList<>();
			// <> 꺽쇠를 쓰면 객체를 생성할 때 타입을 결정할 수 있음. ==> 제너릭(제너럴, 일반적인) 프로그래밍
			// <클래스>만 쓸 수 있다. 기본형 사용 불가

			list.add("홍길동");
			list.add("홍길동2");
			list.add("홍길동3");
			String s = list.get(0); // 강제형변환을 하지 않아도 그냥 변수에 넣을 수 있다.
		}

	}

}
