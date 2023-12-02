import java.util.ArrayList;

public class Fountain extends State{
	private Model model;
	
	public Fountain (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	
	@Override
	public String getDescription ()
	{
		return "Upon moving closer to the fountain, you immediately feel the\n"
				+ "unmistakable pulse of magic - powerful magic. You get the sense\n"
				+ "that if something were to fall in, it wouldn't be coming back out.\n"
				+ "What do you do?\n";
	}

	@Override
	public ArrayList<String> getOptions() 
	{
		ArrayList<String> options = new ArrayList<String>();
		options.add("Option 1: Go back to Auditorium");
		if (model.getHasStopwatch() == true)
		{
			options.add("Option 2: Throw Stopwatch into fountain");
		}
		return options;
	}

	@Override
	public void processChoice(int choice) 
	{
		if (choice == 1)
		{
			model.setCurrentState(StateType.Auditorium);
		}
		if (choice == 2)
		{
			if (model.getHasStopwatch() == true)
			{
				model.setCurrentState(StateType.EndingThree);
			}
		}
	}
	

}
