package phoenixTeam.map.simplex;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;

public class ImageWriter{
	// just convinence methods for debug

	public static Pixmap greyWriteImage(double[][] data){
		// this takes and array of doubles between 0 and 1 and generates a grey
		// scale image from them

		Pixmap p = new Pixmap(data.length, data[0].length, Format.RGBA8888);

		for (int y = 0; y < data[0].length; y++){
			for (int x = 0; x < data.length; x++){

				p.setColor((float) data[x][y], (float) data[x][y], (float) data[x][y], 1);
				p.drawPixel(x, y);
			}
		}

		// Pixmap p = new Pixmap(data.length, data[0].length, Format.RGB888);

		// p.getPixels().put()

		return p;
	}
}