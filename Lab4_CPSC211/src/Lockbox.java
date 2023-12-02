import java.util.ArrayList;

public class Lockbox extends State{
	private Model model;
	
	public Lockbox (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	

	@Override
	public String getDescription ()
	{
		return "The lockbox is relatively small, but looks to be\n"
				+ "worth a fortune. What will you do?\n";
	}

	@Override
	public ArrayList<String> getOptions() 
	{
		ArrayList<String> options = new ArrayList<String>();
		options.add("Option 1: Open the lockbox");
		options.add("Option 2: Go back to desk");
		return options;
	}

	@Override
	public void processChoice(int choice) 
	{
		if (choice == 1)
		{
			if (model.getHasKey() == true)
			{
				model.setCurrentState(StateType.LockboxUnlocked);
			}
			else
			{
				model.setCurrentState(StateType.LockboxLocked);
			}
		}
		if (choice == 2)
		{
			model.setCurrentState(StateType.Desk);
		}
	}
	
}
