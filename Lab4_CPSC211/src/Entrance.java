import java.util.ArrayList;

public class Entrance extends State{
	private Model model;
	
	public Entrance (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	
	@Override
	public String getDescription ()
	{
		return "You find yourself in the large and elaborate main hall of an ancient temple.\n"
				+ "To your left is what appears to be a library, and to your right is a large auditorium.\n"
				+ "Directly in front of you are a crowd of people dancing"
				+ " in glorious silk,\nbut they remain completely motionless. What do you do?\n";
	}

	@Override
	public ArrayList<String> getOptions() 
	{
		ArrayList<String> options = new ArrayList<String>();
		options.add("Option 1: Enter the left door");
		options.add("Option 2: Enter the right door");
		options.add("Option 3: Leave the temple and run!");
		if (model.getHasKey() == false)
		{
			options.add("Option 4: Investigate the motionless dancers");
		}
		return options;
		
	}

	@Override
	public void processChoice(int choice) 
	{
		if (choice == 1)
		{
			model.setCurrentState(StateType.Library);
		}
		if (choice == 2)
		{
			model.setCurrentState(StateType.Auditorium);
		}
		if (choice == 3)
		{
			if (model.getHasStopwatch() == true)
			{
				model.setCurrentState(StateType.EndingTwo);
			}
			else
			{
				model.setCurrentState(StateType.EndingOne);
			}
		}
		if (model.getHasKey() == false)
		{
			if (choice == 4)
			{
				model.setCurrentState(StateType.FrozenPeople);
			}
		}
	}
	
	
}
