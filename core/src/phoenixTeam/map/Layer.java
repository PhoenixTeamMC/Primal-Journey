package phoenixTeam.map;

import java.util.Iterator;

import phoenixTeam.util.PerlinNoiseGenerator;
import phoenixTeam.util.Random;

public class Layer implements Iterable<Integer>{
	
	public int[][] data;
	
	
	public final int width;
	public final int height; 
	
	public Random random = new Random();
	
	public int max = 50;
	public int min = -50;
	public int change = 5;
	
	public Layer(int width, int height){
		data = new int[width][height];
		this.width = width;
		this.height = height;
		
	}
	
	public void generate(){
		this.data = PerlinNoiseGenerator.generateHeightMap(width, height, min, max, 5);
	}
	
	public Layer setMax(int max){
		this.max = max;
		return this;
	}
	
	public Layer setMin(int min){
		this.min = min;
		return this;
	}
	
	public Layer setChange(int change){
		this.change = change;
		return this;
	}
	
	public int get(int width, int height){
		return data[width][height];
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new LayerIterator(this);
	}
	
	private class LayerIterator implements Iterator<Integer>{
		
		final Layer layer;
		
		final int xSize;
		final int ySize;
		
		int x;
		int y;
		
		public LayerIterator(Layer layer){
			this.layer = layer;
			
			xSize = layer.width;
			ySize = layer.height;
		}

		@Override
		public boolean hasNext() {
			return ySize != y && xSize != x;
		}

		@Override
		public Integer next() {
			
			int data = layer.get(x, y);
			
			x++;
			
			if(x == xSize){
				x = 0;
				y++;
			}
			
			return data;
			
		}

		@Override
		public void remove() {
			layer.data[x][y] = 0;
		}
		
		
		
	}

}
