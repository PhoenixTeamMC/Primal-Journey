package pheonixTeam.main.entity.living.familiars;

import pheonixTeam.main.entity.living.EntityLiving;

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
    public EntityChris(EntityLiving entity) {
        super(entity);
    }

	@Override
	public String getTextureLocation() {
		// TODO Auto-generated method stub
		return "chris.png";
	}
    
    
}
