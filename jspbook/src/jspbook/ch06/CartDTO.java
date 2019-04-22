package jspbook.ch06;

public class CartDTO {
	private String productName;
	private int quantity;

	public CartDTO(String productName, int quantity) {
		super();
		this.productName = productName;
		this.quantity = quantity;
	}

	public CartDTO() {

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartDTO [상품명=" + productName + ", 개수=" + quantity + "]";
	}
	
}
