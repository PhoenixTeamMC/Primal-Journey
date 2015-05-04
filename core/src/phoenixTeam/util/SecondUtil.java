package phoenixTeam.util;

import com.badlogic.gdx.utils.TimeUtils;

public class SecondUtil{
	
	static long startTime = TimeUtils.nanoTime();

	/** Logs the current frames per second to the console. */
	public static boolean isSecond () {
		if (TimeUtils.nanoTime() - startTime > 1000000000) /* 1,000,000,000ns == one second */{
			startTime = TimeUtils.nanoTime();
			return true;
		}
		
		return false;
	}
	
}
