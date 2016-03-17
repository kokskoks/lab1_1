package pl.com.bottega.ecommerce.sales.domain.offer;

public interface ValueComparator<K> {
	/**
	 * Method to compare two K object with some wiggle room for price difference
	 * @param seenOffer K object to compare with
	 * @param delta acceptable difference of the K price in percent
	 * @return
	 */
	boolean sameAs(K item, double priceDelta);
}
