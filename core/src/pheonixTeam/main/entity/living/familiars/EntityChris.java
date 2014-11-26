package pheonixTeam.main.entity.living.familiars;

import pheonixTeam.main.entity.living.EntityLiving;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
        batch = new SpriteBatch();
        texture = new Texture("chris.png");
    }
}
