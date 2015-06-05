package phoenixTeam.event;

/**
 * @author Strikingwolf
 */
public class CancellableBase implements Cancellable{
	public static final SignalBase<CancellableBase> signal = new SignalBase<CancellableBase>();

	protected boolean cancelled;

	@Override
	public boolean cancelled() {
		return this.cancelled;
	}

	@Override
	public boolean cancel() {
		this.cancelled = true;
		return true;
	}

}
