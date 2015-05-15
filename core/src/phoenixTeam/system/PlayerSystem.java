package phoenixTeam.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import phoenixTeam.PrimalJourney;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.PlayerComponent;
import phoenixTeam.component.movement.BoundingBoxComponent;
import phoenixTeam.component.movement.PositionComponent;
import phoenixTeam.map.MapScreen;
import phoenixTeam.util.SecondUtil;

import static phoenixTeam.PrimalJourney.camera;

public class PlayerSystem extends IteratingSystem{
	
	@SuppressWarnings("unchecked")
	public PlayerSystem(){
		super(Family.all(PlayerComponent.class, PositionComponent.class).get());
	}

	private boolean wasPressed = false;
	
	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
		PositionComponent pos = ComponentMappers.position.get(entity);
		
		if(SecondUtil.isSecond())
			System.out.println("X: " + pos.x + " Y: " + pos.y);
        
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			
			if(!wasPressed){
				pos.x++;
			}
			

			wasPressed = true;
		}else{
			wasPressed = false;
		}
		
        if(Gdx.input.isKeyPressed(Input.Keys.O)){
        	camera.zoom += .02;
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.L)){
        	camera.zoom -= .02;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.BACKSLASH)) {
            PrimalJourney.INSTANCE.setScreen(new MapScreen());
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
