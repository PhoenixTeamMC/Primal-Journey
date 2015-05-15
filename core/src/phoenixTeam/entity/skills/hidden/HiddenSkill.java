package phoenixTeam.entity.skills.hidden;

import com.badlogic.ashley.core.Entity;
import phoenixTeam.entity.skills.Skill;

public interface HiddenSkill extends Skill {
	public boolean willUnlock(Entity entity);
}
