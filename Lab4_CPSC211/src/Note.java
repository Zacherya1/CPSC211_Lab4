import java.util.ArrayList;

public class Note extends State{
	private Model model;
	
	public Note (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	

	@Override
	public String getDescription ()
	{
		return "You lean forward to get a closer look at the\n"
				+ "small note. It reads:\n\n"
				+ "'I didn't want to have to do this, but you all left\n"
				+ "me no choice. If I can't have my Arthur for myself, no\n"
				+ "one will have him! If anyone ever finds this note - \n"
				+ "know that I did this out of love, and love alone.\n"
				+ "                           -Arthur's TRUE love, Lisa'\n";
		
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
