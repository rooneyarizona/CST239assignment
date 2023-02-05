package app;

import java.util.Comparator;

/**
 * @author Alastair Sagar
 *  
 *A class implementing Comparator of type Salable Product to sort collection
 */
public class PriceSort implements Comparator<SalableProduct> {


	@Override
	public int compare(SalableProduct o1, SalableProduct o2) {
		
		return Double.compare(o1.getPrice(), o2.getPrice());
	}

}
