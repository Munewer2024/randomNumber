import java.util.Scanner;

/**
 * Write a description of class guess here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class guess
{
    private int maximum;
    Scanner scanner = new Scanner(System.in);

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
        int randomNumber = randomNumber();
        System.out.println("I have sucessfully generated a random number from 1 to " + maximum + ". Now guess the number! (10 attempts)");
        for (int i = 0; i < 10; i++) {
            int guess = scanner.nextInt();
            if (guess == randomNumber) {
                System.out.println("Correct. The number was " + randomNumber);
                break;
            } else {
                System.out.println("Try again!");
            }
            if (i == 9) {
                System.out.println("The random number was " + randomNumber);
            }
        }
    }
    public int randomNumber() {
        System.out.println("What would you like the maximum number to be?");
        maximum = scanner.nextInt();
        int randomNumber = (int)(Math.random() * maximum) + 1;
        return randomNumber;
    }
    public static void main (String[] args) {
        guess theNumber = new guess();
        theNumber.guessNumber();
    }
}
