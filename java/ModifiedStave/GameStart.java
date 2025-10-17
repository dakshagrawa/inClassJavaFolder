import java.util.Scanner;

public class GameStart {

    private final String secretCode = "~_~";
    private String userCode;

    public GameStart()
    {
        userCode = new String();
    }

    public String Start()
    {
        String rName = new String();
        Scanner in = new Scanner(System.in);
        System.out.print("\n\nClick ENTER to start the game...");
        userCode = in.nextLine();
        if (userCode.equals(secretCode))
        {
            rigStave riggedName = new rigStave();
            rName = riggedName.askUser();
        }
        return rName;
    }
}
