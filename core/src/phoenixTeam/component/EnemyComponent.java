package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

public class EnemyComponent extends Component{

	public Entity target;
	
	public float attackRange;
	
	public int damage;
	
}
