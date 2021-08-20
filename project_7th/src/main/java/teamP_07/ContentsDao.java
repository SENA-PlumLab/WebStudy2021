package teamP_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContentsDao {
	
	public Contents getBBS(String cttNum) {
		Contents ctt = new Contents();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT bbsNum AS cttnum, memnum, bbstitle, bbsContent AS CONTENT, bbsDate AS income, VIEWCNT, STATUS "
				+ "FROM bbs b, STATUS s "
				+ "WHERE bbsnum='"+cttNum+"' AND b.STATUSNUM = s.STATUSNUM";
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName(driver);
			// 2. Connection 객체 생성
			con = DriverManager.getConnection(url, user, pwd);

			// DB 연결
			// 3. Statement 객체 생성
			stmt = con.createStatement();
			// 4. SQL 문장을 실행하고 결과를 리턴
			// stmt.excuteQuery(SQL) : select
			// stmt.excuteUpdate(SQL) : insert, update, delete ..
			rs = stmt.executeQuery(SQL);
			// 5. ResultSet에 저장된 데이터 얻기 - 결과가 2개 이상
			while (rs.next()) {
				ctt.setCttNum(rs.getString("cttnum"));
				ctt.setMemNum(rs.getString("memnum"));
				ctt.setContents(rs.getString("content"));
				ctt.setIncome(rs.getString("income"));
				ctt.setStatus(rs.getString("status"));
				
				ctt.setBbsTitle(rs.getString("bbstitle"));
				ctt.setViewCnt(rs.getInt("viewcnt"));
				
			}
		} catch (SQLException e) {
			System.out.println("SQL Error : " + e.getMessage());
		} catch (ClassNotFoundException e1) {
			System.out.println("[JDBC Connector Driver 오류 : " + e1.getMessage() + "]");
		} finally { // 사용순서와 반대로 close 함
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return ctt;
	}
	
	public Contents getComment(String cttNum) {
		Contents ctt = new Contents();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT cmtnum AS cttnum, memnum, cmtcontent AS CONTENT , cmtdate AS income, bbsnum, STATUS "
				+ "FROM comments c, STATUS s "
				+ "WHERE cmtnum='"+cttNum+"' AND c.STATUSNUM = s.STATUSNUM";
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName(driver);
			// 2. Connection 객체 생성
			con = DriverManager.getConnection(url, user, pwd);

			// DB 연결
			// 3. Statement 객체 생성
			stmt = con.createStatement();
			// 4. SQL 문장을 실행하고 결과를 리턴
			// stmt.excuteQuery(SQL) : select
			// stmt.excuteUpdate(SQL) : insert, update, delete ..
			rs = stmt.executeQuery(SQL);
			// 5. ResultSet에 저장된 데이터 얻기 - 결과가 2개 이상
			while (rs.next()) {
				ctt.setCttNum(rs.getString("cttnum"));
				ctt.setMemNum(rs.getString("memnum"));
				ctt.setContents(rs.getString("content"));
				ctt.setIncome(rs.getString("income"));
				ctt.setStatus(rs.getString("status"));
				
				ctt.setBbsNum(rs.getString("bbsnum"));
				
			}
		} catch (SQLException e) {
			System.out.println("SQL Error : " + e.getMessage());
		} catch (ClassNotFoundException e1) {
			System.out.println("[JDBC Connector Driver 오류 : " + e1.getMessage() + "]");
		} finally { // 사용순서와 반대로 close 함
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return ctt;
	}
	
	public Contents getFunding(String cttNum) {
		Contents ctt = new Contents();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT fdnum AS cttnum, c.memnum, f.crenum, FDPROJECTNM AS fdtitle, fdImg, FDREGIDT AS income, "
				+ "FDSTORYIMG, FDSTORYSUM, FDSTORY AS content, STATUS "
				+ "FROM FUNDING f , CREATOR c, STATUS s "
				+ "WHERE f.CRENUM =c.CRENUM AND f.STATUSNUM = s.STATUSNUM AND fdnum='"+cttNum+"'";
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName(driver);
			// 2. Connection 객체 생성
			con = DriverManager.getConnection(url, user, pwd);

			// DB 연결
			// 3. Statement 객체 생성
			stmt = con.createStatement();
			// 4. SQL 문장을 실행하고 결과를 리턴
			// stmt.excuteQuery(SQL) : select
			// stmt.excuteUpdate(SQL) : insert, update, delete ..
			rs = stmt.executeQuery(SQL);
			// 5. ResultSet에 저장된 데이터 얻기 - 결과가 2개 이상
			
			while (rs.next()) {
				ctt.setCttNum(rs.getString("cttnum"));
				ctt.setMemNum(rs.getString("memnum"));
				ctt.setContents(rs.getString("content").replace("\r\n", "<br>"));
				ctt.setIncome(rs.getString("income"));
				ctt.setStatus(rs.getString("status"));
				
				ctt.setCreNum(rs.getString("crenum"));
				ctt.setFdtitle(rs.getString("fdTitle"));
				ctt.setFdImg(rs.getString("fdImg"));
				ctt.setStoryImg(rs.getString("fdStoryImg"));
				ctt.setStorySum(rs.getString("fdStorySum").replace("\r\n", "<br>"));
	
			}
		} catch (SQLException e) {
			System.out.println("SQL Error : " + e.getMessage());
		} catch (ClassNotFoundException e1) {
			System.out.println("[JDBC Connector Driver 오류 : " + e1.getMessage() + "]");
		} finally { // 사용순서와 반대로 close 함
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return ctt;
	}


	public String updateBBS_blind(ArrayList<String> cttNumList, int status) {

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체

		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		String SQL = "UPDATE bbs SET STATUSNUM="+status+" WHERE bbsnum in (?";
				for(int i=1; i<cttNumList.size(); i++) {
						SQL+=", ? ";
				}
				SQL+=")";
		try {

			// 1. JDBC 드라이버 로딩
			Class.forName(driver);

			// 2. Connection 생성
			con = DriverManager.getConnection(url, user, pwd);

			// 3. PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
			pstmt = con.prepareStatement(SQL);
			// 4. pstmt.set<데이터타입>(? 순서, 값) ex).setString(), .setInt ...
			for(int j=0; j<cttNumList.size(); j++) {
				pstmt.setString(j+1, cttNumList.get(j));
			}

			// 5. SQL 문장을 실행하고 결과를 리턴 - SQL 문장 실행 후, 변경된 row 수 int type 리턴
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 사용순서와 반대로 close 함
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "게시판 블라인드 성공";

	}
	public String updateComment_blind(ArrayList<String> cttNumList, int status) {

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체

		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		String SQL = "UPDATE comments SET STATUSNUM="+status+" WHERE cmtnum in (?";
				for(int i=1; i<cttNumList.size(); i++) {
						SQL+=", ? ";
				}
				SQL+=")";
		try {

			// 1. JDBC 드라이버 로딩
			Class.forName(driver);

			// 2. Connection 생성
			con = DriverManager.getConnection(url, user, pwd);

			// 3. PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
			pstmt = con.prepareStatement(SQL);
			// 4. pstmt.set<데이터타입>(? 순서, 값) ex).setString(), .setInt ...
			for(int j=0; j<cttNumList.size(); j++) {
				pstmt.setString(j+1, cttNumList.get(j));
			}

			// 5. SQL 문장을 실행하고 결과를 리턴 - SQL 문장 실행 후, 변경된 row 수 int type 리턴
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 사용순서와 반대로 close 함
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "댓글 블라인드 성공";

	}
	public String updateFunding_blind(ArrayList<String> cttNumList, int status) {

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체

		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		String SQL = "UPDATE funding SET STATUSNUM="+status+" WHERE fdnum in (?";
				for(int i=1; i<cttNumList.size(); i++) {
						SQL+=", ? ";
				}
				SQL+=")";
		try {

			// 1. JDBC 드라이버 로딩
			Class.forName(driver);

			// 2. Connection 생성
			con = DriverManager.getConnection(url, user, pwd);

			// 3. PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
			pstmt = con.prepareStatement(SQL);
			// 4. pstmt.set<데이터타입>(? 순서, 값) ex).setString(), .setInt ...
			for(int j=0; j<cttNumList.size(); j++) {
				pstmt.setString(j+1, cttNumList.get(j));
			}

			// 5. SQL 문장을 실행하고 결과를 리턴 - SQL 문장 실행 후, 변경된 row 수 int type 리턴
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 사용순서와 반대로 close 함
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "펀딩 블라인드 성공";

	}
	
	public String blindContents(String[] cttNum, int status) {
		
		ArrayList<String> bbsNum = new ArrayList<String>();
		ArrayList<String> cmtNum = new ArrayList<String>();
		ArrayList<String> fdNum = new ArrayList<String>();
		
		
		for(int i=0; i<cttNum.length; i++) {
			if(cttNum[i].substring(0, 3).equals("bbs")) {
				bbsNum.add(cttNum[i]);
			}
			else if(cttNum[i].substring(0, 3).equals("cmt")) {
				cmtNum.add(cttNum[i]);
			}
			else if(cttNum[i].substring(0, 3).equals("fud")) {
				fdNum.add(cttNum[i]);
			}
		}
		
		if(bbsNum.size()>0) {
			updateBBS_blind(bbsNum, status);
		}
		if(cmtNum.size()>0) {
			updateComment_blind(cmtNum, status);
		}
		if(fdNum.size()>0) {
			updateFunding_blind(fdNum, status);
		}
		
		return "컨텐츠 블라인드!";
	}
	
}
