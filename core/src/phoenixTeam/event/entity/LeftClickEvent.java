package phoenixTeam.event.entity;

import phoenixTeam.event.Event;

/**
 * @author Strikingwolf, chbachman
 */
public class LeftClickEvent extends Event
{
    public long time;

    public LeftClickEvent(long time){
        this.time = time;
    }
}
