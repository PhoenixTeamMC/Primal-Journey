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
		return (int) (Math.random() * (upper - lower)) + lower;
	}
	
	public int variance(int number, int variance){
		int num = (int) (Math.floor(Math.random()*variance) + 1); // this will get a number between 1 and 99;
		num *= Math.floor(Math.random()*2) == 1 ? 1 : -1; // this will add minus sign in 50% of cases

		System.out.println(String.format("Original: %s. Final: %s", number, num + number));
		
		return num + number;
	}
	

}
