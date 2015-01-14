package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RenderComponent extends Component{
	public TextureRegion region;
	
	public float xSize;
	public float ySize;
	
	public RenderComponent(String name){
		this(new Texture(name));
	}
	
	public RenderComponent(Texture texture){
		this(new TextureRegion(texture));
	}
	
	public RenderComponent(TextureRegion region){
		this(region, -1, -1);
	}
	
	public RenderComponent(String name, float x, float y){
		this(new Texture(name), x, y);
	}
	
	public RenderComponent(Texture texture, float x, float y){
		this(new TextureRegion(texture),x,y);
	}
	
	public RenderComponent(TextureRegion region, float x, float y){
		this.region = region;
		this.xSize = x;
		this.ySize = y;
	}
}
