package teamP_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LogDao {
	

	public ArrayList<Log> getLogDTO_member() {
		ArrayList<Log> logDTOList = new ArrayList<Log>();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT * FROM member_log ORDER BY INCOME_DATE desc";
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
				logDTOList.add(new Log(rs.getString("memlog_pk"),
								rs.getString("memo"), rs.getString("income_date")));
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

		return logDTOList;
	}
	
	
	public ArrayList<Log> getLogDTO_ctt() {
		ArrayList<Log> logDTOList = new ArrayList<Log>();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT * FROM ctt_log ORDER BY INCOME_DATE desc";
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
				logDTOList.add(new Log(rs.getString("cttlog_pk"), rs.getString("kind"),
								rs.getString("memo"), rs.getString("income_date")));
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

		return logDTOList;
	}
	
	
}
