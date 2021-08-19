package teamP_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDao {
	
	public Member getmemberDTO_num(String memNum) {
		Member memberDTO = new Member();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT m.*, memgrade "
				+ "FROM MEMBER m, MEMGRADE m2 "
				+ "WHERE m.memgradenum = m2.memgradenum and memnum='"+memNum+"'";
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
				memberDTO.setMemNum(rs.getString("memnum"));
				memberDTO.setmID(rs.getString("memid"));
				memberDTO.setMemImg(rs.getString("memimg"));
				memberDTO.setmName(rs.getString("memnick"));
				memberDTO.setMemText(rs.getString("memtext"));
				memberDTO.setMemPhone(rs.getString("memphone"));
				memberDTO.setReport(rs.getInt("memreport"));
				memberDTO.setJoinDate(rs.getString("memjoindate"));
				memberDTO.setModDate(rs.getString("memmoddate"));
				memberDTO.setMemgrade(rs.getString("memgrade"));
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

		return memberDTO;
	}
	
	public ArrayList<Member> getmemberDTO() {
		ArrayList<Member> memberDTOList = new ArrayList<Member>();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT memnum, memid, memnick, memreport, memjoindate, memgrade "
				+ "FROM MEMBER m, MEMGRADE m2 "
				+ "WHERE m.memgradenum = m2.memgradenum "
				+ "order by memjoindate desc";
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
				memberDTOList.add(new Member(rs.getString("memNum"),rs.getString("memid"), rs.getString("memnick"),
											rs.getInt("memreport"), rs.getString("memgrade"), rs.getString("memjoindate") )
						);
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

		return memberDTOList;
	}
	
	public ArrayList<Member> getmemberDTO_gradeCheck() {
		ArrayList<Member> memberDTOList = new ArrayList<Member>();

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT m.memnum, memid, memgrade, pftitle, pfnum, pfstatenum "
				+ "FROM MEMBER m, MEMGRADE m2, PORTFOLIO p "
				+ "WHERE m.memnum=p.memnum AND m.memgradenum = m2.memgradenum "
				+ "AND m.memgradenum in (1,2) and pfstatenum=1 order by memjoindate desc";
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
				memberDTOList.add(
						new Member(rs.getString("memNum"), rs.getString("memid"), rs.getString("memgrade"),
						rs.getString("pfnum"), rs.getString("pftitle"), rs.getString("pfstatenum"))
						);
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

		return memberDTOList;
	}

	public int getmemberDTO_gradeCheck_cnt() {
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
		String SQL = "SELECT count(*) as count "
				+ "FROM MEMBER m, MEMGRADE m2, PORTFOLIO p "
				+ "WHERE m.memnum=p.memnum AND m.memgradenum = m2.memgradenum "
				+ "AND m.memgradenum=1 and pfstatenum=1 order by memjoindate desc";
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
				cnt=rs.getInt("count");
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

		return cnt;
	}

	public String updateMemberGrade(String[] memNumList, int grade) {

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체

		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		String SQL = "UPDATE MEMBER m SET (memgradenum, memmodDate) "
				+ "	=(SELECT "+grade+", sysdate FROM dual) "
				+ " WHERE memnum IN ( ?";
		for(int i=1; i<memNumList.length; i++) {
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
			
			for(int j=0; j<memNumList.length; j++) {
				pstmt.setString(j+1, memNumList[j]);
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
		return "회원 등업 성공";

	}
	
	public String updatePortfolioConfirm(String[] memNumList, int status) {

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체

		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		String user = "team8th", pwd = "tiger";

		String SQL = "UPDATE PORTFOLIO SET PFSTATENUM="+status
				+ " WHERE memnum IN ( ?";
		for(int i=1; i<memNumList.length; i++) {
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
			
			for(int j=0; j<memNumList.length; j++) {
				pstmt.setString(j+1, memNumList[j]);
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
		return "포트폴리오 컨펌 성공";

	}
}
