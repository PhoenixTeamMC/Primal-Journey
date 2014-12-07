package phoenixTeam.event.map;

import phoenixTeam.event.Event;
import phoenixTeam.map.Map;

/**
 * @author Strikingwolf, chbachman
 */
public class OnTickEvent extends Event
{
    public Map map;

    public OnTickEvent(Map map) {this.map = map;}
}
