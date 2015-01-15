package phoenixTeam.component;


import com.badlogic.ashley.core.Component;
import phoenixTeam.component.constants.StatsComponent;

import java.util.HashMap;

/**
 * @author Strikingwolf
 *
 */
public class EntityComponet extends Component {
    public HashMap<String, Component> extras = new HashMap<String, Component>();

    public VelocityComponent velocity = new VelocityComponent();
    public RenderComponent render;
    public PositionComponent position = new PositionComponent();
    public StatsComponent stats = new StatsComponent();
    public HealthComponent health = new HealthComponent();
}
