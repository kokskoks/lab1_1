package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
	private String productId;
	private Money money;
	private String productName;
	private Date productSnapshotDate;
	private ProductType type;

	
	

	public Product(String productId, Money money, String productName, Date productSnapshotDate, ProductType type) {
		super();
		this.productId = productId;
		this.money = money;
		this.productName = productName;
		this.productSnapshotDate = productSnapshotDate;
		this.type = type;
	}
	

	public ProductType getProductType() {
		return type;
	}

	public void setProductType(ProductType type) {
		this.type = type;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public BigDecimal getProductPrice() {
		return money.getValue();
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getProductSnapshotDate() {
		return productSnapshotDate;
	}

	public void setProductSnapshotDate(Date productSnapshotDate) {
		this.productSnapshotDate = productSnapshotDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productSnapshotDate == null) ? 0 : productSnapshotDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Product other = (Product) obj;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productSnapshotDate == null) {
			if (other.productSnapshotDate != null)
				return false;
		} else if (!productSnapshotDate.equals(other.productSnapshotDate))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	


}