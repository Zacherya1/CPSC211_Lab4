import java.util.ArrayList;

public class EndingOne extends State{
	private Model model;
	
	public EndingOne (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	
	@Override
	public String getDescription ()
	{
		return "You sprint out of the mysterious temple and don't look back.\n"
				+ "After all, who needs adventure when theres all the action you need\n"
				+ "in a programming textbook?\n\n"
				+ "ENDING ONE: THE COWARD\n";
	}

	@Override
	public ArrayList<String> getOptions() {
		ArrayList<String> options = new ArrayList<String>();
		options.add("Option 1: Quit Game");
		return options;
	}

	@Override
	public void processChoice(int choice) {
		if (choice == 1)
		{
			System.exit(0);
		}
		
	}
	
	
}