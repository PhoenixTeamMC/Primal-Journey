package pheonixTeam.main.entity;

import pheonixTeam.main.Map;

/**
 * @author Strikingwolf, chbachman
 */
public class EntityVoid extends Entity
{
    public EntityVoid() {

    }

    @Override
    public void update(Map map) {
        map.killEntity(this);
    }
}

