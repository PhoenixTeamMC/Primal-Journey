package phoenixTeam.util;

import java.util.ArrayList;

import phoenixTeam.entity.EntityLiving;
import phoenixTeam.map.Map;

public class EntityUtil {
	
	public static boolean isWithin(EntityLiving original, EntityLiving toCheck, float boundary){
		return MathUtil.isWithin(original.x, original.y, toCheck.x, toCheck.y, boundary);
	}
	
	public static EntityLiving getClosestEntityOutOf(float x, float y, ArrayList<EntityLiving> entities) {
		EntityLiving closest = null;
		for (EntityLiving entity : entities) {
			if (closest == null) {
				closest = entity;
			} else {
				float thisDiff = (entity.x - x) + (entity.y - y);
				float lastDiff = (closest.x - x) + (closest.y - y);
				if (thisDiff < lastDiff) {
					closest = entity;
				}
			}
		}
		return closest;
	}
	
	public static EntityLiving getClosestEntity(float x, float y) {
		return getClosestEntityOutOf(x, y, Map.entityList);
	}
	
	public static ArrayList<EntityLiving> getEntitiesWithin(float x, float y, float withinX, float withinY) {
		ArrayList<EntityLiving> returnList = new ArrayList<EntityLiving>();
		float maxX = x + withinX;
		float minX = x - withinX;
		float maxY = y + withinY;
		float minY = y - withinY;

		for (EntityLiving entity : Map.entityList) {
			if (minX <= entity.x && entity.x <= maxX) {
				if (minY <= entity.y && entity.y <= maxY) {
					returnList.add(entity);
				}
			}
		}
		return returnList;
	}

}
