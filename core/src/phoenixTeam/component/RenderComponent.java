package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RenderComponent extends Component{
	public TextureRegion region;
	
	public RenderComponent(String name){
		this(new Texture(name));
	}
	
	public RenderComponent(Texture texture){
		this(new TextureRegion(texture));
	}
	
	public RenderComponent(TextureRegion region){
		this.region = region;
	}
}
