package teamP_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FundingDao {
	
	public Funding getFunding(String fdNum) {
		Funding fd = new Funding();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT c.CRENM, s.status, t.FDTHEMENM, ct.FDCATEGORYNM, f.* "
				+ "FROM FUNDING f "
				+ "INNER JOIN CREATOR c ON f.CRENUM =c.CRENUM "
				+ "INNER JOIN STATUS s ON f.STATUSNUM = s.STATUSNUM "
				+ "INNER JOIN FDTHEME t ON f.FDTHEMENUM = t.FDTHEMENUM "
				+ "INNER JOIN FDCATEGORY ct ON f.FDCATEGORYNUM = ct.FDCATEGORYNUM "
				+ "where fdnum='"+fdNum+"' ORDER BY f.FDREGIDT DESC";
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
				fd.setCreName(rs.getString("crenm"));
				fd.setCreNum(rs.getString("crenum"));
				fd.setStatus_name(rs.getString("status"));
				fd.setStatus(rs.getInt("statusnum"));
				fd.setTheme_name(rs.getString("fdthemenm"));
				fd.setTheme(rs.getInt("fdthemenum"));
				fd.setCategory_name(rs.getString("fdcategorynm"));
				fd.setCategory(rs.getInt("fdcategorynum"));
				fd.setPrice_target(rs.getInt("fdtargetprice"));
				fd.setPrice(rs.getInt("fdingprice"));
				
				fd.setFdNum(rs.getString("fdnum"));
				fd.setFdtitle(rs.getString("fdprojectnm"));
				fd.setFdImg(rs.getString("fdImg"));
				fd.setTags(rs.getString("fdtags"));
				fd.setStoryImg(rs.getString("fdstoryimg"));
				fd.setStorySum(rs.getString("fdstorysum"));
				fd.setStory(rs.getString("fdstory"));
				fd.setRefund(rs.getString("fdrefund"));
				fd.setPolicy(rs.getString("fdpolicy"));
				
				fd.setReg_date(rs.getString("fdregiDT"));
				fd.setExpire_date(rs.getString("fdexpDT"));
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

		return fd;
	}
	
	public ArrayList<Funding> getFundingList() {
		ArrayList<Funding> fList = new ArrayList<Funding>();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT c.CRENM, s.status, t.FDTHEMENM, ct.FDCATEGORYNM, f.* "
				+ "FROM FUNDING f "
				+ "INNER JOIN CREATOR c ON f.CRENUM =c.CRENUM "
				+ "INNER JOIN STATUS s ON f.STATUSNUM = s.STATUSNUM "
				+ "INNER JOIN FDTHEME t ON f.FDTHEMENUM = t.FDTHEMENUM "
				+ "INNER JOIN FDCATEGORY ct ON f.FDCATEGORYNUM = ct.FDCATEGORYNUM "
				+ "WHERE f.STATUSNUM !=2 ORDER BY f.FDREGIDT DESC";
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
			for(int i=0; rs.next(); i++) {
				fList.add(new Funding());
				fList.get(i).setStatus_name(rs.getString("status"));
				fList.get(i).setTheme_name(rs.getString("fdthemenm"));
				fList.get(i).setCategory_name(rs.getString("fdcategorynm"));
				
				fList.get(i).setCreNum(rs.getString("crenum"));
				fList.get(i).setPrice_target(rs.getInt("fdtargetprice"));
				fList.get(i).setPrice(rs.getInt("fdingprice"));
				fList.get(i).setFdNum(rs.getString("fdnum"));
				fList.get(i).setFdtitle(rs.getString("fdprojectnm"));
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

		return fList;
	}
	
	public ArrayList<Funding> getFundingList_check() {
		ArrayList<Funding> fList = new ArrayList<Funding>();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT s.status, t.FDTHEMENM, ct.FDCATEGORYNM, crenum, fdtargetprice, fdingprice, fdnum, fdprojectnm  "
				+ "FROM FUNDING f "
				+ "INNER JOIN STATUS s ON f.STATUSNUM = s.STATUSNUM "
				+ "INNER JOIN FDTHEME t ON f.FDTHEMENUM = t.FDTHEMENUM "
				+ "INNER JOIN FDCATEGORY ct ON f.FDCATEGORYNUM = ct.FDCATEGORYNUM "
				+ "WHERE f.STATUSNUM =2 ORDER BY f.FDREGIDT DESC";
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
			for(int i=0; rs.next(); i++) {
				fList.add(new Funding());
				fList.get(i).setStatus_name(rs.getString("status"));
				fList.get(i).setTheme_name(rs.getString("fdthemenm"));
				fList.get(i).setCategory_name(rs.getString("fdcategorynm"));
				
				fList.get(i).setCreNum(rs.getString("crenum"));
				fList.get(i).setPrice_target(rs.getInt("fdtargetprice"));
				fList.get(i).setPrice(rs.getInt("fdingprice"));
				fList.get(i).setFdNum(rs.getString("fdnum"));
				fList.get(i).setFdtitle(rs.getString("fdprojectnm"));
				/*
				fList.get(i).setFdImg(rs.getString("fdImg"));
				fList.get(i).setTags(rs.getString("fdtags"));
				fList.get(i).setStoryImg(rs.getString("fdstoryimg"));
				fList.get(i).setStorySum(rs.getString("fdstorysum"));
				fList.get(i).setStory(rs.getString("fdstory"));
				fList.get(i).setRefund(rs.getString("fdrefund"));
				fList.get(i).setPolicy(rs.getString("fdpolicy"));
				
				fList.get(i).setReg_date(rs.getString("fdregDT"));
				fList.get(i).setExpire_date(rs.getString("fdexpDT"));
				*/
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

		return fList;
	}
	
	public int getFundingList_check_cnt() {
		int cnt=0;

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT count(*) as count  "
				+ "FROM FUNDING f "
				+ "INNER JOIN STATUS s ON f.STATUSNUM = s.STATUSNUM "
				+ "INNER JOIN FDTHEME t ON f.FDTHEMENUM = t.FDTHEMENUM "
				+ "INNER JOIN FDCATEGORY ct ON f.FDCATEGORYNUM = ct.FDCATEGORYNUM "
				+ "WHERE f.STATUSNUM =2 ORDER BY f.FDREGIDT DESC";
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
			rs.next();
			cnt=rs.getInt("count");
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

		return cnt;
	}


	public String updateFunding(String[] fdNumList, int status) {

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체

		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		String SQL = "UPDATE funding SET STATUSNUM="+status+" WHERE fdnum in (?";
				for(int i=1; i<fdNumList.length; i++) {
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
			for(int j=0; j<fdNumList.length; j++) {
				pstmt.setString(j+1, fdNumList[j]);
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
		return "펀딩 업데이트 성공";

	}
	
	
}
