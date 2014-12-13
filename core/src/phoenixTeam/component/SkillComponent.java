package phoenixTeam.component;

import java.util.ArrayList;
import java.util.List;

import phoenixTeam.entity.skills.Skill;

import com.badlogic.ashley.core.Component;

public abstract class SkillComponent extends Component{
    public String name;
    
    public int skillWanted = 0;
    
    public List<Skill> skills = new ArrayList<Skill>();
}
