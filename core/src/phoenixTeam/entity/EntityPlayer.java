package phoenixTeam.entity;

import java.util.List;

import phoenixTeam.component.AnimationLoaderComponent;
import phoenixTeam.component.PlayerComponent;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.component.StateComponent;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class EntityPlayer extends EntityBase{

	@Override
	public void registerComponents(List<Component> list) {	
		list.add(new PositionComponent());
		list.add(new PlayerComponent());
		list.add(new StateComponent());
		list.add(new AnimationLoaderComponent("data/ba.gif", PlayMode.LOOP));
		
	}

	
	
}
