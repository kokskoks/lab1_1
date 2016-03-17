package pl.com.bottega.ecommerce.sales.domain.offer;

public interface ValueComparator<K> {
	/**
	 * 
	 * @param seenOffer
	 * @param delta acceptable difference in percent
	 * @return
	 */
	boolean sameAs(K item, double priceDelta);
}
