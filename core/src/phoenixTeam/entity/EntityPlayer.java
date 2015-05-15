package phoenixTeam.entity;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.Array;
import phoenixTeam.component.PlayerComponent;
import phoenixTeam.component.StateComponent;
import phoenixTeam.component.movement.BoundingBoxComponent;
import phoenixTeam.component.movement.ControlComponent;
import phoenixTeam.component.movement.PositionComponent;
import phoenixTeam.component.movement.VelocityComponent;
import phoenixTeam.component.render.AnimationLoaderComponent;

public class EntityPlayer extends EntityBase {

	@Override
	public void registerComponents(Array<Component> list) {	
		list.add(new PositionComponent());
		list.add(new PlayerComponent());
		list.add(new StateComponent());
		list.add(new AnimationLoaderComponent("data/ba.gif", PlayMode.LOOP));
		list.add(new BoundingBoxComponent(1, 1));
		list.add(new ControlComponent());
		list.add(new VelocityComponent());
	}
}
