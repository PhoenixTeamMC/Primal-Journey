package pheonixTeam.main.util;

/**
 * Wrapper for Random Class
 * @author CBachman
 *
 */
public class Random {
	
	public java.util.Random random;
	
	public Random(){
		random = new java.util.Random();
	}
	
	public Random(long seed){
		random = new java.util.Random(seed);
	}
	
	public int nextInt(int limit){
		
		if(limit < 0){
			return -random.nextInt(-limit);
		}else if(limit == 0){
			return 0;
		}else{
			return random.nextInt(limit);
		}
		
		
	}
	
	public int nextInt(int lower, int upper){
		return nextInt(upper - lower) + lower;
	}
	
	public int variance(int number, int variance){
		return nextInt(-variance, variance) + number;
	}
	

}
