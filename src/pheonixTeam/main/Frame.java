package pheonixTeam.main;

import pheonixTeam.main.entity.Entity;

import java.awt.Graphics;
import java.util.List;

public class Frame {
	
	public Frame(Map map){
		this.map = map;
	}
	
	Map map;
	
	public void paint(Graphics g){
		map.display(g);
	}

}
