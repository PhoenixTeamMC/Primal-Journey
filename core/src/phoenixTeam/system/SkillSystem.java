package phoenixTeam.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.SkillComponent;
import phoenixTeam.entity.skills.Skill;
import phoenixTeam.entity.skills.hidden.HiddenSkill;
import phoenixTeam.util.KeysUtil;

import java.util.ArrayList;

/**
 * @author Strikingwolf
 */
public class SkillSystem extends IteratingSystem {

	@SuppressWarnings("unchecked")
	public SkillSystem() {
		super(Family.all(SkillComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		SkillComponent skillC = ComponentMappers.skill.get(entity);

		// TODO This form should be generified somehow (take a list and get a certain instance group)
		for (Skill s : skillC.skills.values()) {
			if (s instanceof HiddenSkill && ((HiddenSkill) s).willUnlock(entity)) {
				skillC.skills.put(s.keyCombo(), s);
			}
		}

		for (ArrayList<Integer> keys : skillC.skills.keySet()) {
			if (KeysUtil.allPressed(keys)) {
				skillC.skills.get(keys).doSkill(entity);
			}
		}
	}
}
