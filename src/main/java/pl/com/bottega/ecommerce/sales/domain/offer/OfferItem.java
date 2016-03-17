/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class OfferItem implements ValueComparator<OfferItem>{

	private Product product;

	private int quantity;

	private Money money;

	private Discount discount;
	
	private boolean available;

	public OfferItem(Product product, int quantity) {
		this(product, quantity, null, true);
	}

	public OfferItem(Product product, int quantity,
			Discount discount, boolean available) {
		
		
		this.product = product;

		this.quantity = quantity;
		this.discount = discount;

		BigDecimal discountValue = new BigDecimal(0);
		if (discount != null)
			discountValue = discountValue.subtract(discount.getMoney().getValue());

		this.money.setValue(this.product.getProductPrice()
				.multiply(new BigDecimal(quantity)).subtract(discountValue));
		
		this.available = available;
	}

	public String getProductId() {
		return product.getProductId();
	}
	
	public BigDecimal getProductPrice() {
		return product.getProductPrice();
	}
	
	public String getProductName() {
		return product.getProductName();
	}
	
	public Date getProductSnapshotDate() {
		return product.getProductSnapshotDate();
	}
	
	public ProductType getProductType() {
		return product.getProductType();
	}

	public BigDecimal getTotalCost() {
		return money.getValue();
	}

	public Currency getTotalCostCurrency() {
		return money.getCurrency();
	}

	

	public String getDiscountCause() {
		return discount.getDiscountCause();
	}

	public int getQuantity() {
		return quantity;
	}
	
	public boolean isAvailable(){
		return available;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((product.getProductName() == null) ? 0 : product.getProductName().hashCode());
		result = prime * result + ((product.getProductPrice() == null) ? 0 : product.getProductPrice().hashCode());
		result = prime * result
				+ ((product.getProductId() == null) ? 0 : product.getProductId().hashCode());
		result = prime * result + ((product.getProductType() == null) ? 0 : product.getProductType().hashCode());
		result = prime * result + quantity;
		result = prime * result
				+ ((money.getValue() == null) ? 0 : money.getValue().hashCode());
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
		OfferItem other = (OfferItem) obj;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (product.getProductName() == null) {
			if (other.product.getProductName() != null)
				return false;
		} else if (!product.getProductName().equals(other.product.getProductName()))
			return false;
		if (product.getProductPrice() == null) {
			if (other.product.getProductPrice() != null)
				return false;
		} else if (!product.getProductPrice().equals(other.product.getProductPrice()))
			return false;
		if (product.getProductId() == null) {
			if (other.product.getProductId() != null)
				return false;
		} else if (!product.getProductId().equals(other.product.getProductId()))
			return false;
		if (product.getProductType() != other.product.getProductType())
			return false;
		if (quantity != other.quantity)
			return false;
		if (money.getValue() == null) {
			if (other.money.getValue() != null)
				return false;
		} else if (!money.getValue().equals(other.money.getValue()))
			return false;
		return true;
	}

	/**
	 * 
	 * @param item
	 * @param delta
	 *            acceptable percentage difference
	 * @return
	 */
	public boolean sameAs(OfferItem other, double delta) {
		if (product.getProductName() == null) {
			if (other.product.getProductName() != null)
				return false;
		} else if (!product.getProductName().equals(other.product.getProductName()))
			return false;
		if (product.getProductPrice() == null) {
			if (other.product.getProductPrice() != null)
				return false;
		} else if (!product.getProductPrice().equals(other.product.getProductPrice()))
			return false;
		if (product.getProductId() == null) {
			if (other.product.getProductId() != null)
				return false;
		} else if (!product.getProductId().equals(other.product.getProductId()))
			return false;
		if (product.getProductType() != other.product.getProductType())
			return false;

		if (quantity != other.quantity)
			return false;

		BigDecimal max, min;
		if (money.getValue().compareTo(other.money.getValue()) > 0) {
			max = money.getValue();
			min = other.money.getValue();
		} else {
			max = other.money.getValue();
			min = money.getValue();
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

}
