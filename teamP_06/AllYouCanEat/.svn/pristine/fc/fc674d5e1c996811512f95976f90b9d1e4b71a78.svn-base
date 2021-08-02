package Project_6th.JAVA.z0717_project;

import java.util.ArrayList;

public class delListService {
	delListDao delDao = new delListDao();
	
	public void delListView() {
		delDao.delListView();
	}
	
	
	public void restView() {
		// 임의적으로 기와탭룸을 넣음
		delDao.restView(new restaurant("기와탭룸"));
		
	}
	
	public void reviewView() {
		// 기와탭룸 리뷰!
		delDao.reviewView(new review("ret-0004"));
	}
	
	
	// INSERT INTO review values('rev-0004', 'ret-0003', 'mem-0002',
	// 5, sysdate, '육즙이 살아있는 패티가 뭔지 이번에 알았어요!', '../image/burgerparkreivew.jpg');

	public void insertReview(review re) {
		delDao.insertReview(re);
	}
	
	public void deleteReview(String del) {
		delDao.deleteReview(del);
		
	}
	
	
}
