package pheonixTeam.main;

import java.awt.Graphics;
import java.util.List;

public class Frame {
	
	public Frame(Map map){
		this.map = map;
	}
	
	Map map;
	
	public void paint(Graphics g){
		List<Entity> list = map.entityList;
		
		for(Entity entity: list){
			entity.display(g);
		}
	}

}
