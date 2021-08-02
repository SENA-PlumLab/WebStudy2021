package Project_6th.JAVA.z0717_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Project_6th.JAVA.z02_vo.ChefDeal;
import Project_6th.JAVA.z02_vo.ChefDealod;
import Project_6th.JAVA.z02_vo.Emp;


public class DAO_AllYouCanEat {

	   private Connection con;
	   private Statement stmt;
	   private PreparedStatement pstmt;
	   private ResultSet rs;
	   public void setCon() throws SQLException {
	      // 1. �뱶�씪�씠踰� 硫붾え由� 濡쒕뵫..
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      String info = "jdbc:oracle:thin:@106.10.104.82:1521:orcl";
	      con = DriverManager.getConnection(info,"test1","tiger");
	      System.out.println("�젒�냽 �꽦怨�!!");      
	   }
	   
	   public ArrayList<ChefDealod> getChefDealodList(){
		      ArrayList<ChefDealod> cdlist = new ArrayList<ChefDealod>();
		      try {
		         setCon();
		         String sql = "SELECT o.cdNum �뀺�봽�뵜援щℓ踰덊샇,\r\n"
		         		+ "	c.dName �뀺�봽�뵜紐�, \r\n"
		         		+ "	ltrim(c.dImage,'.') �뀺�봽�뵜�씠誘몄�, \r\n"
		         		+ "	r.restTitle 留쏆쭛紐�, \r\n"
		         		+ "	SUBSTR(RESTADDRESS,0,2) AS 留쏆쭛吏��뿭,\r\n"
		         		+ "	r.RESTTEXT 留쏆쭛�냼媛�,\r\n"
		         		+ "	o.numOf �씤�썝,\r\n"
		         		+ "	c.DPRICEAF 媛�寃�,\r\n"
		         		+ "	c.DPRICEAF*o.NUMOF \"珥� �떚耳볤�寃�\",\r\n"
		         		+ "	m.memPoint �궗�슜�룷�씤�듃,\r\n"
		         		+ "	(c.dPriceaf*o.numof)-m.memPoint \"珥� 寃곗젣媛�寃�\",\r\n"
		         		+ "	to_char(c.toDate, 'YYYY-MM-DD') �궗�슜湲고븳,\r\n"
		         		+ "	p.methodStatus 寃곗젣諛⑸쾿,\r\n"
		         		+ "	s.status 援щℓ�긽�깭\r\n"
		         		+ "FROM chefdealod o, chefdeal c, restaurant r, members m,\r\n"
		         		+ "	paymethod p, orderstatus s\r\n"
		         		+ "WHERE o.DNUM = c.DNUM \r\n"
		         		+ "AND o.memnum = m.memnum\r\n"
		         		+ "AND o.restNum = r.restNum\r\n"
		         		+ "AND o.payNum = p.methodNum\r\n"
		         		+ "AND o.odstatus = s.ordstanum";
		         stmt = con.createStatement();
		         rs = stmt.executeQuery(sql);
			         while(rs.next()) {
			            cdlist.add(new ChefDealod(
			                     rs.getString(1),
			                     rs.getString(2),
			                     rs.getString(3),
			                     rs.getString(4),
			                     rs.getString(5),
			                     rs.getString(6),
			                     rs.getInt(7),
			                     rs.getInt(8),
			                     rs.getInt(9),
			                     rs.getInt(10),
			                     rs.getInt(11),
			                     rs.getString(12),
			                     rs.getString(13),
			                     rs.getString(14)
			                  ));
		         }
		         rs.close(); stmt.close(); con.close();
		         
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		         System.out.println("SQL �삁�쇅 諛쒖깮~~"+e.getMessage());
		      } catch(Exception e) {
		         System.out.println("�씪諛섏삁�쇅 諛쒖깮:"+e.getMessage());
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
		      return cdlist;
		   }
	   
	   
	   
	   public ArrayList<ChefDeal> getChefDealList(ChefDeal sch){
		   		ArrayList<ChefDeal> clist = new ArrayList<ChefDeal>();
		      try {
		         setCon();
		         String sql = "SELECT c.dNum �뀺�봽�뵜踰덊샇, \r\n"
		         		+ "	c.dName �뀺�봽�뵜紐�, \r\n"
		         		+ "	ltrim(c.dImage,'.') �뀺�봽�뵜�씠誘몄�, \r\n"
		         		+ "	r.restTitle 留쏆쭛紐�, \r\n"
		         		+ "	SUBSTR(RESTADDRESS,0,2) AS 留쏆쭛吏��뿭,\r\n"
		         		+ "	c.dPricebf �븷�씤�쟾媛�寃�, \r\n"
		         		+ "	c.dPercent �븷�씤�쑉, \r\n"
		         		+ "	c.dPriceaf �븷�씤�썑媛�寃�, \r\n"
		         		+ "	c.sPoint �쟻由쏀룷�씤�듃, \r\n"
		         		+ "	to_char(c.toDate, 'YYYY-MM-DD') �궗�슜湲고븳,\r\n"
		         		+ "	r.restText 留쏆쭛�냼媛�, \r\n"
		         		+ "	c.mndetail 硫붾돱�냼媛�\r\n"
		         		+ "FROM chefdeal c, restaurant r\r\n"
		         		+ "WHERE c.restNum = r.restNum\r\n"
		         		+ "AND r.RESTADDRESS LIKE '%'||?||'%'";
		         
		         pstmt = con.prepareStatement(sql);
		         pstmt.setString(1, sch.getAddress());
		         
		         rs = pstmt.executeQuery();
		         while(rs.next()) {
					   clist.add(new ChefDeal(
				                     rs.getString(1),
				                     rs.getString(2),
				                     rs.getString(3),
				                     rs.getString(4),
				                     rs.getString(5),
				                     rs.getInt(6),
				                     rs.getInt(7),
				                     rs.getInt(8),
				                     rs.getInt(9),
				                     rs.getString(10),
				                     rs.getString(11),
				                     rs.getString(12)
					                  ));
		         }
		         System.out.println("ArrayList�쓽 �뜲�씠�꽣 媛��닔:"+clist.size());
		         rs.close(); pstmt.close(); con.close();
	
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		         System.out.println("SQL �삁�쇅 諛쒖깮~~"+e.getMessage());
		      } catch(Exception e) {
		         System.out.println("�씪諛섏삁�쇅 諛쒖깮:"+e.getMessage());
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
		      return clist;
		   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	
	   public ArrayList<ChefDeal> getChefDealList(){
		      ArrayList<ChefDeal> dlist = new ArrayList<ChefDeal>();
		      try {
		         setCon();
		         String sql = "SELECT c.dNum �뀺�봽�뵜踰덊샇, \r\n"
		         		+ "	c.dName �뀺�봽�뵜紐�, \r\n"
		         		+ "	ltrim(c.dImage,'.') �뀺�봽�뵜�씠誘몄�, \r\n"
		         		+ "	r.restTitle 留쏆쭛紐�,\r\n"
		         		+ "	SUBSTR(RESTADDRESS,0,2) AS 留쏆쭛吏��뿭,\r\n"
		         		+ "	c.dPricebf �븷�씤�쟾媛�寃�, \r\n"
		         		+ "	c.dPercent �븷�씤�쑉, \r\n"
		         		+ "	c.dPriceaf �븷�씤�썑媛�寃�, \r\n"
		         		+ "	c.sPoint �쟻由쏀룷�씤�듃, \r\n"
		         		+ "	to_char(c.toDate, 'YYYY-MM-DD') �궗�슜湲고븳,\r\n"
		         		+ "	r.restText 留쏆쭛�냼媛�, \r\n"
		         		+ "	c.mndetail 硫붾돱�냼媛�\r\n"
		         		+ "FROM chefdeal c, restaurant r\r\n"
		         		+ "WHERE c.restNum = r.restNum";
		         stmt = con.createStatement();
		         rs = stmt.executeQuery(sql);
			         while(rs.next()) {
			           dlist.add(new ChefDeal(
			                     rs.getString(1),
			                     rs.getString(2),
			                     rs.getString(3),
			                     rs.getString(4),
			                     rs.getString(5),
			                     rs.getInt(6),
			                     rs.getInt(7),
			                     rs.getInt(8),
			                     rs.getInt(9),
			                     rs.getString(10),
			                     rs.getString(11),
			                     rs.getString(12)
			                  ));
		         }
		         System.out.println("ArrayList�쓽 �뜲�씠�꽣 媛��닔:"+dlist.size());
		         rs.close(); stmt.close(); con.close();
		         
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		         System.out.println("SQL �삁�쇅 諛쒖깮~~"+e.getMessage());
		      } catch(Exception e) {
		         System.out.println("�씪諛섏삁�쇅 諛쒖깮:"+e.getMessage());
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
		      return dlist;
		   }

	   

		public static void main(String[] args) {
			DAO_AllYouCanEat Dao = new DAO_AllYouCanEat ();
			
			for (ChefDeal clist:Dao.getChefDealList(new ChefDeal("�젣二�"))) {
				System.out.println(clist.getdName());
			}
			
			
			for (ChefDealod dlist:Dao.getChefDealodList()) {
				System.out.println(dlist.getdName());
			}
			
		}

	   
}



