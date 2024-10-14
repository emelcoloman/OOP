package Lab2;
import java.util.Scanner;
public class T8 {
    public static void main(String[] args) {
        System.out.println("Enter number of rows: ");
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        drawStarPyramid(rows);
    }
    public static void drawStarPyramid (int rows){
        for (int i = rows; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
