import java.util.Scanner;

public class NamePlayers 
{
    
    public NamePlayers()
    {
        //empty
    }

	public String player1Name()
	{
		String player1NameIn;
		Scanner in = new Scanner(System.in);
		System.out.print("\n\nEnter your username: ");
		player1NameIn = in.nextLine();
		return player1NameIn;
	}

	public String player2Name()
	{
        String player2NameIn;
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter the second person's username: ");
		player2NameIn = in.nextLine();
        return player2NameIn;
	}
}
