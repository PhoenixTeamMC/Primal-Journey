package phoenixTeam.event;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.utils.SnapshotArray;

/**
 * @author Strikingwolf
 */
public class SignalBase<T> extends Signal<T> {
	protected T obj;
	protected SnapshotArray<Listener<T>> listeners;
	protected SignalBase above;

	public SignalBase(SignalBase above) {
		listeners = new SnapshotArray<Listener<T>>();
		this.above = above;
	}

	@Override
	public void add(Listener<T> listener) {
		super.add(listener);
		if (above != null) {
			above.add(listener);
		}
	}

	@Override
	public void remove(Listener<T> listener) {
		super.remove(listener);
		if (above != null) {
			above.remove(listener);
		}
	}

	@Override
	public void dispatch(T object) {
		Object[] items = listeners.begin();
		for (int i = 0, n = listeners.size; i < n; i++) {
			Listener<T> listener = (Listener<T>) items[i];

			if (object instanceof Cancellable && ((Cancellable) object).cancelled()) {
				break;
			}

			listener.receive(this, object);
		}

		if (above != null) {
			above.dispatch(object);
		}

		listeners.end();
		obj = object;
	}

	public T dispatchWithResult(T object) {
		dispatch(object);
		return obj;
	}
}
