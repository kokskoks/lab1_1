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


}