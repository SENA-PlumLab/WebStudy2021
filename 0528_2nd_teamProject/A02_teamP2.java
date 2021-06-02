package javaexp.teamP_2_0524;

public class A02_teamP2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchController schCon = new SearchController();
		
		Keyword k = new Keyword();
		Model m = new Model();
		
		System.out.println("========상단 검색창1=========");
		schCon.lately(k,m);
		System.out.println("---------------------------------");
		schCon.ranked(k,m);
		System.out.println("===========================");
		System.out.println();
		
		System.out.println("========상단 검색창2=========");
		schCon.autoSuggestProduct(k, m);
		System.out.println("---------------------------------");
		schCon.autoSuggestEvent(k, m);
		System.out.println("===========================");
		System.out.println();
		
		
		System.out.println("==========상세 검색=============");
		schCon.related(k,m);
		System.out.println("---------------------------------");
		schCon.searchInDetail(k, m);
		System.out.println("===========================");
		System.out.println();
		
		
		System.out.println("========검색 결과=========");
		schCon.SearchResult(k = new Keyword("검색어입력"), m);
		System.out.println("===========================");
		System.out.println();
		
		System.out.println("========검색 결과=========");
		schCon.SearchResultEvent(k = new Keyword("검색어입력"), m);
		System.out.println("===========================");
		System.out.println();
		
		
		System.out.println("========검색 결과=========");
		schCon.SearchResultMovie(k = new Keyword("검색어입력"), m);
		System.out.println("---------------------------------");
		schCon.SearchResultRecipe(k = new Keyword("검색어입력"), m);
		System.out.println("===========================");
		System.out.println();
		
	}

}
