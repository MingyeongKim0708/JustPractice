package 메서드연습;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class 일기쓰기화면 {
	// 멤버변수
	// 멤버메서드(*)

	// main에 넣어서 테스트 후 작동하면 open()에 넣기
	public void open() {
		JFrame f = new JFrame();
		f.setTitle("일기장쓰기화면");
		f.setSize(600, 700);

		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);

		// 라벨 생성
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		JLabel l3 = new JLabel();

		// 텍스트필드, 텍스트에어리어 생성
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextArea t3 = new JTextArea(5, 10);

		// 버튼 생성
		JButton save = new JButton();
		JButton delete = new JButton();
		JButton count = new JButton();

		// 텍스트 넣기
		l1.setText("오늘의 날짜");
		l2.setText("오늘의 제목");
		l3.setText("오늘의 내용");

		save.setText("파일에 일기 저장");
		delete.setText("칸비우기");
		count.setText("파일 개수");

		// 색상
		f.getContentPane().setBackground(Color.green);

		t1.setBackground(Color.yellow);
		t1.setForeground(Color.black);
		t1.setOpaque(true); // 불투명 true

		t2.setBackground(Color.yellow);
		t2.setForeground(Color.black);
		t2.setOpaque(true); // 불투명 true

		t3.setBackground(Color.yellow);
		t3.setForeground(Color.black);
		t3.setOpaque(true); // 불투명 true

		save.setBackground(Color.yellow);
		save.setForeground(Color.red);
		save.setOpaque(true); // 불투명 true
		save.setBorderPainted(false);

		delete.setBackground(Color.red);
		delete.setForeground(Color.white);
		delete.setOpaque(true); // 불투명 true
		delete.setBorderPainted(false);

		count.setBackground(Color.pink);
		count.setForeground(Color.white);
		count.setOpaque(true); // 불투명 true
		count.setBorderPainted(false);

		// 폰트
		Font font = new Font("맑은 고딕", 1, 35);
		Font font2 = new Font("맑은 고딕", 1, 50);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		save.setFont(font2);
		delete.setFont(font2);
		count.setFont(font2);

		// 추가
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(save);
		f.add(delete);
		f.add(count);

		// 이벤트 save
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e2) { // 아래 catch에 e가 있어서 e2로 변경
				String day = t1.getText();
				String title = t2.getText();
				String content = t3.getText();

				try {
					FileWriter file = new FileWriter(day + ".txt");
					file.write(day + "\n");
					file.write(title + "\n");
					file.write(content + "\n");
					file.close(); // stream을 닫는다
					JOptionPane.showMessageDialog(f, "일기저장완료");
					t1.setText("");// 저장하고 난 다음 칸을 공백으로 만든다
					t2.setText("");
					t3.setText("");
				} catch (IOException e) {
					System.out.println("에러발생함!");
					e.printStackTrace(); // 자세하게 에러정보도 볼 수 있음
				}
			}
		});

		// 이벤트 delete
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");

			}
		});

		// 이벤트 count
		count.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				생성된일기장개수 c1 = new 생성된일기장개수();
				c1.count(f); //231005 생성된 일기장 개수 count 메서드에 JFrame f를 추가함 -> f위에서 JOptionPane.showMessageDialog이 뜰 것임
			}
		});

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}
}
