package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class PlayerComponent extends Component{

	//Held Item
	int heldItemIndex = 0;
	//public Item heldItem;

	//TODO: Are we going to have a infinite inventory? I don't know, but this is how it is for now
	//public List<Item> inventory = new ArrayList<Item>();

	//Experience
	public int totalExp = 0;
	public int expLevel = 0;

	//Stats
	int constitution = 0;
	int strength = 0;
	int dexterity = 0;
	int wisdom = 0;

	//Skills
	//TODO

}
