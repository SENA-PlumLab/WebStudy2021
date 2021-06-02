package javaexp.teamP_2_0524;

import java.util.ArrayList;

public class SearchDao {
	
	// 최근 검색어 
	public String[] lately(Keyword k) {
		String lately[] = {"검색어1","검색어2","검색어3"}; 
		
		//가장 최근에 추가된 키워드가 가장 위에 출력 됨 (index 역순 출력)
		System.out.println("# 최근 검색어 #");
		for(int i=lately.length-1; i>=0; i--) {
			System.out.println(lately[i]);
		}
		return lately;
	}
	
	// 인기 검색어
	public String[] ranked(Keyword k) {
		String ranked[] = {"햇반","고메 피자","비비고","만두","김치",
							"비비고 왕교자","big","스팸","주먹밥","냉면"};
		
		System.out.println("# 인기 검색어 #");
		for(int i=0; i<ranked.length; i++) {
			System.out.println((i+1)+") "+ranked[i]);
		}
		return ranked;
	}
	
	//추천 상품+자동완성(상품명)
	public String[] autoSuggestProduct(Keyword k) {
		String suggest[] = {"상품명1", "상품명2", "상품명3"};
		
		//추천 상품(자동완성 상품명 중 첫번째 순서 상품 출력)
		System.out.println("# 추천 상품 #");
		System.out.println(suggest[0]);
		
		//자동완성(상품명)
		System.out.println("# 자동완성 검색어 #");
		for(int i=0; i<suggest.length; i++) {
			System.out.println(suggest[i]);
		}
		return suggest;
	}
	
	//자동완성 기획전
	public String[] autoSuggestEvent(Keyword k) {
		String suggest[] = {"기획전1"};
			
		System.out.println("# 자동완성 기획전 #");
		for(int i=0; i<suggest.length; i++) {
			System.out.println(suggest[i]);
		}
		return suggest;
	}
	
	//연관 검색어
		public String[] related(Keyword k) {
			String related[] = {"연관검색어1", "연관검색어2", "연관검색어3"};
			
			System.out.println("# 연관 검색어 #");
			for(int i=0; i<related.length; i++) {
				System.out.print(related[i]+" ");
			}
			System.out.println();
			return related;
		}
	//상세 검색
	public String[] searchInDetail(Keyword k) {
		//검색 조건들
		String indetail[] = {"카테고리: 가정간편식",
							"혜택: 무료배송",
							"온도/배송유형: 냉장냉동",
							"상품구성: 묶음상품",
							"별점: ★★★★★"
		};
			
		System.out.println("# 상세검색 #");
		for(int i=0; i<indetail.length; i++) {
			System.out.println(indetail[i]);
		}
		return indetail;
	}
	
	//검색 결과 (상품)
	public ArrayList<Product> SearchResult(Keyword k) {
		//상품 DB에 접근..... 
		// plist = keyword에 따라 sort된 검색 결과
		ArrayList<Product> plist = new ArrayList<Product>();
		for(int i=0; i<10; i++) {
			plist.add(new Product("상품"+(i+1)));
		}
			
		System.out.println("# 검색결과(상품) #");
		// 검색된 상품들 (plist) 출력
		for(int i=0; i<plist.size() ; i++) {
			System.out.print(plist.get(i).getName()+" ");
			if((i+1) % 5  == 0 && i != 0 && (i + 1) != plist.size()) {
				System.out.println();
			}
		}
		System.out.println();
		return plist;
	}
	
	//검색 결과 (기획전)
	public ArrayList<Content> SearchResultEvent(Keyword k) {
		// 기획전 DB에 접근.....
		// elist = keyword에 따라 sort된 검색 결과
		ArrayList<Content> elist = new ArrayList<Content>();
		for (int i = 0; i < 7; i++) {
			elist.add(new Event("기획전" + (i + 1)));
		}

		System.out.println("# 검색결과(기획전) #");
		// 검색된 기획전 (elist) 출력
		for (int i = 0; i < elist.size(); i++) {
			System.out.print(elist.get(i).getTitle() + " ");
			if ((i+1) % 5  == 0 && i != 0 && (i + 1) != elist.size()) {
				System.out.println();
			}
		}
		System.out.println();
		return elist;
	}

	// 검색 결과 (동영상)
	public ArrayList<Content> SearchResultMovie(Keyword k) {
		// 동영상 DB에 접근.....
		// plist = keyword에 따라 sort된 검색 결과
		ArrayList<Content> mlist = new ArrayList<Content>();
		for (int i = 0; i < 3; i++) {
			mlist.add(new Movie("동영상" + (i + 1)));
		}

		System.out.println("# 검색결과(동영상) #");
		// 검색된 동영상 (mlist) 출력
		for (int i = 0; i < mlist.size(); i++) {
			System.out.print(mlist.get(i).getTitle() + " ");
			if ((i + 1) % 5 == 0 && i != 0 && (i + 1) != mlist.size()) {
				System.out.println();
			}
		}
		System.out.println();
		return mlist;
	}

	// 검색 결과 (레시피)
	public ArrayList<Content> SearchResultRecipe(Keyword k) {
		// 레시피 DB에 접근.....
		// rlist = keyword에 따라 sort된 검색 결과
		ArrayList<Content> rlist = new ArrayList<Content>();
		for (int i = 0; i < 18; i++) {
			rlist.add(new Recipe("레시피" + (i + 1)));
		}

		System.out.println("# 검색결과(레시피) #");
		// 검색된 레시피 (rlist) 출력
		for (int i = 0; i < rlist.size(); i++) {
			System.out.print(rlist.get(i).getTitle() + " ");
			if ((i + 1) % 5 == 0 && i != 0 && (i + 1) != rlist.size()) {
				System.out.println();
			}
		}
		System.out.println();
		return rlist;
	}
}
