package 자바응용;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class 음식점주문화면2 {
	static int total = 0;
	static int f1 = 0;
	static int f2 = 0;
	static int f3 = 0;
	static int sum = 0;
	static JLabel l1, l2, l3;
	
	// 클래스 전체에서 접근 가능
	// main 안에서 사용하기 위해서는 main이 static이 붙어있음.
	// main 밖에 있는 변수도 static이 붙어있어야함.

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(600, 700);

		f.getContentPane().setBackground(Color.green);

		// FlowLayout
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);

		// Button
		JButton b1 = new JButton();
		b1.setText("짬뽕");

		JButton b2 = new JButton();
		b2.setText("우동");

		JButton b3 = new JButton();
		b3.setText("짜장");

		// Label. l1, l2, l3는 위에서 static으로 JLabel 만들었으므로 지워준다
		l1 = new JLabel();
		l1.setText("개수 : " + total + " 개");

		l2 = new JLabel();
		ImageIcon icon = new ImageIcon("main.png");
		l2.setIcon(icon);

		l3 = new JLabel();
		l3.setText("결제 금액 : " + total * 5000 + "원");
		
		JLabel l4 = new JLabel();
		l4.setText("짬뽕 수 : " + f1 + "개");

		JLabel l5 = new JLabel();
		l5.setText("우동 수 : " + f2 + "개");

		JLabel l6 = new JLabel();
		l6.setText("짜장 수 : " + f3 + "개");
		
		// add
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		
		// Font
		Font font = new Font("맑은 고딕", 1, 50);
		b1.setFont(font);
		b1.setBackground(Color.yellow);
		b2.setFont(font);
		b3.setFont(font);
		l1.setFont(font);
		l3.setFont(font);
		
		Font font2 = new Font("맑은 고딕", 1, 30);
		l4.setFont(font2);
		l5.setFont(font2);
		l6.setFont(font2);
		

		// Background 배경색
		b1.setBackground(Color.yellow);
		b2.setBackground(Color.yellow);
		b3.setBackground(Color.yellow);

		// Foreground 글자색
		b1.setForeground(Color.blue);
		b2.setForeground(Color.blue);
		b3.setForeground(Color.blue);
		l1.setForeground(Color.red);
		l3.setForeground(Color.red);
		
		//sum 계산 (f1=4000, f2=5000, f3=6000)
		//sum = 4000 * f1 + 5000 * f2 + 6000 * f3;
		

		// ActionListener
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 클릭했을 때 처리하고 싶은 내용을 쭉 써주면 된다.
				System.out.println("짬뽕 선택");
				f1++;
				show(); //공통부분
				l4.setText("짬뽕 수 : " + f1 + "개");				
			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 클릭했을 때 처리하고 싶은 내용을 쭉 써주면 된다.
				System.out.println("우동 선택");
				f2++;
				show();
				l5.setText("우동 수 : " + f2 + "개");
			}
		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 클릭했을 때 처리하고 싶은 내용을 쭉 써주면 된다.
				System.out.println("짜장 선택");
				f3++;
				show();
				l6.setText("짜장 수 : " + f3 + "개");
			}
		});

		// x를 눌렀을 때 자동으로 종료하고 싶음
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}//main
	
	// 공통부분
	public static void show() {
		total++;
		sum = 4000 * f1 + 5000 * f2 + 6000 * f3;
		l1.setText("개수 : " + total + " 개");
		l3.setText("결제 금액 : " + sum + "원");
	}

}
