package phoenixTeam.component;

import com.badlogic.ashley.core.Component;

public class BoundingBoxComponent extends Component{
	
	public BoundingBoxComponent(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public float width;
	public float height;

}
