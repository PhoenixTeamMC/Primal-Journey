package pheonixTeam.main.entity.living;

import java.util.List;

import pheonixTeam.main.Direction;
import pheonixTeam.main.entity.enums.PrimaryClasses;
import pheonixTeam.main.entity.enums.Races;
import pheonixTeam.main.entity.enums.SecondaryClasses;
import pheonixTeam.main.entity.skills.SkillFireball;
import pheonixTeam.main.item.Item;
import pheonixTeam.main.map.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Strikingwolf
 */
public class EntityPlayer extends EntityLiving
{
    private int heldItemIndex = 0;
    public Item heldItem;
    public List<Item> inventory;

    public void switchHeldItemRight() {
        heldItemIndex++;
        heldItem = inventory.get(heldItemIndex);
    }

    public Item getHeldItem() {
        return inventory.get(heldItemIndex);
    }

    SpriteBatch batch;
    Texture texture;

    public EntityPlayer() {
        batch = new SpriteBatch();
        texture = new Texture("player.png");
        skills.add(new SkillFireball());
    }

    //Race
    public Races race = Races.NONE;

    //Class
    public PrimaryClasses primaryClass = PrimaryClasses.NONE;
    public SecondaryClasses secondaryClass = SecondaryClasses.NONE;

    //Stats
    int constitution = 0;
    int strength = 0;
    int dexterity = 0;
    int wisdom = 0;

    //Skills
    //TODO

    @Override
    public void display(Batch batch) {
        batch.draw(texture, x, y, 4, 4);
    }

    public static final float moveSpeed = .2F;
    
    @Override
    public void update(Map map) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.move(Direction.RIGHT, moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.move(Direction.LEFT, moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.move(Direction.UP, moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.move(Direction.DOWN, moveSpeed);
        }
    }
}
