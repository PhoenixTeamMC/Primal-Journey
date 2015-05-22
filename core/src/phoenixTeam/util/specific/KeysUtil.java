package phoenixTeam.util.specific;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.google.common.base.Optional;

/**
 * @author Strikingwolf
 */
public class KeysUtil {
	public static boolean allPressed(Iterable<Integer> keys) {
		for (int key : keys) {
			if (!Gdx.input.isKeyPressed(key)) {
				return false;
			}
		}
		return true;
	}

	public static Optional<Integer> keyPressed() {
		for (int i = -1; i <= 255; i++) {
			if (Gdx.input.isKeyPressed(i)) {
				return Optional.of(i);
			}
		}
		return Optional.absent();
	}
}
