package pheonixTeam.main.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pheonixTeam.main.util.Random;

public class Layer implements Iterable<Integer>{
	
	public int[][] data;
	
	public final int width;
	public final int height;
	
	public Random random = new Random();
	
	public Layer(int width, int height){
		data = new int[width][height];
		this.width = width;
		this.height = height;
	}
	
	public void generate(int x, int y){
		if(this.isValid(x,y)){
			int average = this.averageOfAllAround(x, y);

			int newHeight = random.variance(average, getChange());

			this.set(x,y,newHeight);
		}
	}
	
	public int getMax(){
		return 50;
	}
	
	public int getMin(){
		return -50;
	}
	
	public int getChange(){
		return 3;
	}
	
	public int get(int width, int height){
		return data[width][height];
	}
	
	public int averageOfAllAround(int x, int y){
		return average(getAllAround(x,y));
	}
	
	public List<Integer> getAllAround(int x, int y){

		List<Integer> list = new ArrayList<Integer>(4);

		if(isValid(x,y + 1)){
			list.add(this.get(x, y + 1));
		}

		if(isValid(x,y - 1)){
			list.add(this.get(x,y - 1));
		}

		if(isValid(x + 1,y)){
			list.add(this.get(x + 1,y));
		}

		if(isValid(x - 1,y)){
			list.add(this.get(x - 1,y));
		}

		return list;
	}

	public boolean isValid(int x, int y){
		return x >= 0 && x < width && y >= 0 && y < height;
	}
	
	public int set(int width, int height, int data){
		int temp = this.data[width][height];
		
		if(data > this.getMax()){
			data = this.getMax();
		}else if(data < this.getMin()){
			data = this.getMin();
		}
		
		this.data[width][height] = data;
		return temp;
	}

	
	private static int average(List<Integer> ints){
		
		if(ints.isEmpty()){
			throw new RuntimeException();
		}
		
		int sum = 0;
		for(int i : ints){
			sum += i;
		}
		
		return sum / ints.size();
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
			layer.set(x,y,0);
		}
		
		
		
	}

}
