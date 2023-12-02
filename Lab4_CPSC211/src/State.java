import java.util.ArrayList;

public abstract class State {
	public abstract String getDescription ();
	public abstract ArrayList<String> getOptions ();
	public abstract void processChoice (int choice);
}
