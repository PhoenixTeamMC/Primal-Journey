package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import phoenixTeam.component.constants.StatsComponet;

import java.util.HashMap;

public class EnemyComponent extends Component{

	public Entity target;
	
	public float attackRange;
	
	public int damage;

	public StatsComponet stats = new StatsComponet();
	public PositionComponent position = new PositionComponent();
	public VelocityComponent velocity = new VelocityComponent();
	public HealthComponent health = new HealthComponent();
}
