package teamP_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PortfolioDao {
	
	public ArrayList<Portfolio> getPortfolioList() {
		ArrayList<Portfolio> pfList = new ArrayList<Portfolio>();
		
		
		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT * "
				+ "FROM portfolio order by pfstatenum desc";
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
				pfList.add(new Portfolio());
				pfList.get(i).setPfNum(rs.getString("pfnum"));
				pfList.get(i).setMemNum(rs.getString("memnum"));
				pfList.get(i).setTitle(rs.getString("pftitle"));
				pfList.get(i).setContents(rs.getString("pfcontent"));
				pfList.get(i).setPffile(rs.getString("pffile"));
				pfList.get(i).setPflink(rs.getString("pflink"));
				pfList.get(i).setStatus(rs.getInt("pfstatenum"));
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

		return pfList;
	}
	
	
	public Portfolio getPortfolio(String pfNum) {
		Portfolio pf = new Portfolio();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT * "
				+ "FROM portfolio WHERE pfnum='"+pfNum+"'";
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
				pf.setPfNum(rs.getString("pfnum"));
				pf.setMemNum(rs.getString("memnum"));
				pf.setTitle(rs.getString("pftitle"));
				pf.setContents(rs.getString("pfcontent"));
				pf.setPffile(rs.getString("pffile"));
				pf.setPflink(rs.getString("pflink"));
				pf.setStatus(rs.getInt("pfstatenum"));
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

		return pf;
	}
	

	public String updatePortfolio(String[] pfNumList, int status) {

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체

		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		String SQL = "UPDATE portfolio SET pfSTATeNUM="+status+" WHERE pfnum in (?";
				for(int i=1; i<pfNumList.length; i++) {
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
			for(int j=0; j<pfNumList.length; j++) {
				pstmt.setString(j+1, pfNumList[j]);
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
		return "포트폴리오 상태 업데이트 성공";

	}
	
}
