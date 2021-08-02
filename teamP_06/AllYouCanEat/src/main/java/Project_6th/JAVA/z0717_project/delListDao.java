package Project_6th.JAVA.z0717_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class delListDao {
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
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info, "scott", "tiger");
		
		//나중에 지우기
		System.out.println("접속성공!!");
	}
	
	
	
	// 맛집리스트
	public ArrayList<restaurant> delListView() {
		ArrayList<restaurant> restList = new ArrayList<restaurant>();
		try {
			setCon();

			String sql = " SELECT * FROM restaurant";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			rs.next();
			var cnt = 1;
			while(rs.next()){	
					System.out.print((cnt++)+ "위 ");
					System.out.println(rs.getString(3)+"\t");
					// 데이터의 추가
					restList.add(new restaurant(
							rs.getString("restNum"),
							rs.getString("restCorporNum"),
							rs.getString("restTitle"),
							rs.getString("restImage"),
							rs.getString("restAddress"),
							rs.getString("restPhoneNum"),
							rs.getString("restPark"),
							rs.getString("restHours"),
							rs.getString("restText"),
							rs.getString("restTag"),
							rs.getString("restSite"),
							rs.getString("genreLcate"),
							rs.getString("genreScate")
					));
			}
			
			
			rs.close();
			stmt.close();
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
			if(stmt!=null) {
				try {
					stmt.close();
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
		
		return restList;
	}
	
	
	// 식당정보 뷰
	public ArrayList<restaurant> restView(restaurant rest) {
		ArrayList<restaurant> restList = new ArrayList<restaurant>();
		try {
			setCon();

			String sql = " SELECT * FROM restaurant \r\n"
					+ "WHERE restTitle = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rest.getRestTitle());
			rs= pstmt.executeQuery();
			
			
			while(rs.next()){	
					System.out.println("맛집이름 : "+rs.getString(3)+"\t");
					System.out.println("맛집대표사진 : "+rs.getString(4)+"\t");
					System.out.println("주소 : "+rs.getString(5)+"\t");
					System.out.println("맛집번호 : "+rs.getString(6)+"\t");
					System.out.println("주차여부 : "+rs.getString(7)+"\t");
					System.out.println("맛집영업시간 : "+rs.getString(8)+"\t");
					System.out.println("태그 : "+rs.getString(10)+"\t");
					// 데이터의 추가
					restList.add(new restaurant(
							rs.getString("restNum"),
							rs.getString("restCorporNum"),
							rs.getString("restTitle"),
							rs.getString("restImage"),
							rs.getString("restAddress"),
							rs.getString("restPhoneNum"),
							rs.getString("restPark"),
							rs.getString("restHours"),
							rs.getString("restText"),
							rs.getString("restTag"),
							rs.getString("restSite"),
							rs.getString("genreLcate"),
							rs.getString("genreScate")
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
		
		return restList;
	}
	
	
	
	
	// 리뷰 뷰
		public ArrayList<review> reviewView(review re) {
			ArrayList<review> reviewList = new ArrayList<review>();
			try {
				setCon();

				String sql = " SELECT * FROM review \r\n"
						+ "WHERE restNum = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, re.getRestNum());
				rs= pstmt.executeQuery();
				
				while(rs.next()){	
						System.out.println("유저이름 : "+rs.getString(3)+"\t");
						System.out.println("리뷰별점 : "+rs.getInt(4)+"\t");
						System.out.println("리뷰일자 : "+rs.getDate(5)+"\t");
						System.out.println("리뷰내용 : "+rs.getString(6)+"\t");
						System.out.println("리뷰사진 : "+rs.getString(7)+"\t");
						
						// 데이터의 추가
						reviewList.add(new review(
								rs.getString("reviewNum"),
								rs.getString("restNum"),
								rs.getString("userNum"),
								rs.getInt("reviewPoint"),
								rs.getDate("reviewPostDate"),
								rs.getString("reviewContent"),
								rs.getString("reviewImage")
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
			
			return reviewList;
		}
		

		
		public void insertReview(review re){
				try {
					setCon();
					con.setAutoCommit(false);
					// 동일한 테이블이 있는지 주의하자
					
					

					// INSERT INTO review values('rev-0004', 'ret-0004', 'mem-0003', 5,
					// sysdate, '분위기도 조용하고 어둡고 좋습니다. 안주도 맛있어요~', '');

					String sql = " INSERT INTO review \r\n"
							+ "values('rev-0006', 'ret-0004', 'mem-0002', ?, sysdate, ?, ?)"; 
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, re.getReviewPoint());
					pstmt.setString(2, re.getReviewContent());
					pstmt.setString(3, re.getReviewImage());
					
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

		
		// delete 삭제 - 키 기준 삭제
		
		public void deleteReview(String reviewNum){
				try {
					setCon();
					con.setAutoCommit(false);
					
					String sql = " DELETE review \r\n"
							+ "	WHERE reviewNum = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, reviewNum);
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



	// 맛집리스트 순위 조회
		public ArrayList<delList> delList() {
			ArrayList<delList> delList = new ArrayList<delList>();
			try {
				setCon();
		
				String sql = " SELECT * FROM dellist_view";
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				rs.next();
				rs.next();
				var cnt = 1;
				while(rs.next()){	
						System.out.print((cnt++)+ "위 ");
						System.out.println(rs.getString(1)+"\t");
					
						// 데이터의 추가
						delList.add(new delList(
								rs.getString("restTitle"),
								rs.getString("restImage"),
								rs.getString("restAddress"),
								rs.getInt("reviewpoint"),
								rs.getString("reviewcontent")
								));
				}
				
				
				rs.close();
				stmt.close();
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
				if(stmt!=null) {
					try {
						stmt.close();
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
			
			return delList;
		}



	public static void main(String[] args) {
		delListDao delDao = new delListDao();
	
	
	}
	
}
