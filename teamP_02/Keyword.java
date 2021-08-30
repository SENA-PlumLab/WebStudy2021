package javaexp.teamP_2_0524;

import java.awt.Image;

public class Keyword {
	String keyword; //검색어
	String detailSearch; //결과 내 재검색
	String excludeSearch;//제외 검색어
	SearchKind searchkind;// 검색 타입(재검색/제외)
	
	
	public Keyword() {
		super();
	}
	public Keyword(String keyword) {
		super();
		this.keyword = keyword;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}

//게시글 Format
abstract class Content {
	String title;
	String contents;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}

//기획전 게시글
class Event extends Content {
	public Event(String title) {
		super();
		this.title = title;
	}
}

//동영상 게시글
class Movie extends Content{
	public Movie(String title) {
		super();
		this.title = title;
	}
}

//레시피 게시글
class Recipe extends Content {
	public Recipe(String title) {
		super();
		this.title = title;
	}
}

//상품 정보
class Product {
	//기본정보
	Image img;
	String name;
	int price, price_origin; //가격, 할인된 가격
	boolean isDiscounted; //할인여부
	float fiveStarRating; //리뷰점수
	int countOfReview; //리뷰의 수
	
	//속성
	boolean outOfStock = false; // 품절여부
	Category category; // 카테고리 속성
	Benefit benefit; // 혜택 (무료배송, 할인상품, 덤증정, 사은품, 포인트..))
	TemperatureShippingType shipping; // 온도와 배송유형
	Brand brand; // 브랜드
	ProductComposition composition; // 상품구성
	
	
	public Product(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}





// 사용된 enum ----------------------------------------

//검색 타입(재검색/제외)
enum SearchKind { 
	IN_DETAIL, //결과 내 재검색
	EXCLUDE //검색어 제외
}

//카테고리 속성
enum Category { 
	INHOME_SIMPLE, //가정간편식
	HEALTHY_SIMPLE, //건강간편식
	COOKIT, //쿡킷
	FRESH, // 신선식품
	BANCHAN_KIMCHI, //반찬/김치
	SAUCE_OIL, //양념/오일
	DRINK_SNACK, //음료/간식
	HEALTY, //건강식품
	BULK //대용량 식자재
}

//혜택 (무료배송, 할인상품, 덤증정, 사은품, 포인트..))
enum Benefit { 
	SHIP_FREE, //무료배송
	SHIP_DISCOUNT,//할인상품
	MORE,//덤증정
	MORE_GIFT, // 사은품
	POINT //포인트적립
}

//온도와 배송유형
enum TemperatureShippingType { 
	ROOMTEMP, //상온실온
	COLD_FROZEN, //냉장냉동
	SHIP_BY_COMPANY, //업체직송
	SHIP_REGULARLY, //정기배송
	SHIP_AT_EARLYMORNING //새벽배송
}

//브랜드
enum Brand {
	BIBIGO,
	BAEKSUL,
	ODDUGI,
	ETC
}

//상품구성
enum ProductComposition {
	PIECE, //낱개상품
	BUNDLE, //묶음상품
	BULK //대용량상품
}

