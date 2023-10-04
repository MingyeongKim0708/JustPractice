package 메서드연습;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class 로그인화면 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("로그인화면");
		f.setSize(500, 700); // void

		// 라벨3개, 텍스트필드2개, 버튼2개
		JLabel top = new JLabel();
		// top.setText("<< 이미지 들어가는 곳 >>");
		JLabel id1 = new JLabel();
		id1.setText("ID : ");
		JLabel pw1 = new JLabel();
		pw1.setText("PW : ");

		// 텍스트필드2개
		JTextField id2 = new JTextField(10); // 글자수 지정
		JTextField pw2 = new JTextField(10);
		id2.setBackground(Color.pink);
		id2.setForeground(Color.blue);
		pw2.setBackground(Color.pink);
		pw2.setForeground(Color.blue);

		// 버튼2개
		JButton login = new JButton();
		// login.setText("로그인"); //이미지 넣을거라 텍스트 없앰
		login.setBackground(Color.yellow);
		login.setOpaque(true); // 불투명 true
		login.setBorderPainted(false);

		JButton reset = new JButton();
		// reset.setText("지우기");
		reset.setBackground(Color.yellow);
		reset.setOpaque(true); // 불투명 true
		reset.setBorderPainted(false);

		// 폰트
		Font font = new Font("맑은 고딕", 1, 35);
		top.setFont(font);
		id1.setFont(font);
		pw1.setFont(font);
		id2.setFont(font);
		pw2.setFont(font);
		login.setFont(font);
		reset.setFont(font);

		// 레이아웃 부품 flowlayout
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow); // void
		// 이미지 끼기
		ImageIcon icon1 = new ImageIcon("diary.png");
		ImageIcon icon2 = new ImageIcon("login.png");
		ImageIcon icon3 = new ImageIcon("reset.png");
		top.setIcon(icon1);
		login.setIcon(icon2);
		reset.setIcon(icon3);

		f.add(top); // void
		f.add(id1); // 라벨
		f.add(id2); // 텍스트필드
		f.add(pw1); // 라벨
		f.add(pw2); // 텍스트필드
		f.add(login); // 버튼
		f.add(reset); // 버튼

		// 버튼에 이벤트기능을 붙여줍시다.
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Login버튼을 눌렀을 때 실행할 내용을 넣어주세요.
				// 버튼 하나당 함수 하나로 매칭!
				System.out.println("로그인버튼 클릭함");
				//1. id2, pw2에서 입력한 데이터를 가지고 온다.
				//2. id2의 값이 root인지, pw2의 값이 1234인지 확인
				//	둘다 맞으면 맞아요! 출력, 둘 중 하나라도 틀리면 틀려요! 출력
				String id3 = id2.getText();
				String pw3 = pw2.getText();
				
				if(id3.equals("root") && pw3.equals("1234")) {
					//System.out.println("맞아요!");
					JOptionPane.showMessageDialog(f, "로그인 성공! 일기장이 오픈됩니다.");
					//일기장화면떠라
					일기쓰기화면 diary = new 일기쓰기화면();
					diary.open();
					f.setVisible(false); //로그인 화면 끄기
				}else {
					//System.out.println("틀려요!");
					JOptionPane.showMessageDialog(f, "틀려요!");
				}
			}
		}); //login
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("리셋버튼 클릭함");
				//1. id2, pw2의 내용을 지우자!
				id2.setText(""); //void O <->String id3 = id2.getText(); ==> void X
				pw2.setText("");
			}
		});//reset

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 위에서 설정한 것을 다 보여라
		f.setVisible(true); // void

	}

}
