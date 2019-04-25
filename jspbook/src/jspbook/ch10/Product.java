package jspbook.ch10;

public class Product {
	
	// 상품 목록 보관할 배열 생성
	private String[] productList = {"item1", "item2", "item3", "item4", "item5"};
	private int num1 = 10;
	private int num2 = 20;
	
	public int getNum1() {
		return num1;
	}

	public int getNum2() {
		return num2;
	}
	
	public String[] getProductList() {
		return productList;
	}
}
