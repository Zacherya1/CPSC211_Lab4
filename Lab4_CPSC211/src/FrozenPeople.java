import java.util.ArrayList;

public class FrozenPeople extends State{
	private Model model;
	
	public FrozenPeople (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	

	@Override
	public String getDescription ()
	{
		return "Before you is a crowd of roughly 20 dancers, mysteriously\n"
				+ "standing still in time. On one of their waists you spot\n"
				+ "a small, elaborate key. What do you do?\n";
	}

	@Override
	public ArrayList<String> getOptions() 
	{
		ArrayList<String> options = new ArrayList<String>();
		options.add("Option 1: Take the key from their waist and step away");
		return options;
	}

	@Override
	public void processChoice(int choice) 
	{
		switch (choice) 
		{
        case 1: model.setHasKey(true); 
        		model.setCurrentState(StateType.Entrance);
                break;
		}	
	}
}