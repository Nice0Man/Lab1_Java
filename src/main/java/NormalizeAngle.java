import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.Math.floorMod;

public class NormalizeAngle {
    private  static  void normalize(int angle){
        // Нормализация с использованием операции %
        int normalizedAngleMod = (int)(angle % 360);
        System.out.println("Нормализованный угол (c %): " + normalizedAngleMod);

        // Нормализация с использованием метода floorMod()
        int normalizedAngleFloorMod = floorMod(angle, 360);
        System.out.println("Нормализованный угол (c floorMod()): " + normalizedAngleFloorMod);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите целочисленное значение угла (для выхода введите любой символ): ");
            try {
                int number = scanner.nextInt();
                normalize(number);
            } catch (InputMismatchException ex) {
                System.out.println("Программа завершена.");
                break;
            }
        }
    }
}
