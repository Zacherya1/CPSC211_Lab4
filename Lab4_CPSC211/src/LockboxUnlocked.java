import java.util.ArrayList;

public class LockboxUnlocked extends State{
	private Model model;
	
	public LockboxUnlocked (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	

	@Override
	public String getDescription ()
	{
		return "You slide the key into the lock and hear a gentle *click*.\n"
				+ "You open the box to find an ornate Stopwatch nestled\n"
				+ "on top of fine velvet. It is engraved with symbols you \n"
				+ "don't quite understand. What do you do?\n";
	}

	@Override
	public ArrayList<String> getOptions() 
	{
		ArrayList<String> options = new ArrayList<String>();
		options.add("Option 1: Pick up the Stopwatch and return to desk");
		return options;
	}

	@Override
	public void processChoice(int choice) 
	{
		switch (choice) 
		{
        case 1: model.setHasStopwatch(true); 
        		model.setCurrentState(StateType.Desk);
                break;
		}	
	}
	
}
