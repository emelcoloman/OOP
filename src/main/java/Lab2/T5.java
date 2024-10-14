package Lab2;
import java.util.Scanner;
public class T5 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a power: ");
        int power = Integer.parseInt(sc.nextLine());
        int num = (int)Math.pow(2,power);
        System.out.println(num);
    }
}
