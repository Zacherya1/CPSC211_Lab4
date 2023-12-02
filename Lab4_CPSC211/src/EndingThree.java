import java.util.ArrayList;

public class EndingThree extends State{
	private Model model;
	
	public EndingThree (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	
	@Override
	public String getDescription ()
	{
		return "The stopwatch sinks into the blue liquid and begins to fizzle\n"
				+ "and hiss. Just as the liquid completely swallows the artifact,\n"
				+ "a awesome blast knocks you off your feet. You return to the entrance\n"
				+ "and find that the dancers are once again back in motion, gracefully\n"
				+ "gliding across the floor. It seems that all good deeds go unnoticed after all.\n"
				+ "\nENDING THREE: THE HERO\n";
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
