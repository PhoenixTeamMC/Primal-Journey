package phoenixTeam.map;

import phoenixTeam.map.simplex.SimplexNoise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;

public class MapGenerator{
	
	private final Array<ILayer> generators;
	private final Array<float[][]> map;

	private final SimplexNoise s;
	public final int size;
	
	public MapGenerator(int size) {

		s = new SimplexNoise();
		this.size = size;

		map = new Array<float[][]>();
		generators = new Array<ILayer>();
		
	}
	
	public void addLayer(ILayer layer){
		map.add(new float[size][size]);
		generators.add(layer);
	}
	
	public void generate(){
		for (int i = 0; i < generators.size; i++){
			for (int x = 0; x < size; x++){
				for (int y = 0; y < size; y++){
					map.get(i)[x][y] = generators.get(i).getPoint(s, x, y, size);
				}
			}
		}

		scale(0, 1);
		
		for (int i = 0; i < map.size; i++){
			map.set(i, generators.get(i).transformGraph(map.get(i)));
		}
	}

	public Color getColor(int x, int y){
		Color color = generators.get(0).colorPoints(x, y, size, map.get(0)[x][y], map.get(0));

		for (int i = 1; i < generators.size; i++){
			color.lerp(generators.get(i).colorPoints(x, y, size, map.get(i)[x][y], map.get(i)), 1);
		}
		
		return color;
	}

	private void scale(float min, float max){
		for (int g = 0; g < map.size; g++){

			float[][] toScale = map.get(g);

			float tmp = amplitude2(toScale) / (max - min);
			for (float[] item : toScale){
				for (int i = 0; i < item.length; i++){
					item[i] /= tmp;
				}
			}
			tmp = min - min(toScale);
			for (float[] item : toScale){
				for (int i = 0; i < item.length; i++){
					item[i] += tmp;
				}
			}
		}
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
