package 배열스윙;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class 영화좌석예매 {

	// 전역변수선언
	static int count; // 전역변수는 자동초기화!
	static String no = "";

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1500, 1000);
		f.setTitle("영화좌석예매");

		// FlowLayout
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);

		// 배경색 설정
//		Container c = f.getContentPane(); //Container
//		c.setBackground(Color.green);
		f.getContentPane().setBackground(Color.green); // 체인식 코드(편하기 때문에 사용 가능)

		// 버튼이 들어갈 배열
		JButton[] buttons = new JButton[500];

		// 버튼만들기
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			// buttons[i].setText(i + ""); //setText(스트링 넣어야함)
			buttons[i].setText(String.valueOf(i)); // i값을 String으로 바꿔줌.정석 방법
		}

		Random r = new Random();
		Color[] colors = { Color.red, Color.yellow, Color.pink }; // colors[0], colors[1], colors[2]

		// 버튼위치랜덤
		for (int i = 0; i < buttons.length; i++) {
			int index = r.nextInt(3); // 0,1,2
			buttons[i].setBackground(colors[index]); // 색깔 설정
			f.add(buttons[i]);

			// 버튼을 눌렀을 때 작동
			buttons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// 버튼 클릭했을 때 처리하고 싶은 내용
					count++;
					String s = e.getActionCommand(); // 버튼 위에 글자를 가지고 와줘요
					no = no + s + " "; //누른 좌석번호 누적
					int pay = count * 1000;
					JOptionPane.showMessageDialog(f,
							s + "번을 클릭하셨군요!" + "\n현재 결재금액은" + 
							pay + "원 입니다.\n좌석 번호는 " +
							no);
					
					//목록에 있으면 이미 있는 자리입니다 -- 어떻게 해야하는거지
					
					//예매한 것 더 예매 못하도록 클릭을 막아버림
					JButton b = (JButton)e.getSource(); //object
					b.setBackground(Color.blue);
					b.setEnabled(false);
				};
			});
		}

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
