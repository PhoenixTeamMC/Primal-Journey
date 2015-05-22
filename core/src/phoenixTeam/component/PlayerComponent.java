package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.google.common.base.Optional;

public class PlayerComponent extends Component{
	private Optional<Integer> keyPressed;
	private Optional<Integer> lastPressed;

	public Optional<Integer> getPressed() {
		return keyPressed;
	}

	public Optional<Integer> getLastPressed() {
		return lastPressed;
	}

	public PlayerComponent setPressed(Optional<Integer> key) {
		lastPressed = keyPressed;
		keyPressed = key;
		return this;
	}

	//Held Item
	int heldItemIndex = 0;
	//public Item heldItem;

	//TODO: Are we going to have a infinite inventory? I don't know, but this is how it is for now
	//TODO: seperate inventory into it's own component
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
