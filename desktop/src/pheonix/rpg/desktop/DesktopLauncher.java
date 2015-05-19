package pheonix.rpg.desktop;

import java.io.File;
import java.util.Arrays;

import phoenixTeam.PrimalJourney;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.out.println(Arrays.toString(arg));
		
		String location = new File(System.getProperty("user.dir")).getParent() + "/core/assets/data";
		//test
		if(arg.length != 0 && arg[0].equals("pack")){
			//TexturePacker.pr
		}
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.height = 1000;
		config.width = 1000;
		config.title = "Primal Journey";
		
		new LwjglApplication(new PrimalJourney(), config);
	}
}
