package phoenixTeam.component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.badlogic.gdx.Input;
import com.sun.tools.javac.util.Pair;
import phoenixTeam.entity.skills.Skill;

import com.badlogic.ashley.core.Component;

public abstract class SkillComponent extends Component{
	public HashMap<ArrayList<Integer>, Skill> skills = new HashMap<ArrayList<Integer>, Skill>();
}
