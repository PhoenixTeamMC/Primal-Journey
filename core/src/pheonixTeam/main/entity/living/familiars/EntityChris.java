package pheonixTeam.main.entity.living.familiars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pheonixTeam.main.Main;
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
    public EntityChris(Main main,EntityLiving entity) {
        super(main, entity);
        batch = new SpriteBatch();
        texture = new Texture("chris.png");
    }
}
