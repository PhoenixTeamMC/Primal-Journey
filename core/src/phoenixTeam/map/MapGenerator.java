package phoenixTeam.map;

import phoenixTeam.map.simplex.SimplexNoise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class MapGenerator{

	public float[][] toRender; 

	private final SimplexNoise s;
	private final int size;
	
	public MapGenerator(int size) {
		
		s = new SimplexNoise();
		this.size = size;

		toRender = new float[size][size];

		for (int x = 0; x < size; x++){
			for (int y = 0; y < size; y++){
				toRender[x][y] = getPoint(x, y);
			}
		}
		
		
		
		scale(0, 1);
		
		//while(true){
		//	for(int i = 0; i < size; i++){
		//		if(result[i][0] < .5){
					
		//		}
		//	}
		//}
		
		

		toRender = transformGraph(toRender);

	}

	public Color colorPoints(int x, int y, int xSize, int ySize, float point, float[][] maps){
		Color color = new Color(point, point, point, 1).clamp();
		
		if (point < .5){
			return Color.BLUE;
		}
		
		if(point > .9){
			return Color.WHITE;
		}
		
		if(point < .6){
			return Color.YELLOW;
		}
		
		color.lerp(Color.GREEN, .5F);
		
		return color;

	}

	private float getPoint(int x, int y){
		
		float point = s.noise(x * 10F/size, y * 10F/size);
		
		point += 10 * s.noise(x * 5F/size, y * 5F/size);
		
		point += 20 * Math.min(MathUtils.clamp(MathUtils.sin(x * MathUtils.PI / (size - 100)), 0, 1),  MathUtils.clamp(MathUtils.sin(y * MathUtils.PI / (size - 100)), 0, 1));
		
		point += 15 * MathUtils.clamp(MathUtils.sin(x * MathUtils.PI / (size - 100)), 0, 1); 
		point += 15 * MathUtils.clamp(MathUtils.sin(y * MathUtils.PI / (size - 100)), 0, 1);
		
		return point;
	}

	private float[][] transformGraph(float[][] points){
		
		return points;
	}
	
	private float[][] scale(float min, float max){
		float tmp = amplitude2(toRender) / (max - min);

		for (float[] item : toRender){
			for (int i = 0; i < item.length; i++){
				item[i] /= tmp;
			}
		}

		tmp = min - min(toRender);

		for (float[] item : toRender){
			for (int i = 0; i < item.length; i++){
				item[i] += tmp;
			}
		}

		return toRender;
	}

	private static float amplitude2(float[][] items){
		return max(items) - min(items);
	}

	private static float max(float[][] items){
		float max = Float.NEGATIVE_INFINITY;

		for (float[] item : items){
			for (float f : item){
				if (f > max)
					max = f;
			}
		}
		return max;
	}

	private static float min(float[][] items){
		float min = Float.POSITIVE_INFINITY;

		for (float[] item : items){
			for (float f : item){
				if (f < min)
					min = f;
			}
		}
		return min;
	}

}
