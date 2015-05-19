package phoenixTeam.map.simplex;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import phoenixTeam.map.MapGenerator;

public class TestScreen implements Screen{

	private ShapeRenderer sr;

	MapGenerator m = new MapGenerator();
	private double[][] map;
	private float tileSize = 1;
	boolean drawGrid;

	public TestScreen() {
		this.map = m.toRender;
	}

	@Override
	public void render(float delta){
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sr.begin(ShapeType.Filled);
		drawMap(sr, map, 0, 0);
		// drawMap(sr, map, map.length * tileSize, 0);
		// drawMap(sr, map, 0, map[0].length * tileSize);
		// drawMap(sr, map, map.length * tileSize, map[0].length * tileSize);
		sr.end();

		if (drawGrid){
			sr.setColor(Color.GREEN);
			sr.begin(ShapeType.Line);
			for (int x = 0; x < map.length; x++)
				for (int y = 0; y < map[x].length; y++)
					sr.rect(x * tileSize, y * tileSize, tileSize, tileSize);
			sr.end();
		}
	}

	public void drawMap(ShapeRenderer sr, double[][] map2, float x, float y){
		if (sr.getCurrentType() != ShapeType.Filled){
			sr.end();
			sr.begin(ShapeType.Filled);
		}

		float v;
		for (int xi = 0; xi < map2.length; xi++)
			for (int yi = 0; yi < map2[xi].length; yi++){
				v = (float) map2[xi][yi];
				sr.setColor(m.colorPoints(xi, yi, map2.length, map2[xi].length, v));
				sr.rect(x + xi * tileSize, y + yi * tileSize, tileSize, tileSize);
			}
	}

	@Override
	public void resize(int width, int height){}

	@Override
	public void show(){
		sr = new ShapeRenderer();

		double min = min(map);
		double max = max(map);

		System.out.println("min: " + min + ", max: " + max);

		scale(map, 0, 1);

		min = min(map);
		max = max(map);
		System.out.println("min: " + min + ", max: " + max);
	}

	@Override
	public void hide(){}

	@Override
	public void pause(){}

	@Override
	public void resume(){}

	@Override
	public void dispose(){
		sr.dispose();
	}

	public static double[][] scale(double[][] items, double min, double max){
		double tmp = amplitude2(items) / (max - min);

		for (double[] item : items){
			for (int i = 0; i < item.length; i++){
				item[i] /= tmp;
			}
		}

		tmp = min - min(items);
		
		for (double[] item : items){
			for (int i = 0; i < item.length; i++){
				item[i] += tmp;
			}
		}
		
		return items;
	}

	public static double amplitude2(double[][] items){
		return max(items) - min(items);
	}

	public static double max(double[][] items){
		double max = Float.NEGATIVE_INFINITY;

		for (double[] item : items){
			for (double f : item){
				if (f > max)
					max = f;
			}
		}
		return max;
	}

	public static double min(double[][] items){
		double min = Float.POSITIVE_INFINITY;

		for (double[] item : items){
			for (double f : item){
				if (f < min)
					min = f;
			}
		}
		return min;
	}

}
