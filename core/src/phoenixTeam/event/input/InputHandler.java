package phoenixTeam.event.input;

import phoenixTeam.event.input.InputEvent.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {

	public static void init(){
		Gdx.input.setInputProcessor(new InputHandler());
	}

	@Override
	public boolean keyDown (int keycode) {
		new KeyDownEvent(keycode).callEvent();
		return true;
	}

	@Override
	public boolean keyUp (int keycode) {
		new KeyUpEvent(keycode).callEvent();
		return true;
	}

	@Override
	public boolean keyTyped (char character) {
		new KeyTypedEvent(character).callEvent();
		return true;
	}

	@Override
	public boolean touchDown (int x, int y, int pointer, int button) {
		new MouseDownEvent(x,y,pointer,button).callEvent();
		return true;
	}

	@Override
	public boolean touchUp (int x, int y, int pointer, int button) {
		new MouseUpEvent(x,y,pointer,button).callEvent();
		return true;
	}

	@Override
	public boolean touchDragged (int x, int y, int pointer) {
		new MouseDraggedEvent(x,y,pointer).callEvent();
		return true;
	}

	@Override
	public boolean mouseMoved (int x, int y) {
		new MouseMovedEvent(x,y).callEvent();
		return true;
	}

	@Override
	public boolean scrolled (int amount) {
		new ScrolledEvent(amount).callEvent();
		return true;
	}
}
