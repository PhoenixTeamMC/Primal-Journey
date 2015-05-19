package phoenixTeam.util;

/**
 * @author Strikingwolf
 */
public class IterableUtil {
	public static <T> boolean containsInstance(Iterable<T> iterable, Class c) {
		for (T t : iterable) {
			if (c.isInstance(t)) {
				return true;
			}
		}
		return false;
	}
}
