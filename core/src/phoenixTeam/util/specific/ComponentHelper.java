package phoenixTeam.util.specific;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;

public class ComponentHelper{
	public static boolean matches(Entity entity, Class<? extends Component>... components) {
		return Family.all(components).get().matches(entity);
	}
}
