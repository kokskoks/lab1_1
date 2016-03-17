package pl.com.bottega.ecommerce.sales.domain.offer;

public interface ValueComparator<K> {
	boolean sameAs(K item, double priceDelta);
}
