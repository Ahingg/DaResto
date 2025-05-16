package state.waiter_state;

import model.Waiter;
import state.WaiterState;

public class IdleState  implements WaiterState{


	@Override
	public void reset(Waiter waiter) {
	}

	@Override
	public String getPrintFormat() {
		return "idle";
	}

	@Override
	public void changeState(WaiterState state) {
		
	}

}
