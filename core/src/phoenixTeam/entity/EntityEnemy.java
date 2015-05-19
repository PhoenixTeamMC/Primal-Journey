package phoenixTeam.entity;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Array;
import phoenixTeam.component.EnemyComponent;
import phoenixTeam.component.TargeterComponent;
import phoenixTeam.component.movement.PositionComponent;

/**
 * @author Strikingwolf
 */
public class EntityEnemy extends EntityBase {
	@Override
	public void registerComponents(Array<Component> list) {
		list.add(new EnemyComponent());
		list.add(new PositionComponent());
		list.add(new TargeterComponent());
	}
}
