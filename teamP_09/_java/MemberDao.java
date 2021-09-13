package teamP_09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDao {
	
	/*
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getCon(){
		try {
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp:env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			con = ds.getConnection();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
*/
	//회원 한명 정보 저장
	public void joinMember(Member m) {
		
		//getCon();  
		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체

		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team9th", pwd = "tiger";
		
		String sql = "insert into SYS_USER_TB(user_id, user_pw, user_nm, user_birth, user_tel, user_mail) "
				+ "values(?, ?, ?, ?, ?, ?)";
		
		try {
			// 1. JDBC 드라이버 로딩
						Class.forName(driver);

						// 2. Connection 생성
						con = DriverManager.getConnection(url, user, pwd);
						
						
			pstmt = con.prepareStatement(sql);
			
			// ?에 대입
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getBirth());
			pstmt.setString(5, m.getTel());
			pstmt.setString(6, m.getMail());
			
			//쿼리 실행
			pstmt.executeUpdate();
			con.close();
		}catch (ClassNotFoundException e) {
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
		
	}
	
	
	public Member getMember_byID(String id) {
		Member member = new Member();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team9th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT * FROM SYS_USER_TB "
				+ "WHERE USER_ID ='"+id+"'";
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
				member.setMemnum(rs.getString("USER_CD_PK"));
				member.setGb(rs.getInt("USER_GB"));
				member.setId(rs.getString("USER_ID"));
				member.setPw(rs.getString("USER_PW"));
				member.setName(rs.getString("USER_NM"));
				member.setBirth(rs.getString("USER_BIRTH"));
				member.setTel(rs.getString("USER_TEL"));
				member.setMail(rs.getString("USER_MAIL"));
				member.setJoinDate(rs.getString("USER_JOIN_DT"));
				member.setEditDate(rs.getString("USER_EDIT_DT"));
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

		return member;
	}
	
	
}
