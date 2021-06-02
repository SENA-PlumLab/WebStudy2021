package javaexp.teamP_2_0524;

public class SearchController {
	private SearchDao schDao = new SearchDao();
	
	//최근검색어
	public String lately(Keyword k, Model d) {
		d.addAttribute("최근검색어", schDao.lately(k));	
		return "호출화면";
	}
	//인기검색어
	public String ranked(Keyword k, Model d) {
		d.addAttribute("인기검색어", schDao.ranked(k));	
		return "호출화면";
	}
	
	//추천 상품+자동완성(상품명)
	public String autoSuggestProduct(Keyword k, Model d) {
		d.addAttribute("자동완성(검색어)", schDao.autoSuggestProduct(k));		
		return "호출화면";
	}
	//자동완성(기획전)
	public String autoSuggestEvent(Keyword k, Model d) {
		d.addAttribute("자동완성(기획전)", schDao.autoSuggestEvent(k));
		return "호출화면";
	}
	
	//연관검색어
		public String related(Keyword k, Model d) {
			d.addAttribute("연관검색어", schDao.related(k));	
			return "호출화면";
		}
	//상세 검색
	public String searchInDetail(Keyword k, Model d) {
		d.addAttribute("상세검색", schDao.searchInDetail(k));
		return "호출화면";
	}
	
	//상품검색결과
	public String SearchResult(Keyword k, Model d) {
		System.out.println("상품 탭 ('"+k.getKeyword()+"' 검색결과)");
		d.addAttribute("검색결과(상품)", schDao.SearchResult(k));
		return "호출화면";
	}
	//기획전 검색결과
	public String SearchResultEvent(Keyword k, Model d) {
		System.out.println("기획전 탭 ('"+k.getKeyword()+"' 검색결과)");
		d.addAttribute("검색결과(기획전)", schDao.SearchResultEvent(k));
		return "호출화면";
	}
	//동영상 검색결과
	public String SearchResultMovie(Keyword k, Model d) {
		System.out.println("동영상 탭 ('"+k.getKeyword()+"' 검색결과)");
		d.addAttribute("검색결과(동영상)", schDao.SearchResultMovie(k));
		return "호출화면";
	}
	//레시피 검색결과
	public String SearchResultRecipe(Keyword k, Model d) {
		System.out.println("레시피 탭 ('"+k.getKeyword()+"' 검색결과)");
		d.addAttribute("검색결과(레시피)", schDao.SearchResultRecipe(k));
		return "호출화면";
	}
}
