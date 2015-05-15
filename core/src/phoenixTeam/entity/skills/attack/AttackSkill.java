package phoenixTeam.entity.skills.attack;

import com.badlogic.ashley.core.Entity;
import phoenixTeam.entity.skills.Skill;

public abstract class AttackSkill implements Skill {
	@Override
	public void doSkill(Entity entity) {
		// TODO attacker component
	};

	public abstract void doSkillTargeted(Entity entity, Entity target);
}
