package 메서드연습;

import java.io.File;

import javax.swing.JOptionPane;

public class 생성된일기장개수 {

	public void count() {
		File dir = new File("."); //프로젝트 위치
		String[] list = dir.list();
		int count = 0;
		
		for (String x : list) {
			if (x.contains(".txt")) {
				System.out.println(x);
				count++;
			}
		}
		JOptionPane.showMessageDialog(null, count + "개의 txt 파일이 있습니다.");
		System.out.println(count + "개의 txt 파일이 있습니다.");
	}

}
