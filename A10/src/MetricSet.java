import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

@SuppressWarnings("serial")
public class MetricSet<E> extends LinkedHashSet<E> {

	/**
	 * Standardkonstruktor
	 */
	public MetricSet() {

	}

	/**
	 * Standardkonstruktor - fügt alle Element der Collection @param c dem Set
	 * hinzu
	 * 
	 * @param c
	 *            Collection dessen Element zum Set hinzugefügt werden
	 */
	public MetricSet(Collection<? extends E> c) {
		addAll(c);
	}

	/**
	 * Durchsucht das Set mit der Metric @param m nach der Minimaldistanz zu @param
	 * e
	 * 
	 * @param e
	 *            Objekt mit dem Verglichen wird
	 * @param m
	 *            Metrik die verwendet wird
	 * @return Set mit allen Elementen mit der minimalen Distanz
	 */
	public MetricSet<E> search(E e, Metric<? super E> m) {
		MetricSet<E> ret = new MetricSet<E>();
		Iterator<E> it = iterator();
		E temp = null;
		int minDistance = -1;

		while (it.hasNext()) {
			temp = it.next();
			if (ret.size() == 0) {
				// Set ist leer
				ret.add(temp);
				minDistance = m.distance(e, temp);
			} else {

				if (m.distance(e, temp) < minDistance) {
					// neues Minimum
					ret.clear();
					ret.add(temp);
				} else if (m.distance(e, temp) == minDistance) {
					// neues Bild mit gleichen Minimum
					ret.add(temp);
				}
			}
		}
		return ret;
	}

}
