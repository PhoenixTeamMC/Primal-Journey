package pheonixTeam.main.entity.living.player;

import java.util.List;

import pheonixTeam.main.Direction;
import pheonixTeam.main.Main;
import pheonixTeam.main.entity.enums.PrimaryClasses;
import pheonixTeam.main.entity.enums.Races;
import pheonixTeam.main.entity.enums.SecondaryClasses;
import pheonixTeam.main.entity.living.EntityLiving;
import pheonixTeam.main.entity.living.familiars.EntityFamiliar;
import pheonixTeam.main.entity.skills.Skill;
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
    public int mana = 20;

    public void switchHeldItemRight() {
        heldItemIndex++;
        heldItem = inventory.get(heldItemIndex);
    }

    public Item getHeldItem() {
        return inventory.get(heldItemIndex);
    }

    Main main;
    
    public EntityPlayer(Main main1) {
        main = main1;
        batch = new SpriteBatch();
        texture = new Texture("player.png");
        skills.add(new SkillFireball());
    }

    //Race
    public Races race = Races.NONE;

    //Class
    public PrimaryClasses primaryClass = PrimaryClasses.MAGE;
    public SecondaryClasses secondaryClass = SecondaryClasses.NONE;

    //Stats
    int constitution = 0;
    int strength = 0;
    int dexterity = 0;
    int wisdom = 0;

    //Skills
    //TODO

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
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && mana >= 20) {
            for (Skill skill : skills) {
                skill.doSkill(this);
            }
            mana -= 20;
        }

        if (map.time % 40 == 0) {
            mana += 5;
        }
        //main.camera.position.set(this.x, this.y, 0);
    }
}
