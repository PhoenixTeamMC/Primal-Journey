package phoenixTeam.component;

import com.badlogic.ashley.core.ComponentMapper;
import phoenixTeam.component.movement.BoundingBoxComponent;
import phoenixTeam.component.movement.PositionComponent;
import phoenixTeam.component.movement.VelocityComponent;
import phoenixTeam.component.render.AnimationComponent;
import phoenixTeam.component.render.AnimationDirectionComponent;
import phoenixTeam.component.render.AnimationLoaderComponent;
import phoenixTeam.component.render.LoaderComponent;
import phoenixTeam.component.render.RenderComponent;

public final class ComponentMappers {
	
	private ComponentMappers(){}
	
	public static final ComponentMapper<AnimationComponent> animation = ComponentMapper.getFor(AnimationComponent.class);
	public static final ComponentMapper<BoundingBoxComponent> boundingBox = ComponentMapper.getFor(BoundingBoxComponent.class);
	public static final ComponentMapper<EnemyComponent> enemy = ComponentMapper.getFor(EnemyComponent.class);
	public static final ComponentMapper<FamiliarComponent> familiar = ComponentMapper.getFor(FamiliarComponent.class);
	public static final ComponentMapper<HealthComponent> health = ComponentMapper.getFor(HealthComponent.class);
	public static final ComponentMapper<PlayerComponent> player = ComponentMapper.getFor(PlayerComponent.class);
	public static final ComponentMapper<PositionComponent> position = ComponentMapper.getFor(PositionComponent.class);
	public static final ComponentMapper<RenderComponent> render = ComponentMapper.getFor(RenderComponent.class);
	public static final ComponentMapper<SkillComponent> skill = ComponentMapper.getFor(SkillComponent.class);
	public static final ComponentMapper<StateComponent> state = ComponentMapper.getFor(StateComponent.class);
	public static final ComponentMapper<VelocityComponent> velocity = ComponentMapper.getFor(VelocityComponent.class);
	public static final ComponentMapper<AnimationLoaderComponent> animationloader = ComponentMapper.getFor(AnimationLoaderComponent.class);
	public static final ComponentMapper<LoaderComponent> loader = ComponentMapper.getFor(LoaderComponent.class);
	public static final ComponentMapper<AnimationDirectionComponent> animationDirection = ComponentMapper.getFor(AnimationDirectionComponent.class);
}
