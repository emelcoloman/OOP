package Lab2;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args){
        String correct = "carrot";
        System.out.println("Enter a password: ");
        Scanner sc = new Scanner(System.in);
        while(true){
            String pass = sc.nextLine();
            if (pass.equals(correct)){
                System.out.println("Correct, secret is 'dasjdhawfAIl' ");
                break;
            }
            else{
                System.out.println("Try again: ");
            }
        }

    }
}
