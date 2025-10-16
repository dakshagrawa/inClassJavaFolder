import java.util.Scanner;

public class rigStave {
    private String riggedNameInLowerCase;

    public rigStave()
    {
		riggedNameInLowerCase = "daksh";
    }

    public static void Main(String[] args)
    {
        rigStave rs = new rigStave();
        rs.askUser();
    }

    public String askUser()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\nYou are currently RIGGING the game (for MULTIPLAYER)!!!");
        System.out.print("Enter the rigged name {\"mu ha ha ha ha\" (evil laughter)}: ");
        riggedNameInLowerCase = in.nextLine();
        riggedNameInLowerCase = riggedNameInLowerCase.toLowerCase().strip();
        return riggedNameInLowerCase;
    }

    public boolean trueWinner(String p1, String p2, String rigName)
    {
        if (rigName == null || rigName.isEmpty() || rigName.equals("\n")) {
            // keep default value
        } else {
            riggedNameInLowerCase = rigName;
        }

        if (p1.toLowerCase().equals(riggedNameInLowerCase))
        {
            return true;
        }
        else if (p2.toLowerCase().equals(riggedNameInLowerCase))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String returnName()
    {
        return riggedNameInLowerCase;
    }
}
