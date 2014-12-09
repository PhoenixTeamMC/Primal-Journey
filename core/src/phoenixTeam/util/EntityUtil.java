package phoenixTeam.util;

import phoenixTeam.entity.Entity;

public class EntityUtil {
	
	public static boolean isWithin(Entity original, Entity toCheck, float boundary){
		return MathUtil.isWithin(original.x, original.y, toCheck.x, toCheck.y, boundary);
	}

}
