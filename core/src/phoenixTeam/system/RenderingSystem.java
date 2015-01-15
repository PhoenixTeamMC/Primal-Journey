package phoenixTeam.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import phoenixTeam.PrimalJourney;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.component.RenderComponent;

import java.util.Comparator;

public class RenderingSystem extends IteratingSystem{

	SpriteBatch batch = PrimalJourney.batch;
	
	Array<Entity> renderQueue;
	Comparator<Entity> comparator;

	OrthographicCamera camera;

	private ComponentMapper<RenderComponent> r;
	private ComponentMapper<PositionComponent> p;
	
	@SuppressWarnings("unchecked")
	public RenderingSystem(OrthographicCamera camera) {
		super(Family.all(RenderComponent.class, PositionComponent.class).get());
		
		this.camera = camera; 
		
		r = ComponentMappers.render;
		p = ComponentMappers.position;
		
		renderQueue = new Array<Entity>();
		
		comparator = new Comparator<Entity>() {
			@Override
			public int compare(Entity entityA, Entity entityB) {
				return (int)Math.signum(p.get(entityB).layer - p.get(entityA).layer);
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
			RenderComponent tex = r.get(entity);
			PositionComponent pos = p.get(entity);
			
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
