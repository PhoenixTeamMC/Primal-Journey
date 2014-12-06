package pheonix.rpg.desktop;

import phoenixTeam.Main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.height = 1000;
		config.width = 1000;
		
		new LwjglApplication(new Main(), config);
	}
}
