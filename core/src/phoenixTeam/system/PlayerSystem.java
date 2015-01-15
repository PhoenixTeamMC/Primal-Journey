package phoenixTeam.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import phoenixTeam.PrimalJourney;
import phoenixTeam.component.PlayerComponent;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.map.MapScreen;

public class PlayerSystem extends IteratingSystem{
	
	public OrthographicCamera camera;
	
	private ComponentMapper<PlayerComponent> play;
	private ComponentMapper<PositionComponent> p;
	
	public PlayerSystem(OrthographicCamera camera){
		super(Family.all(PlayerComponent.class, PositionComponent.class).get());
		
		this.camera = camera;
		
		play = ComponentMapper.getFor(PlayerComponent.class);
		p = ComponentMapper.getFor(PositionComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		PositionComponent pos = p.get(entity);
		
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
        
        camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, 100/camera.viewportWidth);
        
        float effectiveViewportWidth = camera.viewportWidth * camera.zoom;
        float effectiveViewportHeight = camera.viewportHeight * camera.zoom;

       // camera.position.x = MathUtils.clamp(camera.position.x, effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f);
        //camera.position.y = MathUtils.clamp(camera.position.y, effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f);
        
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
