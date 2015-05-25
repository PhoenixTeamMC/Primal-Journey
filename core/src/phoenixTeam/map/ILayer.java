package phoenixTeam.map;

import phoenixTeam.map.simplex.SimplexNoise;

import com.badlogic.gdx.graphics.Color;

public interface ILayer{
	
	Color colorPoints(int x, int y, int size, float point, float[][] map);
	
	float getPoint(SimplexNoise s, int x, int y, int size);
	
	float[][] transformGraph(float[][] points);

}
