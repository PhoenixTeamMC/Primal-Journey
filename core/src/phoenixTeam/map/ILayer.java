package phoenixTeam.map;

import com.badlogic.gdx.graphics.Color;
import phoenixTeam.map.simplex.SimplexNoise;

public interface ILayer{
	
	Class<? extends ILayer>[] getDependencies();
	
	Color colorPoints(int x, int y, int size, float point, float[][] map);
	
	float getPoint(SimplexNoise s, int x, int y, int size);
	
	float[][] transformGraph(float[][] points);

}
