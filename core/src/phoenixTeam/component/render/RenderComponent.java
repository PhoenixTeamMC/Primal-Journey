package phoenixTeam.component.render;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import phoenixTeam.util.specific.LoadableComponent;

public class RenderComponent extends Component{
	
	public TextureRegion region;
	
	public float xSize;
	public float ySize;
	
	public Array<LoadableComponent<Texture>> toLoad = new Array<LoadableComponent<Texture>>();
}
