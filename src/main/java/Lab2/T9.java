package Lab2;

import java.util.Scanner;

public class T9 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int row = Integer.parseInt(input.nextLine());
        drawStarsPiramid(row);
    }
    public static void drawStarsPiramid(int row){
        for (int i=1; i <= row; i++){
            for (int j=1; j <= i; j++){
                System.out.print(" "+j);
            }
            System.out.println();
        }
    }
}