package phoenixTeam.system;

import static phoenixTeam.PrimalJourney.assetManager;
import phoenixTeam.component.AnimationComponent;
import phoenixTeam.component.AnimationLoaderComponent;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.LoaderComponent;
import phoenixTeam.component.RenderComponent;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class LoadingSystem extends IteratingSystem{

	public LoadingSystem() {
		super(Family.one(LoaderComponent.class, AnimationLoaderComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
		if(ComponentMappers.animationloader.has(entity)){
			AnimationLoaderComponent a = ComponentMappers.animationloader.get(entity);
			
			if(!a.hasStarted){
				assetManager.load(a.toLoad, Animation.class);
				a.hasStarted = true;
			}
			
			if(assetManager.isLoaded(a.toLoad, Animation.class)){
				AnimationComponent c = new AnimationComponent(assetManager.get(a.toLoad, Animation.class), a.mode);
				
				entity.add(c);
				entity.add(new RenderComponent(c.animation.getKeyFrame(0), 10, 10));
				entity.remove(AnimationLoaderComponent.class);
			}
		} else {
			LoaderComponent l = ComponentMappers.loader.get(entity);
			
			if(!l.hasStarted){
				assetManager.load(l.toLoad, Texture.class);
				l.hasStarted = true;
			}
			
			if(assetManager.isLoaded(l.toLoad, Texture.class)){
				entity.add(new RenderComponent(assetManager.get(l.toLoad, Texture.class)));
				entity.remove(LoaderComponent.class);
			}
		}
		
	}

}
