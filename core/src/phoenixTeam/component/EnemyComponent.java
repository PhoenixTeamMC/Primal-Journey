package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import phoenixTeam.component.constants.StatsComponent;

public class EnemyComponent extends Component{

	public Entity target;
	
	public float attackRange;
	
	public int damage;

	public StatsComponent stats = new StatsComponent();
	public PositionComponent position = new PositionComponent();
	public VelocityComponent velocity = new VelocityComponent();
	public HealthComponent health = new HealthComponent();
}
