package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import phoenixTeam.entity.actions.Action;

import java.util.ArrayList;
import java.util.HashMap;

public class ActionComponent extends Component{
	public HashMap<ArrayList<Integer>, Action> actions = new HashMap<ArrayList<Integer>, Action>();
}
