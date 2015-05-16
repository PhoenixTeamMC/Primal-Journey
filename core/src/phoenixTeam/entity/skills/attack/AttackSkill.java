package phoenixTeam.entity.skills.attack;

import com.badlogic.ashley.core.Entity;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.TargeterComponent;
import phoenixTeam.entity.skills.Skill;
import phoenixTeam.util.IterableUtil;

public abstract class AttackSkill implements Skill {
	@Override
	public void doSkill(Entity entity) {
		if (IterableUtil.containsInstance(entity.getComponents(), TargeterComponent.class)) {
			doSkillTargeted(entity, ComponentMappers.targeter.get(entity).target);
		}
	}

	public abstract void doSkillTargeted(Entity entity, Entity target);
}
