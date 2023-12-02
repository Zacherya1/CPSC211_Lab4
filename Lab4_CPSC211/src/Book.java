import java.util.ArrayList;

public class Book extends State{
	private Model model;
	
	public Book (Model model)
	{
		//done so we can call model.setCurrentState or model.getCurrentState
		this.model = model;
	}
	

	@Override
	public String getDescription ()
	{
		return "The book is turned to a page on an ancient artifact:\na small stopwatch with the power to freeze time.\nSupposedly, once activated the effect can only be undone\nby destroying the artifact.\n";
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
