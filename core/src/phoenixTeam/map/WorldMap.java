package phoenixTeam.map;

import phoenixTeam.PrimalJourney;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * 
 * @author chbachman
 *
 */
public class WorldMap{
	
	public TiledMap map;
	public OrthogonalTiledMapRenderer renderer;
	
	public final int width;
	public final int height;

	
	public WorldMap(int width, int height){
		map = new TiledMap();
		renderer = new OrthogonalTiledMapRenderer(map, 1F/16);
		
		map.getLayers().add(new TiledMapTileLayer(width, height, 16, 16));
		
		new MapGenerator();
		
		this.width = width;
		this.height = height;
		
	}
	
	public void display(){
		renderer.setView(PrimalJourney.camera);
		renderer.render();
	}
}
