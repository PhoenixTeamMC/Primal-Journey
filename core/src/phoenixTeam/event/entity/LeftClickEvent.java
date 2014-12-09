package phoenixTeam.event.entity;

import phoenixTeam.event.Event;

/**
 * @author Strikingwolf, chbachman
 */
@Deprecated
public class LeftClickEvent extends Event
{
    public long time;

    @Deprecated
    public LeftClickEvent(long time){
        this.time = time;
    }
}
