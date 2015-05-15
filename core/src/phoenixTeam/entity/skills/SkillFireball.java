package phoenixTeam.entity.skills;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Input;

import java.util.ArrayList;

/**
 * @author Strikingwolf, chbachman
 */
public class SkillFireball implements Skill
{
	@Override
	public String getName() {
		return "Fireball";
	}

	@Override
	public ArrayList<Integer> keyCombo() {
		ArrayList<Integer> keys = new ArrayList<Integer>();
		keys.add(Input.Keys.F);
		return keys;
	}

	@Override
	public boolean check(Entity entity) {
		// TODO implement something here
		return true;
	}

	@Override
    public void doSkill(Entity entity) {
		// TODO implement fireball
    }
}
