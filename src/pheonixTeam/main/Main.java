package pheonixTeam.main;

import java.awt.EventQueue;

import com.thoughtworks.xstream.XStream;

public class Main {

	public static XStream xml = new XStream();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
			}
		});
	}
}
