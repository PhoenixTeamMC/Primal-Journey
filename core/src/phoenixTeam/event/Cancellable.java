package phoenixTeam.event;

public interface Cancellable extends Event {
	public boolean cancelled();

	public boolean cancel();
}
