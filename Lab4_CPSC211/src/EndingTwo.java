import java.util.ArrayList;

public class EndingTwo extends State{
	private Model model;
	
	public EndingTwo (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	
	@Override
	public String getDescription ()
	{
		return "In the end it seems your greed got the better of you;\n"
				+ "a stopwatch like this could make you filthy rich overight.\n"
				+ "I'm sure some other brave adventurer will help those people eventually.\n"
				+ "\nRight?\n\nENDING TWO: THE THIEF\n";
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
