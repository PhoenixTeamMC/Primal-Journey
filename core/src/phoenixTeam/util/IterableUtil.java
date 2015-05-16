package phoenixTeam.util;

import com.google.common.base.Optional;

import java.util.ArrayList;

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
