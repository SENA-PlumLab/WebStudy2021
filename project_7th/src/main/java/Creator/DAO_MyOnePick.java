package Creator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAO_MyOnePick {

	   private Connection con;
	   private Statement stmt;
	   private PreparedStatement pstmt;
	   private ResultSet rs;
	   public void setCon() throws SQLException {
	      // 1. 드라이버 메모리 로딩..
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      String info = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
	      con = DriverManager.getConnection(info,"team8th","tiger");
	      System.out.println("접속 성공!!");      
	   }
	   

	   public void inserttest(Funding ins){
		      try {
		         setCon();
		         con.setAutoCommit(false);
		         String sql = "INSERT INTO funding (fdNum, creNum, fdThemeNum, "
		         		+ "FDCATEGORYNUM, STATUSNUM) VALUES "
		         		+ "('fud-'||LPAD(SEQ_fud.nextval, 4, '0'), ?, ?, 100, 2)";
		         pstmt = con.prepareStatement(sql);
		         pstmt.setString(1, ins.getCreNum());
		         pstmt.setInt(2, ins.getFdThemeNum());
		         pstmt.executeUpdate();
		         con.commit();
		         pstmt.close(); con.close();
		         System.out.println("완료!");
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		         System.out.println("SQL 예외 발생~~"+e.getMessage());
		         try {
		            // 입력 중간 문제 발생, rollback처리..
		            con.rollback();
		         } catch (SQLException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		         }
		      } catch(Exception e) {
		         System.out.println("일반예외 발생:"+e.getMessage());
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
		         
		      }
		   }
	   
	    public void update_basic(Funding upt){
		      try {
		         setCon();
		         con.setAutoCommit(false);
		         String sql = "UPDATE funding\r\n"
		         		+ "	SET fdProjectNM = ?,\r\n"
		         		+ "		fdTargetPrice = ?,\r\n"
		         		+ "		fdingprice = 0,\r\n"
		         		+ "		fdImg = ?,\r\n"
		         		+ "		fdCategoryNum = ?,\r\n"
		         		+ "		fdRegiDT = sysdate,\r\n"
		         		+ "		fdExpDT = ?,\r\n"
		         		+ "		fdTags = ?\r\n"
		         		+ "	WHERE FDNUM = (SELECT max(fdnum)\r\n"
		         		+ "	FROM funding)";
		         pstmt = con.prepareStatement(sql);
		         System.out.println("수정완료");
		         pstmt.setString(1, upt. getFdProjectNM());
		         pstmt.setInt(2, upt.getFdTargetPrice());
		         pstmt.setString(3, upt.getFdImg());
		         pstmt.setInt(4, upt.getFdCategoryNum());
		         pstmt.setString(5, upt.getFdExpDT());
		         pstmt.setString(6, upt.getFdTags());

		         pstmt.executeUpdate();
		         con.commit();

		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		         System.out.println("SQL 예외 발생~~"+e.getMessage());
		         try {
		            // 입력 중간 문제 발생, rollback처리..
		            con.rollback();
		         } catch (SQLException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		         }
		      } catch(Exception e) {
		         System.out.println("일반예외 발생:"+e.getMessage());
		      }finally {
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
	    
	    
	    public void update_story(Funding upt){
		      try {
		         setCon();
		         con.setAutoCommit(false);
		         String sql = "UPDATE funding\r\n"
		         		+ "	SET fdStoryImg = ?,\r\n"
		         		+ "	    fdStorySum = ?,\r\n"
		         		+ "		fdStory = ?\r\n"
		         		+ "	WHERE FDNUM = (SELECT max(fdnum)\r\n"
		         		+ "		FROM funding)";
		         pstmt = con.prepareStatement(sql);
		         System.out.println("수정완료");
		         pstmt.setString(1, upt. getFdStoryImg());
		         pstmt.setString(2, upt.getFdStorySum());
		         pstmt.setString(3, upt.getFdStory ());

		         pstmt.executeUpdate();
		         con.commit();

		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		         System.out.println("SQL 예외 발생~~"+e.getMessage());
		         try {
		            // 입력 중간 문제 발생, rollback처리..
		            con.rollback();
		         } catch (SQLException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		         }
		      } catch(Exception e) {
		         System.out.println("일반예외 발생:"+e.getMessage());
		      }finally {
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
	    
	    public void update_policy(Funding upt){
		      try {
		         setCon();
		         con.setAutoCommit(false);
		         String sql = "UPDATE funding\r\n"
		         		+ "	SET fdRefund = ?,\r\n"
		         		+ "		fdPolicy = ?\r\n"
		         		+ "	WHERE FDNUM = (SELECT max(fdnum)\r\n"
		         		+ "		FROM funding)";
		         pstmt = con.prepareStatement(sql);
		         System.out.println("수정완료");
		         pstmt.setString(1, upt. getFdRefund());
		         pstmt.setString(2, upt.getFdPolicy());

		         pstmt.executeUpdate();
		         con.commit();

		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		         System.out.println("SQL 예외 발생~~"+e.getMessage());
		         try {
		            // 입력 중간 문제 발생, rollback처리..
		            con.rollback();
		         } catch (SQLException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		         }
		      } catch(Exception e) {
		         System.out.println("일반예외 발생:"+e.getMessage());
		      }finally {
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
	    
	    
	    public ArrayList<Funding> getFundingList(String creNum){
	        ArrayList<Funding> fdlist = new ArrayList<Funding>();
	        try {
	           setCon();
	           String sql = "SELECT fdNum 펀딩번호,\r\n"
	           		+ "	c.creNum 크리에이터번호,\r\n"
	           		+ "	c.CRENM 크리에이터명,\r\n"
	           		+ "	f2.FDTHEMENM 펀딩테마번호,\r\n"
	           		+ "	fdProjectNM 펀딩명,\r\n"
	           		+ "	trunc((fdingprice/fdTargetPrice)*100) 펀딩율,\r\n"
	           		+ "	TO_CHAR(fdingprice, '9,999,999')펀딩된금액,\r\n"
	           		+ "	fdImg 펀딩대표이미지,\r\n"
	           		+ "	f3.FDCATEGORYNM 카테고리명,\r\n"
	           		+ "	ABS(TRUNC(sysdate-fdExpDT)) 펀딩마감일\r\n"
	           		+ "	FROM CREATOR c , FUNDING f,\r\n"
	           		+ "	FDTHEME f2, FDCATEGORY f3 \r\n"
	           		+ "WHERE c.CRENUM = f.CRENUM\r\n"
	           		+ "AND f.FDTHEMENUM = f2.FDTHEMENUM \r\n"
	           		+ "AND f.FDCATEGORYNUM = f3.FDCATEGORYNUM\r\n"
	           		+ "AND c.CRENUM = "+creNum;
	           stmt = con.createStatement();
	           rs = stmt.executeQuery(sql);
	           while(rs.next()) {
	              fdlist.add(new Funding(
	                       rs.getString(1),
	                       rs.getString(2),
	                       rs.getString(3),
	                       rs.getString(4),
	                       rs.getString(5),
	                       rs.getInt(6),
	                       rs.getString(7),
	                       rs.getString(8),
	                       rs.getString(9),
	                       rs.getString(10)
	                    ));
	           }
	           System.out.println("ArrayList의 데이터 갯수:"+fdlist.size());
	           rs.close(); stmt.close(); con.close();
	           
	        } catch (SQLException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	           System.out.println("SQL 예외 발생~~"+e.getMessage());
	        } catch(Exception e) {
	           System.out.println("일반예외 발생:"+e.getMessage());
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
	           
	        }
	        return fdlist;
	     }
	    
	    
	    
	   
	   public ArrayList<Creator> CreatorList(String creNum){
		      ArrayList<Creator> list = new ArrayList<Creator>();

		      try {
		         setCon();

		         String sql = "SELECT CRENM,\r\n"
		         		+ "		CREPROFILE\r\n"
		         		+ "FROM CREATOR \r\n"
		         		+ "WHERE CRENUM = "+creNum;

		         stmt = con.createStatement();
		         rs = stmt.executeQuery(sql);
		         while(rs.next()) {
		        	 list.add(new Creator(
		                  rs.getString(1),
		                  rs.getString(2)));
		         }
		         rs.close(); stmt.close(); con.close();
		         
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		      return list;
		   }
	   
	   
	   public String Creator(String memNum){
		      String Creator=null;
		      try {
		         setCon();

		         String sql = "SELECT CRENUM \r\n"
		         		+ "FROM CREATOR c \r\n"
		         		+ "WHERE MEMNUM ="+memNum;

		         stmt = con.createStatement();
		         rs = stmt.executeQuery(sql);
		         while(rs.next()) {
		        	Creator = rs.getString(1);
		         }
		         rs.close(); stmt.close(); con.close();
		         
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		      return Creator;
		   }
	   
	   
	   
	   public int getNoofFunding(String creNum){
		   int NoofFunding = 0;
		      try {
		         setCon();
		         String sql = "SELECT count(*)\r\n"
		         		+ "FROM FUNDING f \r\n"
		         		+ "WHERE CRENUM ="+ creNum;
		         stmt = con.createStatement();
		         rs= stmt.executeQuery(sql);
		         if(rs.next()) {
		        	 NoofFunding = rs.getInt(1);
		         }
		         
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		         System.out.println("SQL 예외 발생~~"+e.getMessage());
		      } catch(Exception e) {
		         System.out.println("일반예외 발생:"+e.getMessage());
		      }finally {
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
		      return NoofFunding;
		   }
	   
	   

		public static void main(String[] args) {
			DAO_MyOnePick Dao = new DAO_MyOnePick ();			
		/*	Dao.inserttest(new Funding("crt-0002",1));
			Dao.update_basic(new Funding("좋은소재의옷",200000,"../image/bebe.png",100,"2021/12/31","#좋은옷 #즐거운 옷"));
			Dao.update_story(new Funding(",,/image/bebe.png","비밀이야","아주오래된이야기"));
			Dao.update_policy(new Funding("빨리환불하세용","AS안해줘여!")); */
			Dao.getFundingList("'crt-0001'");
			Dao.getFundingList("'crt-0001'").get(0).getFdTargetPrice();
			System.out.println(Dao.getNoofFunding("'crt-0001'"));
			System.out.println(Dao.Creator("'mem-0010'"));
		}   
}



