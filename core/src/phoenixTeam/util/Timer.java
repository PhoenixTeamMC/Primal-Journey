package phoenixTeam.util;

import java.util.Deque;
import java.util.LinkedList;

public class Timer{
	
	final long timer;

	final String message;
	
	static Deque<Timer> staticTimer = new LinkedList<Timer>();
	
	public Timer(){
		this(System.currentTimeMillis(), "");
	}

	public Timer(long time){
		this(time, "");
	}

	public Timer(String message){
		this(System.currentTimeMillis(), message);
	}

	public Timer(long time, String message){
		this.timer = time;
		this.message = message;
	}
	
	public static void start(){
		staticTimer.push(new Timer());
	}

	public static void start(String message){
		staticTimer.push(new Timer(message));
	}
	
	public static void start(long time){
		staticTimer.push(new Timer(time));
	}
	
	public static void start(long time, String message){
		staticTimer.push(new Timer(time, message));
	}
	
	public static void stop(){
		
		if(staticTimer.isEmpty()){
			throw new IllegalStateException("Cannot stop without first starting.");
		}
		
		staticTimer.pop().end();
	}
	
	public void end(){
		System.out.println(message + " took " + (System.currentTimeMillis() - timer) / 1000F + " seconds.");
	}

}
