package teamP_06;

import java.util.ArrayList;

public class BBSService {
	BBSDao bDao = new BBSDao();

	public ArrayList<BBS> getListByPage(int numOfElement, int page) {
		return bDao.getListByPage(numOfElement, page);
	}
	
	public int getCountOfBBS() {
		return bDao.getCountOfBBS();
	}
	
	public BBS getBBSbyBBSNum(String bbsNum)  {
		return bDao.getBBSbyBBSNum(bbsNum);
	}
	
	public void addHitToBBS(String bbsNum) {
		bDao.addHitToBBS(bbsNum);
	}
	
	public ArrayList<BBSRec> getBBSRecByBBSNum(String bbsNum) {
		
		return bDao.getBBSRecByBBSNum(bbsNum);
	}
	
	public String setBBSDTO(String memNum, String title, String subTitle, String contents) {
		String generated;
		if(subTitle!=null) {
			generated=bDao.setBBS(memNum, title, subTitle, contents);
		}
		else {
			generated=bDao.setBBS(memNum, title, contents);
		}

		return generated;
	}
	
	public ArrayList<String> setBBSRec(String bbsNum, ArrayList<String> restNum) {
		
		return bDao.setBBSRec(bbsNum, restNum);
	}
		
	public String setBBSAvailZero(String bbsNum) {
		return bDao.setBBSAvailZero(bbsNum);
	}
	
	public String updateBBS(String bbsNum, String contents) {
		
		return bDao.updateBBS(bbsNum, contents);
	}
	

}
