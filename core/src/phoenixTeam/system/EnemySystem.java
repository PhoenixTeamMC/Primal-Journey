package phoenixTeam.system;

import com.badlogic.gdx.math.Vector2;
import phoenixTeam.component.EnemyComponent;
import phoenixTeam.component.HealthComponent;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.component.VelocityComponent;
import phoenixTeam.util.EntityUtil;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.utils.Array;

public class EnemySystem extends IteratingSystem{

	Engine engine;
	
	ComponentMapper<EnemyComponent> e;
	ComponentMapper<PositionComponent> p;
	ComponentMapper<HealthComponent> h;
	ComponentMapper<VelocityComponent> v;
	
	private ImmutableArray<Entity> targets;
	
	@SuppressWarnings({ "unchecked" })
	public EnemySystem() {
		super(Family.all(EnemyComponent.class, PositionComponent.class).get());
		
		e = ComponentMapper.getFor(EnemyComponent.class);
		p = ComponentMapper.getFor(PositionComponent.class);
		h = ComponentMapper.getFor(HealthComponent.class);
		v = ComponentMapper.getFor(VelocityComponent.class);
	}
	
	
	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
		EnemyComponent enemy = e.get(entity);
		PositionComponent position = enemy.position;

		Entity target = enemy.target;
		
		if(target == null || !targets.contains(target, true)){
			
			PositionComponent pos = p.get(entity);
			
    		Array<Entity> entitiesWithin = EntityUtil.INSTANCE.getEntitiesWithin(Family.all(HealthComponent.class).get(), pos.x, pos.y, 10000, 100000);
            Array<Entity> validTargets = new Array<Entity>();
            for (Entity ent : entitiesWithin) {
                if (e.get(ent) != null) {
                    validTargets.add(ent);
                }
            }
            target = EntityUtil.INSTANCE.getClosestEntityOutOf(pos.x, pos.y, validTargets);
    	}
    	
        if(target == null){
        	return;
        }

		EntityUtil.INSTANCE.goToPoint(entity, p.get(target));

		if(EntityUtil.INSTANCE.isWithin(entity, target, enemy.attackRange)){
			HealthComponent health = h.get(entity);

			health.health -= enemy.damage;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addedToEngine(Engine engine){
		this.engine = engine;
		
		engine.getEntitiesFor(Family.all(PositionComponent.class, HealthComponent.class).get());
	}

}
