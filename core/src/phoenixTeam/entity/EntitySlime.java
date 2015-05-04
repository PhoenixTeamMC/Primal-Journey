package phoenixTeam.entity;

import phoenixTeam.component.EnemyComponent;
import phoenixTeam.component.movement.PositionComponent;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Array;

public class EntitySlime extends EntityBase{

	@Override
	public void registerComponents(Array<Component> list){
		list.add(new EnemyComponent());
		list.add(new PositionComponent());
	}

}
