package Lab2;
import java.util.Scanner;
public class T3 {
    public static void main(String [] args){
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter number: ");
            int n = Integer.parseInt(sc.nextLine());
            sum = sum + n;
            System.out.println("Sum: " + sum);
            if (n==0){
                break;
            }
        }
    }
}
