package phoenixTeam.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.ActionComponent;
import phoenixTeam.entity.actions.Action;
import phoenixTeam.entity.actions.hidden.HiddenAction;
import phoenixTeam.util.KeysUtil;

import java.util.ArrayList;

/**
 * @author Strikingwolf
 */
public class SkillSystem extends IteratingSystem {

	@SuppressWarnings("unchecked")
	public SkillSystem() {
		super(Family.all(ActionComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		ActionComponent actionC = ComponentMappers.action.get(entity);

		// TODO This form should be generified somehow (take a list and get a certain instance group)
		for (Action a : actionC.actions.values()) {
			if (a instanceof HiddenAction && ((HiddenAction) a).willUnlock(entity)) {
				actionC.actions.put(a.keyCombo(), a);
			}
		}

		for (ArrayList<Integer> keys : actionC.actions.keySet()) {
			if (KeysUtil.allPressed(keys)) {
				actionC.actions.get(keys).doAction(entity);
			}
		}
	}
}
