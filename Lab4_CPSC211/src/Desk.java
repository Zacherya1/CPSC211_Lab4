import java.util.ArrayList;

public class Desk extends State{
	private Model model;
	
	public Desk (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	

	@Override
	public String getDescription ()
	{
		return "The desk is made of a fine mahogany and is covered\n"
				+ "in papers and books. One book sits open upon the\n"
				+ "table. You also see a small, barely legible note, and\n"
				+ "a ornately decorated lockbox sat squarely on the table.\n"
				+ "What do you do?\n";
	}

	@Override
	public ArrayList<String> getOptions() 
	{
		ArrayList<String> options = new ArrayList<String>();
		options.add("Option 1: Read the open book");
		options.add("Option 2: Read the messy note");
		options.add("Option 3: Go back to library");
		if (model.getHasStopwatch() == false)
		{
			options.add("Option 4: Investigate the lockbox");
		}
		return options;
	}

	@Override
	public void processChoice(int choice) 
	{
		switch (choice) 
		{
        case 1:  model.setCurrentState(StateType.Book);
                 break;
        case 2:  model.setCurrentState(StateType.Note);
                 break;
        case 3:  model.setCurrentState(StateType.Library);
                 break;
        case 4:  model.setCurrentState(StateType.Lockbox);
        break;
		}	
	}
	
}
