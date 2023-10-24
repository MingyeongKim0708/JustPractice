package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class BbsDAO { // member테이블에 crud를 하고 싶으면 MemberDAO를 사용하면 됨.!
	Connection con = null; // 클래스 바로 아래에 만들어주면 클래스 전체영역에서 사용 가능
	DBConnectionMgr dbcp; // null

	public BbsDAO() {
		try {
			dbcp = DBConnectionMgr.getInstance();
			con = dbcp.getConnection();// 임대
		} catch (Exception e) {
			System.out.println("에러발생!!");
		}
	}
	
	public BbsVO one(int no) {
		BbsVO bag = new BbsVO();
		try {

			String sql = "select * from bbs where no = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setInt(1, no); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");

			ResultSet table = ps.executeQuery(); //테이블로 mysql로 받아온다. 
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
			//System.out.println(table.next()); //table안에 데이터가 있으면 true
			if(table.next()) { //table안에 검색결과인 row가 있는지 체크 
				int no2 = table.getInt("no");
				String title = table.getString("title");
				String content = table.getString("content");
				String writer = table.getString("writer");
				//JOptionPane.showMessageDialog(null, title + " " + "");
				System.out.println(no2);
				System.out.println(title);
				System.out.println(content);
				System.out.println(writer);
				bag.setNo(no2);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
			}else {
				System.out.println("검색결과가 없음.");
			}
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}
		return bag;
	} // one

	
	public void delete(int no) {
		try {
			String sql = "delete from bbs where no = ?";
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setInt(1, no); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");

			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}

	} // delete

	public void insert(BbsVO bag) {
		// Java-DB연결 (JDBC) 4단계
		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		try {
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "insert into bbs values (null, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setString(1, bag.getTitle()); // 물음표 번호 1번에 title에 저장한 변수값을 넣어줘!
			ps.setString(2, bag.getContent()); // 물음표 번호 2번에 content에 저장한 변수값을 넣어줘!
			ps.setString(3, bag.getWriter()); // 물음표 번호 3번에 writer에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");

			// URL site = new URL(site);

			// 4. 3번에서 생성된 sql문을 Mysql로 전송
			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}

	} // insert

	public void update(String title, String content, int no) {
		// Java-DB연결 (JDBC) 4단계
		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		try {
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "update bbs set title = ?, content = ? where no = ?";
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setString(1, title); 
			ps.setString(2, content); 
			ps.setInt(3, no); //where no = 3 
			System.out.println("3. sql문 생성 성공!!");

			// URL site = new URL(site);

			// 4. 3번에서 생성된 sql문을 Mysql로 전송
			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}

	} // update

} // class
