package phoenixTeam.entity.actions;

import com.badlogic.ashley.core.Entity;

import java.util.ArrayList;

public interface Action {
	public String getName();

	public ArrayList<Integer> keyCombo();

	public boolean check(Entity entity);

	public void doAction(Entity entity);
}
