import java.util.ArrayList;

public class Library extends State{
	private Model model;
	
	public Library (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	

	@Override
	public String getDescription ()
	{
		return "You enter a humble but well cared for library.\n"
				+ "Countless book on esoteric theological subjects line\n"
				+ "the shelves. In the center of the room is a cluttered desk\n"
				+ "with paper strewn about the floor around it. What do you do?\n";
	}

	@Override
	public ArrayList<String> getOptions() 
	{
		ArrayList<String> options = new ArrayList<String>();
		options.add("Option 1: Investigate the desk");
		options.add("Option 2: Go back to entrance");
		return options;
	}

	@Override
	public void processChoice(int choice) 
	{
		switch (choice) 
		{
        case 1:  model.setCurrentState(StateType.Desk);
                 break;
        case 2:  model.setCurrentState(StateType.Entrance);
                 break;
		}	
	}
	
	
}
