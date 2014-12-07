package phoenixTeam.entity.living.familiars;

import phoenixTeam.entity.living.EntityLiving;
import phoenixTeam.map.Map;

/**
 * @author Strikingwolf, chbachman
 */
public class EntityChris extends EntityFamiliar
{
    /**
     * Sets owner
     *
     * @param entity
     */
    public EntityChris(float x, float y, Map map, EntityLiving entity) {
        super(x, y, entity);
		moveSpeed = 1;
	}

	@Override
	public String getTextureLocation() {
		// TODO Auto-generated method stub
		return "chris.png";
	}
}
