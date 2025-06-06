package state;

import model.Customer;
public interface CustomerState extends State{
	void nextState(Customer state);
}
