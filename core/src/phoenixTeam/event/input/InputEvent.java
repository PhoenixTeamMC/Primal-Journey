package phoenixTeam.event.input;

import phoenixTeam.event.Event;

public class InputEvent extends Event {

	public static class KeyDownEvent extends InputEvent{

		public final int keyCode;

		public KeyDownEvent(int keyCode){
			this.keyCode = keyCode;
		}

	}

	public static class KeyUpEvent extends InputEvent{

		public final int keyCode;

		public KeyUpEvent(int keyCode){
			this.keyCode = keyCode;
		}

	}
	
	public static class KeyTypedEvent extends InputEvent{

		public final char keyTyped;

		public KeyTypedEvent(char c){
			this.keyTyped = c;
		}

	}

	public static class MouseDownEvent extends InputEvent{

		public final int x;
		public final int y;
		public final int pointer;
		public final int button;
		
		public MouseDownEvent(int x, int y, int pointer, int button) {
			this.x = x;
			this.y = y;
			this.pointer = pointer;
			this.button = button;
		}

	}
	
	public static class MouseUpEvent extends InputEvent{

		public final int x;
		public final int y;
		public final int pointer;
		public final int button;
		
		public MouseUpEvent(int x, int y, int pointer, int button) {
			this.x = x;
			this.y = y;
			this.pointer = pointer;
			this.button = button;
		}

	}
	
	public static class MouseDraggedEvent extends InputEvent{

		public final int x;
		public final int y;
		public final int pointer;
		
		public MouseDraggedEvent(int x, int y, int pointer) {
			this.x = x;
			this.y = y;
			this.pointer = pointer;
		}

	}
	
	public static class MouseMovedEvent extends InputEvent{

		public final int x;
		public final int y;
		
		public MouseMovedEvent(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	
	public static class ScrolledEvent extends InputEvent{

		public final int amount;

		public ScrolledEvent(int amount){
			this.amount = amount;
		}

	}
	
	

}
