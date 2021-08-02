package foodreview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Mydeal_DAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	//援щℓ�븳 �뀺�봽�뵜 議고쉶
	public ArrayList<Mydeal> getMydealList(String memnum){
		ArrayList<Mydeal> mydealList = new ArrayList<Mydeal>();
		try {
			String sql = "SELECT m.memnum, r.restnum, c.dnum, d.cdnum, r.resttitle, c.dname, c.dimage, c.spoint, c.todate, c.dpricebf, c.dpercent, c.dpriceaf,\r\n"
					+ "p.methodstatus, o.status, floor(c.todate-sysdate) as duecount \r\n"
					+ "FROM members m, RESTAURANT r, chefdeal c, chefdealod d, PAYMETHOD p, ORDERSTATUS o \r\n"
					+ "WHERE m.memnum=d.memnum and c.dnum=d.dnum and r.restnum=c.restnum and d.payNUM =p.METHODNUM \r\n"
					+ "AND d.odstatus=o.ordstanum AND m.memnum= ? ";
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, memnum);
			rs = pst.executeQuery();
			while(rs.next()) {
				mydealList.add(new Mydeal(
						rs.getString("memNum"),
						rs.getString("restNum"),
						rs.getString("dNum"),
						rs.getString("cdnum"),
						rs.getString("resttitle"),
						rs.getString("dname"),
						rs.getString("dimage"),
						rs.getInt("spoint"),
						rs.getDate("todate"),
						rs.getInt("dpricebf"),
						rs.getInt("dpercent"),
						rs.getInt("dpriceaf"),
						rs.getString("methodstatus"),
						rs.getString("status"),
						rs.getInt("duecount")
						));
			}
		} catch (SQLException e) {
			System.out.println("sql�삁�쇅:"+e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("�씪諛섏삁�쇅:"+e.getMessage());
		}finally {
			if(rs!=null) {try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(pst!=null) {try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}
		return mydealList;
	}
	
	//�궗�슜媛��뒫 �뀺�봽�뵜 議고쉶
	public ArrayList<Mydeal> getAvailableDealList(String memnum){
		ArrayList<Mydeal> mydealList = new ArrayList<Mydeal>();
		try {
			String sql = "SELECT m.memnum, r.restnum, c.dnum, d.cdnum, r.resttitle, c.dname, c.dimage, c.spoint, c.todate, c.dpricebf, c.dpercent, c.dpriceaf,\r\n"
					+ "p.methodstatus, o.status, floor(c.todate-sysdate) as duecount \r\n"
					+ "FROM members m, RESTAURANT r, chefdeal c, chefdealod d, PAYMETHOD p, ORDERSTATUS o \r\n"
					+ "WHERE m.memnum=d.memnum and c.dnum=d.dnum and r.restnum=c.restnum and d.payNUM =p.METHODNUM \r\n"
					+ "AND d.odstatus=o.ordstanum AND m.memnum= ? and odstatus = 0 ";
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, memnum);
			rs = pst.executeQuery();
			while(rs.next()) {
				mydealList.add(new Mydeal(
						rs.getString("memNum"),
						rs.getString("restNum"),
						rs.getString("dNum"),
						rs.getString("cdnum"),
						rs.getString("resttitle"),
						rs.getString("dname"),
						rs.getString("dimage"),
						rs.getInt("spoint"),
						rs.getDate("todate"),
						rs.getInt("dpricebf"),
						rs.getInt("dpercent"),
						rs.getInt("dpriceaf"),
						rs.getString("methodstatus"),
						rs.getString("status"),
						rs.getInt("duecount")
						));
			}
		} catch (SQLException e) {
			System.out.println("sql�삁�쇅:"+e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("�씪諛섏삁�쇅:"+e.getMessage());
		}finally {
			if(rs!=null) {try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(pst!=null) {try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}
		return mydealList;
	}
	
	//�궡 �뀺�봽�뵜 �솚遺�(odstatus瑜� 3�쑝濡� 諛붽씀湲�)
	public void refund(String cdNum) {
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			String sql = "UPDATE chefdealod SET odstatus = 3 WHERE cdnum= ? ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, cdNum);
			pst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			System.out.println("sql�삁�쇅:"+e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("�씪諛섏삁�쇅:"+e.getMessage());
		}finally {
			if(rs!=null) {try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(pst!=null) {try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}
	}
	
	
}
