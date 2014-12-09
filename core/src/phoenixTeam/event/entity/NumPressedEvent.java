package phoenixTeam.event.entity;

import phoenixTeam.event.Event;

/**
 * @author Strikingwolf, chbachman
 */
@Deprecated
public class NumPressedEvent extends Event
{
    public int num;

    public NumPressedEvent(int num) {
        this.num = num;
    }
}
