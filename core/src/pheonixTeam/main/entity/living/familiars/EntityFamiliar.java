package pheonixTeam.main.entity.living.familiars;

import com.badlogic.gdx.graphics.g2d.Batch;
import pheonixTeam.main.Direction;
import pheonixTeam.main.Main;
import pheonixTeam.main.entity.Entity;
import pheonixTeam.main.entity.living.EntityLiving;
import pheonixTeam.main.entity.living.player.EntityPlayer;
import pheonixTeam.main.map.Map;

/**
 * @author Strikingwolf, chbachman
 */
public class EntityFamiliar extends EntityLiving
{
    public EntityLiving owner;

    /**
     * Sets owner
     * @param entity
     */
    public EntityFamiliar(Main main, EntityLiving entity) {
        super();
        owner = entity;
        entity.familiars.add(this);
    }

    /**
     * Updates familiar and makes it move toward owner
     * @param map
     */
    @Override
    public void update(Map map) {
        super.update(map);
        moveToEntity(owner, -5, 0);
    }
}
