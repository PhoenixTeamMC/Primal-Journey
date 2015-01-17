package phoenixTeam.system;

import static phoenixTeam.PrimalJourney.camera;

import java.util.Comparator;

import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.component.RenderComponent;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class RenderingSystem extends IteratingSystem{

	SpriteBatch batch = new SpriteBatch();
	
	Array<Entity> renderQueue;
	Comparator<Entity> comparator;
	
	@SuppressWarnings("unchecked")
	public RenderingSystem() {
		super(Family.all(RenderComponent.class, PositionComponent.class).get()); 
		
		renderQueue = new Array<Entity>();
		
		comparator = new Comparator<Entity>() {
			@Override
			public int compare(Entity entityA, Entity entityB) {
				return (int)Math.signum(ComponentMappers.position.get(entityB).layer - ComponentMappers.position.get(entityA).layer);
			}
		};
		
		
		
	}
	
	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		renderQueue.add(entity);
	}
	
	@Override
	public void update(float deltaTime){
		super.update(deltaTime);
		
		renderQueue.sort(comparator);
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		for (Entity entity : renderQueue) {
			RenderComponent tex = ComponentMappers.render.get(entity);
			PositionComponent pos = ComponentMappers.position.get(entity);
			
			if (tex.region == null) {
				continue;
			}
			
			if(tex.xSize < 0 || tex.ySize < 0){
				batch.draw(tex.region, pos.x, pos.y);
			}else{
				batch.draw(tex.region, pos.x, pos.y, tex.xSize, tex.ySize);
			}
			
			
		}
		
		batch.end();
		
		renderQueue.clear();
		
	}

}
