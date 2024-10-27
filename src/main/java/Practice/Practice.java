package Practice;
import java.util.Scanner;

public class Practice{
    public static void main(String[] args){
        printInvertedTable(1, 10, 3);
    }
    public static void printInvertedTable(int start, int end, int number){
        int k = 0;
        for (int i = end; i >= start; i--){
            System.out.println(i + " * " + number + " = " + (i * number));
        }
    }
}
