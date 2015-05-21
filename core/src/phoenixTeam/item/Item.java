package phoenixTeam.item;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;

/**
 * @author Strikingwolf, chbachman
 */
public abstract class Item<T extends Entity> {
	private String uName;
	private int rank;
	private int value;
	private double weight; //Weight in kilograms

	private Family componentsNeeded;

	public Item(String uName, int rank, int value, double weightKg, Family componentsNeeded) {
		this.uName = uName;
		this.rank = rank;
		this.value = value;
		this.componentsNeeded = componentsNeeded;
		this.weight = weightKg;
	}

	/**
	 * Called every tick for the entity. Will conform to components
	 * @param entity entity with components
	 */
	public abstract void tick(T entity);

	/**
	 * What happens when the entity uses the item
	 * @param entity entity using item
	 * @return whether the use of the item was successful
	 */
	public abstract boolean onUse(T entity);

	/**
	 * What happens when the entity swings the item
	 * @param entity entity swinging item
	 * @return whether the swing was successful
	 */
	public abstract boolean onSwing(T entity);

	/**
	 * What happens when the entity picks an item up
	 * @param entity entity picking up item
	 * @return whether the entity succeeded in picking the item up
	 */
	public abstract boolean onPickup(T entity);

	/**
	 * Gets the display name
	 * @return display name
	 */
	public abstract String getName();

	/**
	 * Gets the unlocalized Name
	 * @return unlocalized name
	 */
	public String getUName() {return uName;}

	/**
	 * Gets the rank of the item 1-7
	 * @return rank
	 */
	public int getRank() {return rank;}

	/**
	 * gets the value of the item in gold coins
	 * @return value
	 */
	public int getValue() {return value;}

	/**
	 * Gets the weight in kg of the item
	 * @return weightKg
	 */
	public double getWeightKg() {
		return weight;
	}

	/**
	 * Gets the weight in pounds of the item. 
	 * Only use for displaying, use kg for calculations. 
	 * @return weight in pounds
	 */
	public double getWeightLb() {
		return weight * 2.2;
	}

	public Family getFamily() {
		return componentsNeeded;
	}
}
