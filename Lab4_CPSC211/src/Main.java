import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	private HashMap<StateType, State> states = new HashMap<StateType, State> ();
	
	public static void main(String[] args) {
		Main m = new Main ();
		
		m.go ();
	}
	
	public void go ()
	{
		Model model = new Model();
		Scanner scanner = new Scanner(System.in);
		
		createStates(model);
		
		// Prompt the user if they want to load a previous game
		System.out.println("Load last saved game?");
		System.out.println("Option 1: Yes");
		System.out.println("Option 2: No");
		if (scanner.nextInt() == 1)
		{
			loadGame(model);
		}
		StateType currentStateType = model.getCurrentState();
		
		while (currentStateType != StateType.EndingOne || 
				currentStateType != StateType.EndingTwo || 
				 currentStateType != StateType.EndingThree)
		{
			State currentState = states.get(currentStateType);
			
			String description = currentState.getDescription();
			System.out.println(description);
			
			ArrayList<String> options = currentState.getOptions();
			
			// print out the options
			for (int i = 0; i < options.size(); i++)
			{
				System.out.println(options.get(i));
			}
			
			// add on an option to save the game
			System.out.println("Option 0: Save Game");
			int choice = scanner.nextInt();
			if (choice == 0)
			{
				saveGame(model);
			}
			
			// get the user's choice
			currentState.processChoice(choice);
			
			
			currentStateType = model.getCurrentState();
		}
	}
	
	public void createStates(Model model)
	{
		states.put(StateType.Entrance, new Entrance(model));
		states.put(StateType.Library, new Library(model));
		states.put(StateType.Auditorium, new Auditorium(model));
		states.put(StateType.Desk, new Desk(model));
		states.put(StateType.FrozenPeople, new FrozenPeople(model));
		states.put(StateType.Fountain, new Fountain(model));
		states.put(StateType.Note, new Note(model));
		states.put(StateType.Book, new Book(model));
		states.put(StateType.Lockbox, new Lockbox(model));
		states.put(StateType.LockboxUnlocked, new LockboxUnlocked(model));
		states.put(StateType.LockboxLocked, new LockboxLocked(model));
		states.put(StateType.EndingOne, new EndingOne(model));
		states.put(StateType.EndingTwo, new EndingTwo(model));
		states.put(StateType.EndingThree, new EndingThree(model));
	}
	
	public void saveGame(Model model)
	{
		File file = new File("save.dat");
		PrintWriter output = null;
		
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.out.println("Could not create save.dat");
			return;
		}
		
		if (model.getHasKey() == true)
		{
			output.println("1");
		}
		else
		{
			output.println("0");
		}
		if (model.getHasStopwatch() == true)
		{
			output.println("1");
		}
		else
		{
			output.println("0");
		}
		output.println(model.getCurrentState());
		System.out.println("Game Saved Successfully.\n");
		output.close();
	}
	
	public void loadGame(Model model)
	{
		File file = new File ("save.dat");
				
		Scanner input = null;
				
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Could not read save.dat");
			return;
		}
		
		if (input.nextLine().equals("1"))
		{
			model.setHasKey(true);
		}
		else
		{
			model.setHasKey(false);
		}
		if (input.nextLine().equals("1"))
		{
			model.setHasStopwatch(true);
		}
		else
		{
			model.setHasStopwatch(false);
		}
		StateType enumValue = StateType.valueOf(input.nextLine());
		model.setCurrentState(enumValue);
		System.out.println("Game Loaded Successfully.\n");
		
		input.close();
	}
}
