package Lab2;
import java.util.Scanner;
public class T7 {
    public static void main(String[] args) {
        System.out.println("Enter number of rows: ");
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        drawStarPyramid(rows);
    }
    public static void drawStarPyramid (int rows){
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
