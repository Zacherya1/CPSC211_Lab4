
public class Model {
	
	//Global variables
	private boolean hasKey = false;
	private boolean hasStopwatch = false;

	//Starting State
	private StateType currentState = StateType.Entrance;
	
	//Getters and Setters
	public StateType getCurrentState() {
		return currentState;
	}

	//Used by subclasses (states) to change states after a -
	//- choice is selected,but needs a reference to this model class
	public void setCurrentState(StateType currentState) {
		this.currentState = currentState;
	}

	public boolean getHasKey() {
		return hasKey;
	}

	public void setHasKey(boolean hasKey) {
		this.hasKey = hasKey;
	}

	public boolean getHasStopwatch() {
		return hasStopwatch;
	}

	public void setHasStopwatch(boolean hasStopwatch) {
		this.hasStopwatch = hasStopwatch;
	}
	
	
}
