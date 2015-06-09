package phoenixTeam.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Strikingwolf
 */
public class IterableUtil {
	/**
	 * Checks if the list (iterable) contains something of an instance class c
	 * @param iterable a list of things
	 * @param c class to check against
	 * @param <T> Type of the list
	 * @return if the list contains something of instance class c
	 */
	public static <T> boolean containsInstance(Iterable<T> iterable, Class c) {
		for (T t : iterable) {
			if (c.isInstance(t)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the instances of Class c in iterable
	 * @param iterable iterable with instances
	 * @param c class of generic type E
	 * @param <E> Type of the list to return and the generic of c
	 * @return List\<E> where object in list is an instanceof class c of generic type E
	 */
	public static <E> List<E> getInstances(Iterable iterable, Class<E> c) 			{
		ArrayList<E> result = new ArrayList<E>();
		for (Object obj : iterable) {
			if (c.isInstance(obj)) {
				result.add(c.cast(obj));
			}
		}
		return result;
	}
}
