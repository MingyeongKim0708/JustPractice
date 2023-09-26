package 배열응용;

import java.util.Arrays;
import java.util.Scanner;

public class 여행문제2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] last = new String[3];
		String[] year = new String[3];
		
		for (int i = 0; i < last.length; i++) {
			System.out.print("작년에 가고 싶었던 곳을 입력하세요 >> ");
			last[i] = sc.next();
		}
		for (int i = 0; i < year.length; i++) {
			System.out.print("올해 가고 싶었던 곳을 입력하세요 >> ");
			year[i] = sc.next();
		}
		
		System.out.println(Arrays.toString(last));
		System.out.println(Arrays.toString(year));
		
		//우선순위와 상관없이 작년과 올해에도 가고 싶은 장소가 동일한 것은 몇 개인가?
		int same = 0, diff = 0;
		System.out.print("우선순위와 상관없이 작년과 올해에도 가고 싶은 장소 : " );
		for (int i = 0; i < year.length; i++) {
			for (int j = 0; j < year.length; j++) {
				if (last[i].equals(year[j])) {
					same++;
					System.out.print(year[j] + " ");
				}else {
					diff = year.length - same; 
				}
			}//for j
		}//for i
		System.out.println();
		System.out.println("우선순위와 상관없이 작년과 올해에도 가고 싶은 장소가 동일한 곳의 수 : " + same);
		System.out.println("우선순위와 상관없이 작년과 올해에도 가고 싶은 장소가 다른 곳의 수 : " + diff);
		
		
		
//		//1.작년과 올해에도 가고 싶은 장소가 동일한 것은 몇 개인가?
//		//2.작년과 올해에 가고 싶은 장소가 달라진 것은 몇 개인가?
//		//1-2)작년과 올해에도 가고 싶은 장소가 동일한 곳은 "어디인가?"
//		int same = 0, diff = 0;
//		for (int i = 0; i < year.length; i++) {
//			if (last[i].equals(year[i])) { //ex.같지 않냐고 물을 때는 !(last[i].equals(year[i]))
//				same++;
//				System.out.println("작년과 올해 가고 싶은 곳과 우산 순위가 동일한 곳 : " + last[i]);
//			}else {
//				diff++;
//			}
//		}
//				
//		System.out.println("작년과 올해 가고 싶은 곳과 우선 순위가 동일한 곳의 수 : " +  same);
//		System.out.println("작년과 올해 가고 싶은 곳과 우선 순위가 달라진 곳의 수 : " +  diff);
	}

}
