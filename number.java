import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Write a description of class guess here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class guess
{
    private int maximum;
    private boolean hint;
    private String needHint;
    private int randomNumber;
    Scanner scanner = new Scanner(System.in);
    private int score;
    /**
     * Constructor for objects of class guess
     */
    public guess()
    {

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void guessNumber()
    {   
        randomNumber = randomNumber();
        boolean help = needHint();
        System.out.println("Score: " + score);
        System.out.println("I have sucessfully generated a random number from 1 to " + maximum + ". Now guess the number! (250 attempts)");
        for (int i = 0; i < 250; i++) {
            try {
                int guess = scanner.nextInt();
                if (i == 124 && help == true) {
                    if (randomNumber > 200 && randomNumber < 250) {
                        System.out.println("The random number is greater than 200, but less than 250");
                    }
                    if (randomNumber > 150 && randomNumber < 200) {
                        System.out.println("The random number is greater than 150, but less than 200");
                    } 
                    if (randomNumber > 100 && randomNumber < 150) {
                        System.out.println("The random number is greater than 100, but less than 150");
                    }
                    if (randomNumber > 50 && randomNumber < 100) {
                        System.out.println("The random number is greater than 50, but less than 100");
                    }
                    if (randomNumber < 50) {
                        System.out.println("The random number is less than 50");
                    } 
                }
                if (guess > maximum || guess < 1) {
                    System.out.println("That is out of range");
                    i--;
                }
                if (guess == randomNumber) {
                    System.out.println("Correct. The number was " + randomNumber + " in " + i + " attempts. Starting next round");
                    score++;
                    guessNumber();
                } else if (i < 249) {
                    System.out.println("Try again! Attempts: " + i);
                }
                if (i == 249) {
                    System.out.println("The random number was " + randomNumber);
                    score = 0;
                }
            } catch (InputMismatchException error) {
                scanner.next();
                System.out.println("Please enter an integer");
                i--;
            }
        }
    }

    public int randomNumber() {
        System.out.println("What would you like the maximum number to be? Pick a number between 1 and 250");
        try {
            maximum = scanner.nextInt();
            if (maximum > 250 || maximum < 1) {
                System.out.println("Pick a number between 1 and 250");
                randomNumber();
            }
        } catch (InputMismatchException error) {
            scanner.next();
            System.out.println("Please enter an integer");
            randomNumber();
        }
        int randomNumber = (int)(Math.random() * maximum) + 1;
        return randomNumber;
    }

    public boolean needHint() {
        System.out.println("Would you like to receive a hint on your 5th attempt? Yes or no");
        needHint = scanner.next();
        if (needHint.equals("Yes") || needHint.equals("yes")) {
            hint = true;
        } else if (needHint.equals("No") || needHint.equals("no")) {
            hint = false;
        } else {
            needHint();
        }
        return hint;
    }

    public static void main (String[] args) {
        guess theNumber = new guess();
        theNumber.guessNumber();
    }
}
