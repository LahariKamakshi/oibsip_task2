import java.util.*;
public class TaskGuess 
{
    static ArrayList<Integer> score = new ArrayList<Integer>();
    public static void main(String[] args) 
    {
        TaskGuess change = new TaskGuess();
        change.menu(score);
    }
    public void menu(ArrayList<Integer> score) 
    {
        TaskGuess change = new TaskGuess();
        Scanner in = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("Welcome to the number guessing game");
        System.out.println("--------------------------------------");
        System.out.println("1 Play the Game");
        System.out.println("2 Score Board");
        System.out.println("3 Exit the game");
        System.out.println("--------------------");
        try {
            System.out.print("Enter your choice: ");
            int userchoice = in.nextInt();
            switch (userchoice) {
                case 1:
                    System.out.print("\n"+"Enter your range:");
                    int numberRange = in.nextInt();
                    int generateRandomNumber = change.generateRandomNumber(numberRange);
                    change.guessUserNumber(generateRandomNumber);
                    break;
                case 2:
                    change.displayresult();
                    break;
                case 3:
                    System.out.println("\n"+"Thank you for playing the number guessing game");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.Can you please Try again later");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(score);
        }
    }
    public int generateRandomNumber(int numberRange)
    {
        Random random = new Random();
        int generateRandomNumber = random.nextInt(numberRange) + 1;
        return generateRandomNumber;
    }
    public void guessUserNumber(int generateRandomNumber) 
    {
        Scanner in = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        if(guess<=10)
        {
            do {
                System.out.print("Enter the number you guessed: ");
                userGuess = in.nextInt();
                guess++;
                if (userGuess > generateRandomNumber) 
                {
                    System.out.println("The number is Lower");
                } 
                else if (userGuess < generateRandomNumber) 
                {
                    System.out.println("The number is Higher");
                }
            } while (generateRandomNumber != userGuess);
        }
        System.out.println(" ");
        if (guess == 1) 
        {
            System.out.println("The guessed number is right in " + guess + " try!");
        }
        else if(guess>10)
        {
            System.out.println("Your try has exceeded");
            guess=11;
        }
        else 
        {
            System.out.println("The guessed number is right in " + guess + " tries!");
        }
        score.add(guess);
        System.out.println(" ");

        menu(score);
    }
    public void displayresult() 
    {
        System.out.println("-----------------------------------");
        System.out.println("RESULTS:");
        System.out.println("-----------------------------------");
        System.out.println("Your greatest score is: " +"\n");
        Collections.sort(score);
        for (Integer scores : score) {
            if(scores==11)
            {
                System.out.println("Your number of attempts exceeded");
            }
            else
            {
                System.out.println("Finished the number guessing game in " + scores + " tries");
            }
        }
        System.out.println(" ");
        menu(score);
    }
}
