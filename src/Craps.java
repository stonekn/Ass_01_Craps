import java.util.Random;
import java.util.Scanner;

public class Craps
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int dieOne = 0;
        int dieTwo = 0;
        int sum = 0;
        int point = 0;
        boolean rollingForPoint = false;
        String playAgain = "";

        do
        {
            // first roll of the game
            dieOne = rnd.nextInt(6) + 1;
            dieTwo = rnd.nextInt(6) + 1;
            sum = dieOne + dieTwo;
            System.out.println("\nYou rolled " + dieOne + " + " + dieTwo + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("Craps! You crapped out and lost.");
            }
            else if (sum == 7 || sum == 11)
            {
                System.out.println("Natural! You won.");
            }
            else
            {
                point = sum;
                System.out.println("The point is now " + point);
                rollingForPoint = true;

                // keep rolling until the point or a 7
                while (rollingForPoint)
                {
                    dieOne = rnd.nextInt(6) + 1;
                    dieTwo = rnd.nextInt(6) + 1;
                    sum = dieOne + dieTwo;
                    System.out.print("You rolled " + dieOne + " + " + dieTwo + " = " + sum + "  ");

                    if (sum == point)
                    {
                        System.out.println("Made point and won!");
                        rollingForPoint = false;
                    }
                    else if (sum == 7)
                    {
                        System.out.println("Got a seven and lost.");
                        rollingForPoint = false;
                    }
                    else
                    {
                        System.out.println("Trying for point " + point);
                    }
                }
            }

            System.out.print("\nDo you want to play again [Y/N]: ");
            playAgain = in.nextLine();

        } while (playAgain.equalsIgnoreCase("Y"));
    }
}