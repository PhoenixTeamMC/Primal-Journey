package phoenixTeam.component.render;

import com.badlogic.ashley.core.Component;

public class LoaderComponent extends Component{
	
	public LoaderComponent(String toLoad){
		this.toLoad = toLoad;
	}
	
	public String toLoad;
	public boolean hasStarted;
	
}
