package phoenixTeam.event.input;

import com.badlogic.gdx.InputProcessor;
import phoenixTeam.PrimalJourney;
import phoenixTeam.event.input.InputEvent.KeyDownEvent;
import phoenixTeam.event.input.InputEvent.KeyTypedEvent;
import phoenixTeam.event.input.InputEvent.KeyUpEvent;
import phoenixTeam.event.input.InputEvent.MouseDownEvent;
import phoenixTeam.event.input.InputEvent.MouseDraggedEvent;
import phoenixTeam.event.input.InputEvent.MouseMovedEvent;
import phoenixTeam.event.input.InputEvent.MouseUpEvent;
import phoenixTeam.event.input.InputEvent.ScrolledEvent;

public class InputHandler implements InputProcessor {

	@Override
	public boolean keyDown (int keycode) {
		PrimalJourney.bus.post(new KeyDownEvent(keycode));
		return false;
	}

	@Override
	public boolean keyUp (int keycode) {
		PrimalJourney.bus.post(new KeyUpEvent(keycode));
		return false;
	}

	@Override
	public boolean keyTyped (char character) {
		PrimalJourney.bus.post(new KeyTypedEvent(character));
		return false;
	}

	@Override
	public boolean touchDown (int x, int y, int pointer, int button) {
		PrimalJourney.bus.post(new MouseDownEvent(x,y,pointer,button));
		return false;
	}

	@Override
	public boolean touchUp (int x, int y, int pointer, int button) {
		PrimalJourney.bus.post(new MouseUpEvent(x,y,pointer,button));
		return false;
	}

	@Override
	public boolean touchDragged (int x, int y, int pointer) {
		PrimalJourney.bus.post(new MouseDraggedEvent(x,y,pointer));
		return false;
	}

	@Override
	public boolean mouseMoved (int x, int y) {
		PrimalJourney.bus.post(new MouseMovedEvent(x,y));
		return false;
	}

	@Override
	public boolean scrolled (int amount) {
		PrimalJourney.bus.post(new ScrolledEvent(amount));
		return false;
	}
}
