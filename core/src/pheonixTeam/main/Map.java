package pheonixTeam.main;

import java.awt.Graphics;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import pheonixTeam.main.entity.Entity;

public class Map {
	
	public List<Entity> entityList = new CopyOnWriteArrayList<Entity>();
	public static Map getMap(File file){
		return (Map) Main.xml.fromXML(file);
	}
	
	public void onTick(){
		for(Entity entity: entityList){
			entity.update(this);
			
			if(entity.isDead){
				this.killEntity(entity);
			}
		}
	}
	
	public void spawnEntity(Entity entity){
		
		entity.onSpawn(this);
		
		entityList.add(entity);
	}
	
	public void killEntity(Entity entity){
		
		entity.onDeath(this);
		
		entityList.remove(entity);
	}
	
	public void display(Graphics g){
		
	}
}
