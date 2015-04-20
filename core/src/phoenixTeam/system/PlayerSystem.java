package phoenixTeam.system;

import static phoenixTeam.PrimalJourney.camera;
import phoenixTeam.PrimalJourney;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.PlayerComponent;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.map.MapScreen;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class PlayerSystem extends IteratingSystem{
	
	@SuppressWarnings("unchecked")
	public PlayerSystem(){
		super(Family.all(PlayerComponent.class, PositionComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		PositionComponent pos = ComponentMappers.position.get(entity);
		
		Vector2 velocity = getAngle();
		
		pos.x += velocity.x;
		pos.y += velocity.y;
        
        if(Gdx.input.isKeyPressed(Input.Keys.O)){
        	camera.zoom += .02;
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.L)){
        	camera.zoom -= .02;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.BACKSLASH)) {
            PrimalJourney.INSTANCE.setScreen(new MapScreen());
        }
        
        camera.position.x = pos.x;
        camera.position.y = pos.y;
        
        //camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, 100/camera.viewportWidth);
        
        float effectiveViewportWidth = camera.viewportWidth * camera.zoom;
        float effectiveViewportHeight = camera.viewportHeight * camera.zoom;

        camera.position.x = MathUtils.clamp(camera.position.x, effectiveViewportWidth / 2f, 400 - effectiveViewportWidth / 2f);
        camera.position.y = MathUtils.clamp(camera.position.y, effectiveViewportHeight / 2f, 400 - effectiveViewportHeight / 2f);
        
        camera.update();
	}
	
	private Vector2 getAngle(){
        
		Vector2 movement = new Vector2();
		
		
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
        	movement.y++;
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
        	movement.y--;
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
        	movement.x--;
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
        	movement.x++;
        }
        
        return movement;
	}

}
