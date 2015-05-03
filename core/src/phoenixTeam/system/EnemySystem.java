package phoenixTeam.system;

import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.EnemyComponent;
import phoenixTeam.component.HealthComponent;
import phoenixTeam.component.movement.PositionComponent;
import phoenixTeam.util.EntityUtil;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.utils.Array;

public class EnemySystem extends IteratingSystem{

	Engine engine;
	
	private ImmutableArray<Entity> targets;
	
	public EnemySystem() {
		super(Family.all(EnemyComponent.class, PositionComponent.class).get());
	}
	
	
	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
		EnemyComponent enemy = ComponentMappers.enemy.get(entity);

		Entity target = enemy.target;
		
		if(target == null || !targets.contains(target, true)){
			
			PositionComponent pos = ComponentMappers.position.get(entity);
			
    		Array<Entity> entitiesWithin = EntityUtil.INSTANCE.getEntitiesWithin(Family.all(HealthComponent.class).get(), pos.x, pos.y, 10000, 100000);
            Array<Entity> validTargets = new Array<Entity>();
            for (Entity ent : entitiesWithin) {
                if (ComponentMappers.enemy.has(ent)) {
                    validTargets.add(ent);
                }
            }
            target = EntityUtil.INSTANCE.getClosestEntityOutOf(pos.x, pos.y, validTargets);
    	}
    	
        if(target == null){
        	return;
        }

		EntityUtil.INSTANCE.goToPoint(entity, ComponentMappers.position.get(target));

		if(EntityUtil.INSTANCE.isWithin(entity, target, enemy.attackRange)){
			HealthComponent health = ComponentMappers.health.get(entity);

			health.health -= enemy.damage;
		}
	}

	@Override
	public void addedToEngine(Engine engine){
		this.engine = engine;
		
		engine.getEntitiesFor(Family.all(PositionComponent.class, HealthComponent.class).get());
	}

}
