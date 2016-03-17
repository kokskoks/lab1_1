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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountCause == null) ? 0 : discountCause.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Discount other = (Discount) obj;
		if (discountCause == null) {
			if (other.discountCause != null)
				return false;
		} else if (!discountCause.equals(other.discountCause))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		return true;
	}
	
	

	
}