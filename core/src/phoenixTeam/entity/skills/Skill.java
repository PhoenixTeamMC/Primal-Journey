package phoenixTeam.entity.skills;

import com.badlogic.ashley.core.Entity;

import java.util.ArrayList;

public interface Skill {
	public String getName();

	public ArrayList<Integer> keyCombo();

	public boolean check(Entity entity);

	public void doSkill(Entity entity);
}
