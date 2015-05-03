package phoenixTeam.entity;

import java.util.List;

import phoenixTeam.component.PlayerComponent;
import phoenixTeam.component.StateComponent;
import phoenixTeam.component.movement.BoundingBoxComponent;
import phoenixTeam.component.movement.ControlComponent;
import phoenixTeam.component.movement.PositionComponent;
import phoenixTeam.component.movement.VelocityComponent;
import phoenixTeam.component.render.AnimationLoaderComponent;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class EntityPlayer extends EntityBase {

	@Override
	public void registerComponents(List<Component> list) {	
		list.add(new PositionComponent());
		list.add(new PlayerComponent());
		list.add(new StateComponent());
		list.add(new AnimationLoaderComponent("data/ba.gif", PlayMode.LOOP));
		list.add(new BoundingBoxComponent(10, 10));
		list.add(new ControlComponent());
		list.add(new VelocityComponent());
	}
}
