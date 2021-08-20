package model2.myPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model2.vo.Address;
import model2.vo.Member;
import model2.vo.Payment;
import model2.vo.Portfoilo;
import model2.vo.PortfoiloDetail;

public class MPDao {
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
	

	
	public ArrayList<Member> getMember(Member sch){
				ArrayList<Member> mList = new ArrayList<Member>();
	
					try {
						setCon();
						
							String sql = "SELECT * FROM member\r\n"
									+ "WHERE memNum LIKE '%'||?||'%'";
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, sch.getMemNum());
	
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

	



	// 카드 가져오기
	
	public ArrayList<Payment> getPayment(Payment get){
				ArrayList<Payment> payList = new ArrayList<Payment>();
	
					try {
						setCon();
						
							String sql = "SELECT p.memNum, p.PAYNUM, p.bankName, p.cardNum\r\n"
									+ "FROM MEMBER m, payment p\r\n"
									+ "WHERE m.memNum = p.memNum \r\n"
									+ "AND m.memNum = ?" ; 
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, get.getMemNum());
	
	
						rs= pstmt.executeQuery();
						
						/*
						 CREATE TABLE payment(
						payNum varchar2(8) PRIMARY key, -- pay-0001
						memNum varchar2(8),
						bankName varchar2(20),
						cardNum varchar2(19) --  -포함 19자
							); 
						  
						 */
						while(rs.next()) {
							payList.add(new Payment(
									rs.getString("memNum"),
									rs.getString("payNum"),
									rs.getString("bankName"),
									rs.getString("cardNum")
									));
						}
						
						System.out.println("ArrayList 데이터 : "+payList.size());
	
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
	
				return payList;
			}



	// 배송지 가져오기
	
	public ArrayList<Address> getAddress(Address get){
				ArrayList<Address> addList = new ArrayList<Address>();
	
					try {
						setCon();
						
							String sql = "SELECT a.memNum, a.addressNum, a.defaultAddress, a.detailAddress\r\n"
									+ "FROM MEMBER m, address a \r\n"
									+ "WHERE m.memNum = a.memNum\r\n"
									+ "AND m.memNum = ?" ; 
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, get.getMemNum());
	
	
						rs= pstmt.executeQuery();
						
						
						while(rs.next()) {
							addList.add(new Address(
									rs.getString("memNum"),
									rs.getString("addressNum"),
									rs.getString("defaultAddress"),
									rs.getString("detailAddress")
									));
						}
						
						System.out.println("ArrayList 데이터 : "+addList.size());
	
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
	
				return addList;
			}



	// 포토폴리오 가져오기
	
	public ArrayList<Portfoilo> getPortfoilo(Portfoilo get){
				ArrayList<Portfoilo> portList = new ArrayList<Portfoilo>();
	
					try {
						setCon();
						
							String sql = "SELECT pfNum, memNum, PFTITLE, nvl(PFCONTENT, ' ') PFCONTENT, nvl(PFFILE , ' ') PFFILE, nvl(PFLINK , ' ') PFLINK, pfStateNum FROM portfolio \r\n"		
									+ "WHERE memNum = ?" ; 
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, get.getMemNum());
	
	
						rs= pstmt.executeQuery();
						
						
						while(rs.next()) {
							portList.add(new Portfoilo(
									rs.getString("pfNum"),
									rs.getString("memNum"),
									rs.getString("pfTitle"),
									rs.getString("pfContent"),
									rs.getString("pfFile"),
									rs.getString("pfLink"),
									rs.getInt("pfStateNum")
									));
						}
						
						System.out.println("ArrayList 데이터 : "+portList.size());
	
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
	
				return portList;
			}



	/* PreparedStatement 객체 활용 - insert */
	/*
	5. DML(insert, update, delete) 처리
	 	1) 기능 메서드 선언
	 		public void insertEemp (Emp ins)
	 	2) 연결 공통 메서드 호출
	 	3) con.setAutocommit(false);
	 		자동 autocommit발생 방지
	 	4) sql 메서드 선언
	 		insert into emp02 values(emp_seq.nextVal, ?, ?, sysdate, ?,?,?);
	 		// ?로 sql선언
	 	5) prepareStatement 처리
	 		pstmt.setXXXX(1, 데이터);
	 		pstmt.setXXXX(2, 데이터);
	 		pstmt.setXXXX(3, 데이터);...
	 		
	 	6) executeUpdate()
	 	7) con.commit();
	 	8) 자원해제
	 	9) 예외처리 - rollback(); 추가 
	
	
	 */
	
	
	
	
	// 
	public void insertPortfoilo(Portfoilo ins){
			try {
				setCon();
				con.setAutoCommit(false);
				
				String sql = "INSERT INTO portfolio VALUES ('pfn-'||pfn_seq_8.nextval, ?, ?, ?, ?, ?, 0)"; 
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ins.getMemNum());
				pstmt.setString(2, ins.getPfTitle());
				pstmt.setString(3, ins.getPfContent());
				pstmt.setString(4, ins.getPfFile());
				pstmt.setString(5, ins.getPfLink());
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



	// 포토폴리오 가져오기
	
	public ArrayList<PortfoiloDetail> getPortDetail(PortfoiloDetail get){
				ArrayList<PortfoiloDetail> portList = new ArrayList<PortfoiloDetail>();
	
					try {
						setCon();
						
							String sql = "SELECT pfNum, PFTITLE, nvl(PFCONTENT, ' ') PFCONTENT, nvl(PFFILE , ' ') PFFILE, nvl(PFLINK , ' ') PFLINK, pfStateNum FROM portfolio \r\n"		
									+ "WHERE pfNum = ?" ; 
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, get.getPfNum());
	
	
						rs= pstmt.executeQuery();
					
						
						while(rs.next()) {
							portList.add(new PortfoiloDetail(
									rs.getString("pfNum"),
									rs.getString("pfTitle"),
									rs.getString("pfContent"),
									rs.getString("pfFile"),
									rs.getString("pfLink"),
									rs.getInt("pfStateNum")
									));
						}
						
						System.out.println("ArrayList 데이터 : "+portList.size());
	
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
	
				return portList;
			}



	
	public void updatePortDetail(PortfoiloDetail upt){
			try {
				setCon();
				con.setAutoCommit(false);
				
				String sql = "UPDATE portfolio\r\n"
						+ "	SET PFTITLE = ?,\r\n"
						+ "		PFCONTENT = ?,\r\n"
						+ "		PFFILE = ?,\r\n"
						+ "		PFLINK = ?\r\n"
						+ "	WHERE PFNUM = ?"; 
				System.out.println(sql);
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, upt.getPfTitle());
				pstmt.setString(2, upt.getPfContent());
				pstmt.setString(3, upt.getPfFile());
				pstmt.setString(4, upt.getPfLink());
				pstmt.setString(5, upt.getPfNum());;
				pstmt.executeUpdate();
				
				con.commit();
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



	// 포토폴리오 삭제
	
	public void deletePortDetail(String pfNum){
			try {
				setCon();
				con.setAutoCommit(false);
				
				String sql = "DELETE FROM portfolio WHERE PFNUM = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, pfNum);
				pstmt.executeUpdate();
				
				con.commit();
				
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("sql예외"+e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
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
		MPDao dao = new MPDao();
		
		try {
			dao.setCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao.getMember(new Member("mem-0001"));
		dao.getAddress(new Address("mem-0001"));
		dao.getPayment(new Payment("mem-0001"));
		dao.getPortfoilo(new Portfoilo("mem-0001"));
		
		// dao.insertPortfoilo(new Portfoilo("mem-0001", "임시", "임시", "", ""));
	
		dao.getPortDetail(new PortfoiloDetail("pfn-0001"));
		dao.updatePortDetail(new PortfoiloDetail("수정2","수정", "수정", "수정", "pfn-1002"));
	}
}
