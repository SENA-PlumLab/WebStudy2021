package Project_6th.JAVA.z0717_project;

public class delListController {
	
	delListService delSer = new delListService();
	
	public String delListView(){
		delSer.delListView();
		return "jsp경로.jsp";
	}
	
	
	public String restView(){
		delSer.restView();
		
		return "jsp경로.jsp";
	}
	
	public String reviewView(){
		delSer.reviewView();
		
		return "jsp경로.jsp";
	}
	
	public String insertReview(review re) {
		delSer.insertReview(re);
		
		return "jsp경로.jsp";
	}
	
	public String deleteReview(String del) {
		delSer.deleteReview(del);
		return "jsp경로.jsp";
	}
}


