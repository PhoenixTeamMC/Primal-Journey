package pheonixTeam.main.event.entity;

import pheonixTeam.main.event.Event;
import pheonixTeam.main.map.Map;

/**
 * @author Strikingwolf, chbachman
 */
public class NumPressedEvent extends Event
{
    public int num;

    public NumPressedEvent(int num) {
        this.num = num;
    }
}
