package phoenixTeam.util;

import com.badlogic.gdx.math.MathUtils;

public class PerlinNoiseGenerator {
	
	public static float[][] generateWhiteNoise (int width, int height) {
		float[][] noise = new float[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				noise[x][y] = MathUtils.random();
			}
		}
		return noise;
	}

	public static float interpolate (float x0, float x1, float alpha) {
		return x0 * (1 - alpha) + alpha * x1;
	}

	public static float[][] generateSmoothNoise (float[][] baseNoise, int octave) {
		int width = baseNoise.length;
		int height = baseNoise[0].length;
		float[][] smoothNoise = new float[width][height];

		int samplePeriod = 1 << octave; // calculates 2 ^ k
		float sampleFrequency = 1.0f / samplePeriod;
		for (int i = 0; i < width; i++) {
			int sample_i0 = (i / samplePeriod) * samplePeriod;
			int sample_i1 = (sample_i0 + samplePeriod) % width; // wrap around
			float horizontal_blend = (i - sample_i0) * sampleFrequency;

			for (int j = 0; j < height; j++) {
				int sample_j0 = (j / samplePeriod) * samplePeriod;
				int sample_j1 = (sample_j0 + samplePeriod) % height; // wrap around
				float vertical_blend = (j - sample_j0) * sampleFrequency;
				float top = interpolate(baseNoise[sample_i0][sample_j0], baseNoise[sample_i1][sample_j0], horizontal_blend);
				float bottom = interpolate(baseNoise[sample_i0][sample_j1], baseNoise[sample_i1][sample_j1], horizontal_blend);
				smoothNoise[i][j] = interpolate(top, bottom, vertical_blend);
			}
		}

		return smoothNoise;
	}

	public static float[][] generatePerlinNoise (float[][] baseNoise, int octaveCount) {
		int width = baseNoise.length;
		int height = baseNoise[0].length;
		float[][][] smoothNoise = new float[octaveCount][][]; // an array of 2D arrays containing
		float persistance = 0.7f;

		for (int i = 0; i < octaveCount; i++) {
			smoothNoise[i] = generateSmoothNoise(baseNoise, i);
		}

		float[][] perlinNoise = new float[width][height]; // an array of floats initialised to 0

		float amplitude = 1.0f;
		float totalAmplitude = 0.0f;

		for (int octave = octaveCount - 1; octave >= 0; octave--) {
			amplitude *= persistance;
			totalAmplitude += amplitude;

			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					perlinNoise[i][j] += smoothNoise[octave][i][j] * amplitude;
				}
			}
		}

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				perlinNoise[i][j] /= totalAmplitude;
			}
		}

		return perlinNoise;
	}

	public static float[][] generatePerlinNoise (int width, int height, int octaveCount) {
		float[][] baseNoise = generateWhiteNoise(width, height);
		return generatePerlinNoise(baseNoise, octaveCount);
	}

	public static int[][] generateHeightMap (int width, int height, int min, int max, int octaveCount) {
		float[][] baseNoise = generateWhiteNoise(width, height);
		float[][] noise = generatePerlinNoise(baseNoise, octaveCount);
		
		int[][] output = new int[width][height];
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				output[y][x] = (int)(noise[y][x] * (max - min) + min);
			}
		}
		return output;
	}

}
