package phoenixTeam.map;

import phoenixTeam.map.simplex.SimplexNoise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class MapGenerator{

	public float[][] toRender;

	int maxHeight = 300;

	public MapGenerator() {

		SimplexNoise s = new SimplexNoise();

		int xResolution = 1000;
		int yResolution = 1000;

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

		int barrier = 20;
		
		//point *= 2;
		
		point += 3 * MathUtils.clamp(MathUtils.sin( (x - barrier) * MathUtils.PI / (xSize - (2 * barrier))), 0, 1);

		point += 3 * MathUtils.clamp(MathUtils.sin( (y - barrier) * MathUtils.PI / (ySize - (2 * barrier))), 0, 1);

		return point;
	}

	private float[][] transformGraph(float[][] points){

		return points;
	}

}
