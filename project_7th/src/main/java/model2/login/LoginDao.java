package model2.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model2.vo.Member;

public class LoginDao {
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
	
	public boolean login(String id, String pass){
		boolean hasMember = false;
		
			try {
				setCon();
				
				String sql = " SELECT * FROM member\r\n"
						+ "WHERE memId = ? \r\n"
						+ "AND mempw = ?"; 
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pass);
				
				rs= pstmt.executeQuery();
	
				hasMember = rs.next(); // 데이터가 있으면 true..
				System.out.println("입력값 id:"+id);
				System.out.println("입력값 pass:"+pass);
				
				System.out.println("등록여부 : "+hasMember);
				
				rs.close();
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
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
		
		return hasMember;
	}

	public ArrayList<Member> getMember(String id, String pass){
		ArrayList<Member> mList = new ArrayList<Member>();
	
			try {
				setCon();
				
					String sql = "SELECT * FROM MEMBER\r\n"
							+ "WHERE MEMid = ?\r\n"
							+ "AND mempw = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pass);
	
				rs= pstmt.executeQuery();
			
				while(rs.next()) {
					mList.add(new Member(
							rs.getString("memNum"),
							rs.getString("memId"),
							rs.getString("memPw"),
							rs.getString("memImg"),
							rs.getString("memNick"),
							rs.getString("memText"),
							rs.getString("memPhone"),
							rs.getInt("memReport"),
							rs.getDate("memJoinDate"),
							rs.getDate("memModDate"),
							rs.getInt("memGradeNum")
							));
				}
				
				System.out.println("ArrayList 데이터 : "+mList.size());
	
				rs.close();
				pstmt.close();
				con.close();
	
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("sql 예외"+e.getMessage());
			} catch (Exception e) {
				System.out.println("일반 예외"+e.getMessage());
			}finally {
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
				System.out.println("DB끝");
			}
	
		return mList;
	}


	public ArrayList<Member> idSearch(String phone){
		ArrayList<Member> idSList = new ArrayList<Member>();
		
			try {
				setCon();
				
				String sql = "SELECT * FROM MEMBER\r\n"
						+ "WHERE memphone=?"; 
				
	
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, phone);
	
				rs= pstmt.executeQuery();
			
				while(rs.next()) {
					idSList.add(new Member(
							rs.getString("memNum"),
							rs.getString("memId"),
							rs.getString("memPw"),
							rs.getString("memImg"),
							rs.getString("memNick"),
							rs.getString("memText"),
							rs.getString("memPhone"),
							rs.getInt("memReport"),
							rs.getDate("memJoinDate"),
							rs.getDate("memModDate"),
							rs.getInt("memGradeNum")
							));
				}
				rs.close();
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
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
		
		return idSList;
	}

	public static void main(String[] args) {
		// DB 연결
		LoginDao dao = new LoginDao();
		
		try {
			dao.setCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao.login("naver@naver.com", "naver1999");
		dao.getMember("naver@naver.com", "naver1999");
		
		dao.idSearch("010-0000-0000");
		
	}
	
}
