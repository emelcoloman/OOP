package Lab2;
import java.util.Scanner;

public class T6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many times you want the message to be printed: ");
        int count = Integer.parseInt(sc.nextLine());
        PrintText(count);
    }
    public static void PrintText(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("In the beginning there were the swamp, the hoe and Java. \n ");
        }
    }
}
