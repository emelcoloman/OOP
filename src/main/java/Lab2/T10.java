import java.util.Scanner;

public class T10 {
    public static void main(String[] args){
        int count = 1, correct = 40;
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.print("Guess the number: ");
            int guess = Integer.parseInt(input.nextLine());

            if (guess > correct) {
                System.out.println("Lower! - This is your "+ count +". guess!");
                count++;
            } else if (guess < correct) {
                System.out.println("Higher! - This is your " + count + ". guess!");
                count++;
            } else {
                System.out.println("You are correct\nYou made "+ count +" guesses!");
                break;
            }
        }
    }
}