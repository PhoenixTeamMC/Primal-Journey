package phoenixTeam.map;

import phoenixTeam.map.simplex.SimplexNoise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class HeightLayer implements ILayer{

	@Override
	public Color colorPoints(int x, int y, int size, float point, float[][] map){
		Color color = new Color(point, point, point, 1).clamp();

		if (point < .5){
			return Color.BLUE;
		}

		if (point > .9){
			return Color.WHITE;
		}

		if (point < .6){
			return Color.YELLOW;
		}

		color.lerp(Color.GREEN, .5F);

		return color;
	}

	@Override
	public float getPoint(SimplexNoise s, int x, int y, int size){
		float point = s.noise(x * 10F / size, y * 10F / size);

		point += 10 * s.noise(x * 5F / size, y * 5F / size);

		point += 20 * Math.min(MathUtils.clamp(MathUtils.sin(x * MathUtils.PI / (size - 100)), 0, 1), MathUtils.clamp(MathUtils.sin(y * MathUtils.PI / (size - 100)), 0, 1));

		point += 15 * MathUtils.clamp(MathUtils.sin(x * MathUtils.PI / (size - 100)), 0, 1);
		point += 15 * MathUtils.clamp(MathUtils.sin(y * MathUtils.PI / (size - 100)), 0, 1);

		return point;
	}

	@Override
	public float[][] transformGraph(float[][] points){
		return points;
	}

	@Override
	public Class<? extends ILayer>[] getDependencies(){
		return new Class[0];
	}

}
