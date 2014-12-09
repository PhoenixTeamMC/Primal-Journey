package phoenixTeam.entity.living.player;

import java.util.ArrayList;
import java.util.List;

import phoenixTeam.entity.enums.PrimaryClasses;
import phoenixTeam.entity.enums.Races;
import phoenixTeam.entity.enums.SecondaryClasses;
import phoenixTeam.entity.living.EntityLiving;
import phoenixTeam.entity.skills.SkillFireball;
import phoenixTeam.event.Subscribe;
import phoenixTeam.event.input.InputEvent.KeyTypedEvent;
import phoenixTeam.event.input.InputEvent.MouseDownEvent;
import phoenixTeam.item.Item;
import phoenixTeam.map.Map;
import phoenixTeam.util.Direction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;

/**
 * @author Strikingwolf, chbachman
 */
public class EntityPlayer extends EntityLiving
{
	//Held Item
	private int heldItemIndex = 0;
	public Item heldItem;

	//TODO: Are we going to have a infinite inventory? I don't know, but this is how it is for now
	public List<Item> inventory = new ArrayList<Item>();

	//Experience
	public int totalExp = 0;
	public int expLevel = 0;

	//Camera, for moving
	OrthographicCamera camera;

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

	public EntityPlayer(Map map, OrthographicCamera camera) {
		super(map.width/2, map.height/2);
		this.camera = camera;
		
		skills.add(new SkillFireball());
	}

	//Inventory
	public void switchHeldItemRight() {
		heldItemIndex++;
		heldItem = inventory.get(heldItemIndex);
	}

	public Item getHeldItem() {
		return inventory.get(heldItemIndex);
	}

	
	@Override
    public void display(Batch batch) {
        batch.draw(texture, x, y, 4, 4);
    }

    public static final float moveSpeed = 1;

    @Override
    public void update(Map map) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
        	camera.translate(1, 0);
           // this.move(Direction.RIGHT, moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        	camera.translate(-1, 0);
           // this.move(Direction.LEFT, moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
        	camera.translate(0, 1);
           // this.move(Direction.UP, moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
        	camera.translate(0, -1);
           // this.move(Direction.DOWN, moveSpeed);
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.O)){
        	camera.zoom += .02;
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.L)){
        	camera.zoom -= .02;
        }
        
        camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, 100/camera.viewportWidth);

        //float effectiveViewportWidth = camera.viewportWidth * camera.zoom;
        //float effectiveViewportHeight = camera.viewportHeight * camera.zoom;

        //camera.position.x = MathUtils.clamp(camera.position.x, effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f);
        //camera.position.y = MathUtils.clamp(camera.position.y, effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f);
        
        camera.update();

		if (map.time % 40 == 0) {
			mana += 5;
		}
		if (totalExp % 50 == 0) {
			expLevel++;
		}
    }

	@Override
	public String getTextureLocation() {
		return "player.png";
	}

	@Subscribe
	public void leftClick(MouseDownEvent event) {
		skills.get(skillWanted).doSkill(this);
	}

	public void right() {}

	@Subscribe
	public void onNumPressed(KeyTypedEvent event) {
		
		if(Character.isDigit(event.keyTyped)){
			
			int num = Character.getNumericValue(event.keyTyped);
			
			if (num != -1) {
				if (num < skills.size()) {
					skillWanted = num;
				}
			}
		}
		
		
	}
}
