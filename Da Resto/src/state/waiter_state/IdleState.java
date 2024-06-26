package state.waiter_state;

import model.Waiter;
import state.WaiterState;

public class IdleState  implements WaiterState{


	@Override
	public void reset(Waiter waiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPrintFormat() {
		// TODO Auto-generated method stub
		return "idle";
	}

	@Override
	public void changeState(WaiterState state) {
		// TODO Auto-generated method stub
		
	}

}
