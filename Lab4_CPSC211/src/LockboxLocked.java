import java.util.ArrayList;

public class LockboxLocked extends State{
	private Model model;
	
	public LockboxLocked (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	

	@Override
	public String getDescription ()
	{
		return "You attempt to pry the lockbox open with your bare hands,\n"
				+ "but it is of no use; It's sealed tight. What will you do?\n";
	}

	@Override
	public ArrayList<String> getOptions() 
	{
		ArrayList<String> options = new ArrayList<String>();
		options.add("Option 1: Go back to desk");
		return options;
	}

	@Override
	public void processChoice(int choice) 
	{
		switch (choice) 
		{
        case 1:  model.setCurrentState(StateType.Desk);
                 break;
		}	
	}
	
}
