package phoenixTeam.entity;

import java.util.ArrayList;
import java.util.List;

import phoenixTeam.component.HealthComponent;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.component.RenderComponent;
import phoenixTeam.entity.living.familiars.EntityFamiliar;
import phoenixTeam.entity.skills.Skill;
import phoenixTeam.map.Map;
import phoenixTeam.util.Direction;
import phoenixTeam.util.MathUtil;
import phoenixTeam.util.Random;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
/**
 * Super class for every entity.
 * @author CBachman
 *
 */
public abstract class EntityLiving extends Entity{

	public Direction facing = Direction.RIGHT;

	public float moveSpeed = 0;

	public Map map;
	
	public float targetX;
	public float targetY;

	@SuppressWarnings("unused")
	private Random random;
	
	protected final ComponentMapper<HealthComponent> health;
	protected final ComponentMapper<RenderComponent> texture;
	protected final ComponentMapper<PositionComponent> position;
	
	public EntityLiving(){
		
		this.add(new HealthComponent());
		this.add(new RenderComponent());
		this.add(new PositionComponent());
		
		health = ComponentMapper.getFor(HealthComponent.class);
		texture = ComponentMapper.getFor(RenderComponent.class);
		position = ComponentMapper.getFor(PositionComponent.class);
	}
	
	public abstract String getTextureLocation();
	
	/**
	 * Called every tick, used to update logic. 
	 * @param map
	 */
	public void update(Map map){
		if(!(x == targetX && y == targetY)){
			this.moveTowards(targetX, targetY);
		}
	}

	public void moveTo(float x, float y) {
		this.targetX = x;
		this.targetY = y;
	}

	public void moveTowards(float x, float y){

		float ratio = this.moveSpeed / MathUtil.distance(x, y, this.x, this.y);

		float toMoveX = ratio * (x - this.x);
		float toMoveY = ratio * (y - this.y);
		
		this.x += toMoveX;
		this.y += toMoveY;
	}
	
	//Mana
    public int mana = 20;

    public List<EntityFamiliar> familiars = new ArrayList<EntityFamiliar>();

    public int skillWanted = 0;
    public List<Skill> skills = new ArrayList<Skill>();
    
    public EntityLiving(float x, float y) {
		super(x, y);
	}
}
