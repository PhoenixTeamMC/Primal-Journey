package phoenixTeam.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import phoenixTeam.PrimalJourney;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.ItemComponent;
import phoenixTeam.component.PlayerComponent;
import phoenixTeam.component.movement.BoundingBoxComponent;
import phoenixTeam.component.movement.PositionComponent;
import phoenixTeam.item.Item;
import phoenixTeam.map.MapScreen;
import phoenixTeam.util.Util;
import phoenixTeam.util.specific.KeysUtil;

import static phoenixTeam.PrimalJourney.camera;

public class PlayerSystem extends IteratingSystem{
	
	@SuppressWarnings("unchecked")
	public PlayerSystem(){
		super(Family.all(PlayerComponent.class, PositionComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		PositionComponent pos = ComponentMappers.position.get(entity);
		PlayerComponent player = ComponentMappers.player.get(entity);
		player.setPressed(KeysUtil.keyPressed());

		if (player.getPressed().isPresent()) {
			Integer pressed = player.getPressed().get();

			if (pressed == Input.Keys.W && Util.optionalEquals(player.getLastPressed(), Input.Keys.W)) {
				pos.x++;
			} else if (pressed == Input.Keys.O) {
				camera.zoom += .02;
			} else if (pressed == Input.Keys.L) {
				camera.zoom -= .02;
			} else if (pressed == Input.Keys.BACKSLASH) {
				PrimalJourney.INSTANCE.setScreen(new MapScreen());
			}

			if (Family.one(ItemComponent.class).get().matches(entity)) {
				Item item = ComponentMappers.item.get(entity).item;

				if (pressed == Input.Keys.RIGHT) {
					item.onUse(entity);
				} else if (pressed == Input.Keys.LEFT) {
					item.onSwing(entity);
				}
			}
		}
        
        if(ComponentMappers.boundingBox.has(entity)){
        	
        	BoundingBoxComponent b = ComponentMappers.boundingBox.get(entity);
        	
        	camera.position.x = pos.x + b.width / 2;
        	camera.position.y = pos.y + b.height / 2;
        	
        }else{
        	camera.position.x = pos.x;
            camera.position.y = pos.y;
        }
        
        
        
        //camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, 100/camera.viewportWidth);
        
        float effectiveViewportWidth = camera.viewportWidth * camera.zoom;
        float effectiveViewportHeight = camera.viewportHeight * camera.zoom;

        camera.position.x = MathUtils.clamp(camera.position.x, effectiveViewportWidth / 2f, 400 - effectiveViewportWidth / 2f);
        camera.position.y = MathUtils.clamp(camera.position.y, effectiveViewportHeight / 2f, 400 - effectiveViewportHeight / 2f);
        
        camera.update();
	}

}
