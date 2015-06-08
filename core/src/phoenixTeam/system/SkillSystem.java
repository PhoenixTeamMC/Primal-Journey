package phoenixTeam.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import phoenixTeam.component.ActionComponent;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.entity.actions.Action;
import phoenixTeam.entity.actions.hidden.HiddenAction;
import phoenixTeam.util.IterableUtil;
import phoenixTeam.util.specific.KeysUtil;

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
		for (HiddenAction hidden : IterableUtil.getInstances(actionC.actions.values(), HiddenAction.class)) {
			if (hidden.willUnlock(entity)) {
				actionC.actions.put(hidden.keyCombo(), hidden);
			}
		}

		for (ArrayList<Integer> keys : actionC.actions.keySet()) {
			if (KeysUtil.allPressed(keys)) {
				actionC.actions.get(keys).doAction(entity);
			}
		}
	}
}
