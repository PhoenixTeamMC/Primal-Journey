package phoenixTeam.entity;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.utils.Array;
import com.google.common.eventbus.Subscribe;
import phoenixTeam.PrimalJourney;
import phoenixTeam.component.HealthComponent;
import phoenixTeam.component.KillableComponent;
import phoenixTeam.component.PlayerComponent;
import phoenixTeam.component.StateComponent;
import phoenixTeam.component.movement.BoundingBoxComponent;
import phoenixTeam.component.movement.ControlComponent;
import phoenixTeam.component.movement.PositionComponent;
import phoenixTeam.component.movement.VelocityComponent;
import phoenixTeam.component.render.AnimationDirectionComponent;
import phoenixTeam.component.render.RenderComponent;
import phoenixTeam.event.entity.AfterDeath;
import phoenixTeam.event.entity.Death;
import phoenixTeam.map.MapScreen;

public class EntityPlayer extends EntityBase {

	@Override
	public void registerComponents(Array<Component> list) {	
		list.add(new PositionComponent());
		list.add(new PlayerComponent());
		list.add(new StateComponent());
		
		AnimationDirectionComponent d = new AnimationDirectionComponent();
		
		d.down = "data/player/down.gif";
		d.up = "data/player/up.gif";
		d.left = "data/player/left.gif";
		d.right = "data/player/right.gif";
		
		list.add(d);
		
		//list.add(new AnimationComponent("data/player/down.gif", PlayMode.LOOP));
		list.add(new RenderComponent());
		list.add(new BoundingBoxComponent(1, 1));
		list.add(new ControlComponent());
		list.add(new VelocityComponent());

		list.add(new KillableComponent());

		list.add(new HealthComponent());
	}

	private class PlayerDeathHandler {
		@Subscribe
		public void playerDeath(Death death) {
			if (death.entity instanceof EntityPlayer) {
				// TODO, Drops? Anything player death related
			}
		}

		@Subscribe
		public void playerRespawn(AfterDeath after) {
			if (after.entity instanceof EntityPlayer) {
				PrimalJourney.INSTANCE.setScreen(new MapScreen());
			}
		}
	}
}
