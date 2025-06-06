package state;

import model.Waiter;

public interface WaiterState extends State{
	void reset(Waiter waiter);
	void changeState(WaiterState state);
}
