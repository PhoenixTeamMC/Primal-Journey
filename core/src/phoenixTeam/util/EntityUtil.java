package phoenixTeam.util;

import java.util.ArrayList;

import phoenixTeam.entity.Entity;
import phoenixTeam.map.Map;

public class EntityUtil {
	
	public static boolean isWithin(Entity original, Entity toCheck, float boundary){
		return MathUtil.isWithin(original.x, original.y, toCheck.x, toCheck.y, boundary);
	}
	
	public static Entity getClosestEntityOutOf(float x, float y, ArrayList<Entity> entities) {
		Entity closest = null;
		for (Entity entity : entities) {
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
	
	public static Entity getClosestEntity(float x, float y) {
		return getClosestEntityOutOf(x, y, Map.entityList);
	}
	
	public static ArrayList<Entity> getEntitiesWithin(float x, float y, float withinX, float withinY) {
		ArrayList<Entity> returnList = new ArrayList<Entity>();
		float maxX = x + withinX;
		float minX = x - withinX;
		float maxY = y + withinY;
		float minY = y - withinY;

		for (Entity entity : Map.entityList) {
			if (minX <= entity.x && entity.x <= maxX) {
				if (minY <= entity.y && entity.y <= maxY) {
					returnList.add(entity);
				}
			}
		}
		return returnList;
	}

}
