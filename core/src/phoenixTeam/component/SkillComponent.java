package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import phoenixTeam.entity.skills.Skill;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class SkillComponent extends Component{
	public HashMap<ArrayList<Integer>, Skill> skills = new HashMap<ArrayList<Integer>, Skill>();
}
