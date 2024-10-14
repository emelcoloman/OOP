package Lab2;
import java.util.Scanner;
public class T4 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int first = Integer.parseInt(sc.nextLine());
        System.out.print("Enter second number: ");
        int second = Integer.parseInt(sc.nextLine());
        if (first > second){
            System.out.println(first);
            System.out.println(second);
        }
        while (first <= second){
            System.out.println(first);
            first++;
            }
        }
    }
