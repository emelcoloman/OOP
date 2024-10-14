package Lab2;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args){
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter second number: ");
        int num2 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter third number: ");
        int num3 = Integer.parseInt(sc.nextLine());
        sum = num1 + num2 + num3;

        System.out.println("The sum is: " + sum);
    }
}
