package app;

import java.util.Comparator;

/**
 * @author Alastair Sagar
 * A class implementing Comparator of type Salabale Product to sort collection
 *
 */
public class NameDescending implements Comparator<SalableProduct> {

	@Override
	public int compare(SalableProduct o1, SalableProduct o2) {
		
		return -o1.getName().compareTo(o2.getName());
	}

}
