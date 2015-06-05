package phoenixTeam.event;

public interface Cancellable {
	public boolean cancelled();

	public boolean cancel();
}
