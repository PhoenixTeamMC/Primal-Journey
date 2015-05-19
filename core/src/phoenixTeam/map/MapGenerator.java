package phoenixTeam.map;

import com.badlogic.gdx.graphics.Color;
import phoenixTeam.map.simplex.SimplexNoise;

public class MapGenerator{

	public double[][] toRender;

	int maxHeight = 300;

	public MapGenerator() {

		SimplexNoise s = new SimplexNoise();

		int xResolution = 1000;
		int yResolution = 1000;

		double[][] result = new double[xResolution][yResolution];

		for (int x = 0; x < xResolution; x++){
			for (int y = 0; y < yResolution; y++){
				result[x][y] = transformPoint(x, y, xResolution, yResolution, s.noise(x * .007, y * .007));
			}
		}

		toRender = result;

	}

	public Color colorPoints(int x, int y, int xSize, int ySize, double point){
		Color color = new Color((float) point, (float) point, (float) point, 1);

		if (point < .5){
			color = Color.BLUE;
		}

		return color;

	}

	private double transformPoint(int x, int y, int xSize, int ySize, double point){

		point += 3 * Math.sin(x * Math.PI / xSize);

		point += 3 * Math.sin(y * Math.PI / ySize);

		return point;
	}

	private double[][] transformGraph(double[][] points){

		return points;
	}

}
