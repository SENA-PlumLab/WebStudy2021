package teamP_06;

import java.util.ArrayList;

public class BBSController {
	BBSService bService = new BBSService();

	//글 목록
	public ArrayList<BBS> getListByPage(int numOfElement, int page) {
		
		return bService.getListByPage(numOfElement, page);
	}
	public int getCountOfBBS() {
		return bService.getCountOfBBS();
	}
	//글 수정 페이지에서 내용 불러올 때 사용 됨.
	public BBS getBBS(String bbsNum) {
		return bService.getBBSbyBBSNum(bbsNum);
	}
	public ArrayList<BBSRec> getBBSRecByBBSNum(String bbsNum) {
		return bService.getBBSRecByBBSNum(bbsNum);
	}

	public BBS visitBBS(String bbsNum) {
		bService.addHitToBBS(bbsNum);
		return bService.getBBSbyBBSNum(bbsNum);
	}
	
	public ArrayList<String> writeBBS(String memNum, String title, String subTitle, String contents, ArrayList<String> restNum ) {
		String generated = bService.setBBSDTO(memNum, title, subTitle, contents);
		ArrayList<String> rcoNumList = bService.setBBSRec(generated, restNum);
		rcoNumList.add(0, generated);//bbsNum
		return rcoNumList;
	}
	
	public String deleteBBS(String bbsNum) {
		return bService.setBBSAvailZero(bbsNum);
	}
	
	public String editBBS(String bbsNum, String contents) {
		return bService.updateBBS(bbsNum, contents);
	}
}
