package pheonixTeam.main;

import java.awt.Graphics;

public class Frame {
	
	public Frame(Map map){
		this.map = map;
	}
	
	Map map;
	
	public void paint(Graphics g){
		map.display(g);
	}

}
