package phoenixTeam.entity;

import java.util.List;

import phoenixTeam.component.EnemyComponent;
import phoenixTeam.component.PositionComponent;

import com.badlogic.ashley.core.Component;

public class EntitySlime extends EntityBase{

	@Override
	public void registerComponents(List<Component> list){
		list.add(new EnemyComponent());
		list.add(new PositionComponent());
	}

}
