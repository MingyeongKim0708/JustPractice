package 상속응용;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class 문자판독기 extends JFrame{
	//전역변수는 자동초기화, 참조형 변수 ==> null. new로 만들어지면 주소가 생성됨
	JLabel ch, words, chCount, wordsCount;
	JTextArea area;
	JButton b1, b2, b3, b4;
	int c, c2, d; //색상 변경용 전역변수

	//생성자 - 인스턴스가 생설될 때 자동으로 호출되어서 객체를 초기화하는 멤버 함수(메서드)
	public 문자판독기(){
		setTitle("문자판독기");
		setSize(700,600);
		
		//라벨 생성
		ch = new JLabel("문자수 >> ");
		words = new JLabel("단어수 >> ");
		chCount = new JLabel("문자수 결과 들어갈 자리");
		wordsCount = new JLabel("단어수 결과 들어갈 자리");
		
		//area 생성
		area = new JTextArea(5, 15); //세로 5줄, 가로 10글자
		
		//버튼 생성
		b1 = new JButton("글자수 카운트");
		b2 = new JButton("배경색 변경");
		b3 = new JButton("글자색 변경");
		b4 = new JButton("다크모드로 변경");
		
		//레이아웃 설정 (FlowLayout - 순서대로)
		setLayout(new FlowLayout());
		
		//add
		add(ch);
		add(chCount);
		add(words);
		add(wordsCount);
		add(area);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		//Font
		Font font = new Font("맑은 고딕", Font.BOLD, 35);
		ch.setFont(font);
		chCount.setFont(font);
		words.setFont(font);
		wordsCount.setFont(font);
		area.setFont(font);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		
		//색상
		chCount.setForeground(Color.red);
		wordsCount.setForeground(Color.red);
		area.setBackground(Color.YELLOW);
		area.setForeground(Color.blue);
		
		getContentPane().setBackground(Color.pink);
		
		
		Color[] colors = { Color.red, Color.yellow, Color.green }; // colors[0], colors[1], colors[2]
		Color[] colors2 = { Color.black, Color.white, Color.blue }; // colors2[0], colors2[1], colors2[2]
		Color[] darklight = { Color.GRAY, Color.white }; //다크모드, 라이트모드
		Color[] darklight2 = { Color.white, Color.black }; //다크모드, 라이트모드
		
		//버튼 액션
		//인터페이스 - 익명클래스 생성
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 클릭했을 때 처리할 내용
				// 모의코드(수도코드, pseudo code)
				// 입력한 문자열을 가지고 와서 저장
				String s = area.getText();
				// 글자수 카운트하기
				int num = s.length();
				// 단어수 계산하기
				String[] s2 = s.split(" "); //공백으로 나눔 {단어, 단어, 단어}
				int num2 = s2.length;
				
				// 각각의 라벨에 넣기
				chCount.setText(num + ""); //정석 : String.valueOf(num)
				wordsCount.setText(num2 + "");
			}
		});
				
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 클릭했을 때 처리할 내용
				// 모의코드
				// 배경색을 배열에 들어있는 색상으로 순서대로 변경
				// seq05- 배열스윙- 많은버튼만들기색깔다르게 참고
				
				area.setBackground(colors[c]);
				c++;
				if(c==3) {
					c = 0;
				}
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//모의 코드
				//글자색을 배열에 들어있는 색상으로 순서대로 변경
				area.setForeground(colors[c2]);
				c2++;
				if(c2==3) {
					c2 = 0;
				}
			}
		});
		
		String[] mode = {"라이트모드로 변경", "다크모드로 변경"};
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				b4.setText(mode[d]);
				area.setBackground(darklight[d]);
				area.setForeground(darklight2[d]);
				getContentPane().setBackground(darklight[d]);
				d++;
				if(d==2) {
					d = 0;
				}
			}
		});
		
		
		//종료 및 표시
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//메인
	public static void main(String[] args) {
		문자판독기 name = new 문자판독기();
	}

}
