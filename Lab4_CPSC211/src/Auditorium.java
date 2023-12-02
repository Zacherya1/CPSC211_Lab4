import java.util.ArrayList;

public class Auditorium extends State{
	private Model model;
	
	public Auditorium (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	

	@Override
	public String getDescription ()
	{
		return "You enter an enormous auditorium full of tables lined with\n"
				+ "decadent meats and desserts. Ribbons and flowers adorn the brick walls.\n"
				+ "The centerpiece of the room is a large fountain spouting a curiously\n"
				+ "bright blue liquid. What do you do?\n";
	}

	@Override
	public ArrayList<String> getOptions() 
	{
		ArrayList<String> options = new ArrayList<String>();
		options.add("Option 1: Investigate the fountain");
		options.add("Option 2: Go back to entrance");
		return options;
	}

	@Override
	public void processChoice(int choice) 
	{
		switch (choice) 
		{
        case 1:  model.setCurrentState(StateType.Fountain);
                 break;
        case 2:  model.setCurrentState(StateType.Entrance);
                 break;
		}	
	}
	
}
