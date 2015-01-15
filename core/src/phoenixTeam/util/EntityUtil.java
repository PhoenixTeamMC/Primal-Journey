package phoenixTeam.util;

import com.badlogic.gdx.math.Vector2;
import phoenixTeam.component.PositionComponent;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.utils.Array;
import phoenixTeam.component.StateComponent;
import phoenixTeam.component.VelocityComponent;
import phoenixTeam.component.constants.StatsComponet;

public class EntityUtil {
	
	
	public static EntityUtil INSTANCE = new EntityUtil();
	
	private Engine engine;
	
	private ImmutableArray<Entity> livingList;
	
	private ComponentMapper<PositionComponent> p;
	private ComponentMapper<StatsComponet> s;
	private ComponentMapper<VelocityComponent> v;
	
	public EntityUtil(){
		p = ComponentMapper.getFor(PositionComponent.class);
		s = ComponentMapper.getFor(StatsComponet.class);
		v = ComponentMapper.getFor(VelocityComponent.class);
	}
	
	@SuppressWarnings("unchecked")
	public void setEngine(Engine engine){
		this.engine = engine;
		this.livingList = engine.getEntitiesFor(Family.all(PositionComponent.class).get());
	}
	
	public boolean isWithin(Entity original, Entity toCheck, float boundary){
		PositionComponent orig = p.get(original);
		PositionComponent to = p.get(toCheck);
		
		return MathUtil.isWithin(orig.x, orig.y, to.x, to.y, boundary);
	}
	
	public Entity getClosestEntityOutOf(float x, float y, ImmutableArray<Entity> entities) {
		if(entities == null || entities.size() == 0){
			throw new IllegalArgumentException();
		}
		
		Entity closest = entities.get(0);
		
		for (Entity entity : entities) {
			
			PositionComponent entPos = p.get(entity);
			PositionComponent close = p.get(closest);
			
			float thisDiff = (entPos.x - x) + (entPos.y - y);
			float lastDiff = (close.x - x) + (close.y - y);
			
			if (thisDiff < lastDiff) {
				closest = entity;
			}
		}
		
		return closest;
	}
	
	public Entity getClosestEntityOutOf(float x, float y, Array<Entity> entities) {
		if(entities == null || entities.size == 0){
			throw new IllegalArgumentException();
		}
		
		Entity closest = entities.get(0);
		
		for (Entity entity : entities) {
			
			PositionComponent entPos = p.get(entity);
			PositionComponent close = p.get(closest);
			
			float thisDiff = (entPos.x - x) + (entPos.y - y);
			float lastDiff = (close.x - x) + (close.y - y);
			
			if (thisDiff < lastDiff) {
				closest = entity;
			}
		}
		
		return closest;
	}
	
	public Entity getClosestEntity(float x, float y) {
		return getClosestEntityOutOf(x, y, livingList);
	}
	
	public Entity getClosestEntity(Family family, float x, float y) {
		return getClosestEntityOutOf(x, y, engine.getEntitiesFor(family));
	}
	
	public Array<Entity> getEntitiesWithin(float x, float y, float withinX, float withinY) {
		Array<Entity> returnList = new Array<Entity>();
		float maxX = x + withinX;
		float minX = x - withinX;
		float maxY = y + withinY;
		float minY = y - withinY;

		for (Entity ent : livingList) {
			
			PositionComponent pos = p.get(ent);
			
			if (minX <= pos.x && pos.x <= maxX) {
				if (minY <= pos.y && pos.y <= maxY) {
					returnList.add(ent);
				}
			}
		}
		return returnList;
	}
	
	public Array<Entity> getEntitiesWithin(Family family, float x, float y, float withinX, float withinY) {
		Array<Entity> returnList = new Array<Entity>();
		float maxX = x + withinX;
		float minX = x - withinX;
		float maxY = y + withinY;
		float minY = y - withinY;

		for (Entity ent : engine.getEntitiesFor(family)) {
			
			PositionComponent pos = p.get(ent);
			
			if (minX <= pos.x && pos.x <= maxX) {
				if (minY <= pos.y && pos.y <= maxY) {
					returnList.add(ent);
				}
			}
		}
		return returnList;
	}

	public Vector2 getVectorToGetToPoint(PositionComponent current, PositionComponent destination, int speed) {
		Vector2 vector = new Vector2();
		vector.x = 0;
		vector.y = 0;

		float diffX = current.x - destination.x;
		float diffY = current.y - destination.y;

		if (diffX > 0) {
			vector.x = -speed;
		} else if (diffX < 0) {
			vector.x = speed;
		}

		if (diffY > 0) {
			vector.y = -speed;
		} else if (diffY < 0) {
			vector.y = speed;
		}

		return vector;
	}

	public void goToPoint(Entity entity, PositionComponent destination) {
		v.get(entity).velocity = getVectorToGetToPoint(p.get(entity), destination, s.get(entity).speed);
	}
}
