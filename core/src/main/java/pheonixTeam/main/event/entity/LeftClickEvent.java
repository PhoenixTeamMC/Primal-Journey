package pheonixTeam.main.event.entity;

import pheonixTeam.main.event.Event;

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
