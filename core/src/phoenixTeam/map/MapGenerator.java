package phoenixTeam.map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import phoenixTeam.map.simplex.SimplexNoise;

public class MapGenerator{

	public float[][] toRender;

	int maxHeight = 300;
	
	int islandWidth = 1000;

	public MapGenerator() {

		SimplexNoise s = new SimplexNoise();

		int xResolution = 5000;
		int yResolution = 5000;

		float[][] result = new float[xResolution][yResolution];

		for (int x = 0; x < xResolution; x++){
			for (int y = 0; y < yResolution; y++){
				result[x][y] = transformPoint(x, y, xResolution, yResolution, s.noise(x * .007F, y * .007F));
			}
		}

		toRender = transformGraph(result);

	}

	public Color colorPoints(int x, int y, int xSize, int ySize, float point){
		Color color = new Color(point, point, point, 1);

		if (point < .5){
			color = Color.BLUE;
		}

		return color;

	}

	private float transformPoint(int x, int y, int xSize, int ySize, float point){

		int barrier = 100;
		
		//point *= 2;
		
		point += 3 * MathUtils.clamp(MathUtils.sin( (x) * MathUtils.PI / (xSize - (2))), 0, 1);

		point += 3 * MathUtils.clamp(MathUtils.sin( (y) * MathUtils.PI / (ySize - (2))), 0, 1);

		return point;
	}

	private float[][] transformGraph(float[][] points){

		return points;
	}

}
