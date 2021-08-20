package model2.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model2.vo.Member;

public class joinDao {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	public void setCon() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String info = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
		con = DriverManager.getConnection(info, "team8th", "tiger");
		System.out.println("DB접속");
	}
	

	public void joinMember(Member join){
			try {
				setCon();
				con.setAutoCommit(false);
				String sql = " INSERT INTO member VALUES ('mem-'||mem_seq_8.nextval, ?, ?, null, null, null, ?, 0, sysdate, sysdate, 1)";
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, join.getMemId());
				pstmt.setString(2, join.getMemPw());
				pstmt.setString(3, join.getMemPhone());
				pstmt.executeUpdate();
				con.commit(); // 커밋
				
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("sql예외"+e.getMessage());
				try {
					//입력중간에 예외발생하면 rollback처리
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("일반예외 : "+e.getMessage());
			} finally {
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(stmt!=null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
	}



	public static void main(String[] args) {
		// DB 연결
		joinDao dao = new joinDao();
		
		try {
			dao.setCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
