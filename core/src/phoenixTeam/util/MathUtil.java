package phoenixTeam.util;

public class MathUtil {

	public static float distance(float x1, float y1, float x2, float y2) 
	{ 
		return (float) Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2)); 
	}
	
	public static boolean isWithin(float x, float y, float x2, float y2, float boundary){
		return Math.abs(x - x2) < boundary && Math.abs(y - y2) < boundary;
	}

}
