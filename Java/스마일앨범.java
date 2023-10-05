package 메서드활용;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class 스마일앨범 {

	public static int start = 2;

	public static void main(String[] args) {
		// JAVA02(배열)_multi_배포용 p.117
		// 제목-String, 이미지(포스터)-String, 예매율(평점)-double
		String[] title = { "아빠스마일", "엄마스마일", "친구스마일", "형스마일", "나스마일" };
		String[] img = { "s1.png", "s2.png", "s3.png", "s4.png", "s5.png", };
		double[] jumsu = { 11.1, 22.2, 33.3, 44.4, 55.5 };

		JFrame f = new JFrame();
		f.setSize(500, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.pink);

		// 라벨3개
		JLabel top = new JLabel(title[2]);

		ImageIcon icon = new ImageIcon(img[2]);
		JLabel center = new JLabel();
		center.setIcon(icon);

		JLabel under = new JLabel(String.valueOf(jumsu[2]));
		// JLabel under = new JLabel(jumsu[2] + "");

		// 버튼2개
		JButton left = new JButton("<<");
		JButton right = new JButton(">>");

		// 폰트
		Font font = new Font("맑은 고딕", Font.BOLD, 35);
		top.setFont(font);
		left.setFont(font);
		right.setFont(font);
		under.setFont(font);

		// 색지정
		left.setBackground(Color.yellow);
		left.setForeground(Color.blue);
		left.setOpaque(true);
		left.setBorderPainted(false);
		right.setBackground(Color.yellow);
		right.setForeground(Color.blue);
		right.setOpaque(true);
		right.setBorderPainted(false);

		top.setForeground(Color.white);
		under.setForeground(Color.red);

		// add
		f.add(top, BorderLayout.NORTH);
		f.add(left, BorderLayout.WEST);
		f.add(center, BorderLayout.CENTER);
		f.add(right, BorderLayout.EAST);
		f.add(under, BorderLayout.SOUTH);

		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (start > 0) {
					start--; // 1
					top.setText(title[start]);
					under.setText(jumsu[start] + "");
					ImageIcon icon = new ImageIcon(img[start]);
					center.setIcon(icon);
				}else if (start == 0){
					JOptionPane.showMessageDialog(f, "마지막입니다.");
					start = 0;
				}
			}
		});

		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (start < 4) {
					start++; // 3
					top.setText(title[start]);
					under.setText(jumsu[start] + "");
					ImageIcon icon = new ImageIcon(img[start]);
					center.setIcon(icon);

				}else if (start == 4) {
					JOptionPane.showMessageDialog(f, "마지막입니다.");
					start = 4;
				}
			}
		});

		// 맨아래
		f.setVisible(true);

	}

}
