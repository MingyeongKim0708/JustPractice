package 형변환응용;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class 네이버쇼핑크롤링 {

	public static void main(String[] args) {
		Connection conn = Jsoup.connect("https://shopping.naver.com/home"); // Connection이라는 부품 return
		System.out.println(conn); // 연결을 담당하는 객체
		try {
			Document doc = conn.get(); // html문서
			System.out.println(doc);
			System.out.println("=========================");
			Elements list = doc.select(".today_benefit .productCardResponsive_title__DVESp"); // 오늘의 혜택 목록만 출력
			System.out.println("=========================");
			System.out.println("-------------------------");
			System.out.println("!! 오늘의 혜택 목록 !!");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).text()); // 태그를 제외하고 text만 불러오기
			}
			// System.out.println("첫 번째 항목 확인\n" + list.get(0).text());
			System.out.println("=========================");

			// 클래스 확인용
			// <div class="today_benefit">
			// <strong class="productCardResponsive_title__DVESp">헤이미니 F/W 단독 ~81% 최저가</strong>
			// <strong class="productCardResponsive_title__DVESp"><em class="productCardResponsive_sub_text__aWDbR">최대 혜택</em>숨37 ~24%↓+10% 적립</strong>

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
