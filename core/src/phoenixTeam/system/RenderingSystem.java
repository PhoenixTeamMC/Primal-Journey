package phoenixTeam.system;

import java.util.Comparator;

import phoenixTeam.Main;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.component.RenderComponent;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class RenderingSystem extends IteratingSystem{

	SpriteBatch batch = Main.batch;
	
	Array<Entity> renderQueue;
	Comparator<Entity> comparator;

	OrthographicCamera camera;

	private ComponentMapper<RenderComponent> r;
	private ComponentMapper<PositionComponent> p;
	
	@SuppressWarnings("unchecked")
	public RenderingSystem() {
		super(Family.all(RenderComponent.class, PositionComponent.class).get());
		
		r = ComponentMapper.getFor(RenderComponent.class);
		p = ComponentMapper.getFor(PositionComponent.class);
		
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
			
			batch.draw(tex.region, pos.x, pos.y);
		}
		
		batch.end();
		
		renderQueue.clear();
		
	}

}
