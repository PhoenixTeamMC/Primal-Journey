package phoenixTeam.system.movement;

import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.movement.ControlComponent;
import phoenixTeam.component.movement.VelocityComponent;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class ControlSystem extends IteratingSystem{

	public ControlSystem() {
		super(Family.all(VelocityComponent.class, ControlComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime){
		VelocityComponent v = ComponentMappers.velocity.get(entity);

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
		
		v.velocity.add(movement.scl(deltaTime));
	}

}
