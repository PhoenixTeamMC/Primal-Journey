package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import phoenixTeam.entity.skills.Skill;

import java.util.ArrayList;
import java.util.List;

public abstract class SkillComponent extends Component{
    public String name;
    
    public int skillWanted = 0;
    
    public List<Skill> skills = new ArrayList<Skill>();
}
