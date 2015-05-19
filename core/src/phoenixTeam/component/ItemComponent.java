package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.google.common.base.Optional;
import phoenixTeam.item.Item;

/**
 * @author Strikingwolf
 */
public class ItemComponent extends Component {
	public Optional<Item> item;
}
