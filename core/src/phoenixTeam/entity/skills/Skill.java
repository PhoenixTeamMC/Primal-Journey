package phoenixTeam.entity.skills;

import com.badlogic.ashley.core.Entity;

public abstract class Skill {
	
	public Skill(String name){
		
	}
	
	public abstract void doSkill(Entity entity);

}
