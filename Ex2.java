package lesson_2nd_semester.week_11th;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2 {
    
    public static void main(String[] args) {
        int x = 0, y = 0, z = 0;
        
        System.out.print("정수 두개 입력 : ");
        
        
        try (Scanner input = new Scanner(System.in)) {
            x = input.nextInt();
            y = input.nextInt();
            z = x * y;
        } catch (InputMismatchException e) {
            throw e;
        } finally {
            input.close();
        }
        System.out.printf("%d * %d = %d %n", x, y, z);
    }
}
