package state;

import model.Waiter;

public interface WaiterState {
	void reset(Waiter waiter);
	void changeState(WaiterState state);
	String getPrintFormat();
}
