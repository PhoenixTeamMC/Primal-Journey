package pheonixTeam.main.entity.living.familiars;

import pheonixTeam.main.entity.living.EntityLiving;
import pheonixTeam.main.map.Map;

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
    }

	@Override
	public String getTextureLocation() {
		// TODO Auto-generated method stub
		return "chris.png";
	}
}
