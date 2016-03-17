package pl.com.bottega.ecommerce.sales.domain.offer;


public class Discount {
	private String discountCause;
	private Money money;

	

	public Discount(String discountCause, Money money) {
		super();
		this.discountCause = discountCause;
		this.money = money;
	}

	public String getDiscountCause() {
		return discountCause;
	}

	public void setDiscountCause(String discountCause) {
		this.discountCause = discountCause;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	
}