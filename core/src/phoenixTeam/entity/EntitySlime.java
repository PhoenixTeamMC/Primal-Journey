package phoenixTeam.entity;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Array;
import phoenixTeam.component.EnemyComponent;
import phoenixTeam.component.movement.PositionComponent;

public class EntitySlime extends EntityBase{

	@Override
	public void registerComponents(Array<Component> list){
		list.add(new EnemyComponent());
		list.add(new PositionComponent());
	}

}
