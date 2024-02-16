import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.Math.max;

public class MaxValue {
    private static final int COUNT = 3;
    private  static  void findMax(int[] num){
        // Нахождение максимального значения с использованием условной операции
        int maxNum = (num[0] > num[1]) ? ((num[0] > num[2]) ? num[0] : num[2]) : ((num[1] > num[2]) ? num[1] : num[2]);
        System.out.println("[RES] Самое большое число (с использованием условной операции): " + maxNum);

        // Нахождение максимального значения с использованием метода Math.max()
        int maxNumMax = Math.max(Math.max(num[0], num[1]), num[2]);
        System.out.println("[RES] Самое большое число (с использованием метода Math.max()): " + maxNumMax);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[INFO] Введите целое число (для выхода введите любой символ)");
            try {
                int[] numbers = new int[3];
                for (int i = 0; i < COUNT; i++){
                    System.out.printf("[INPUT] Введите %d-е целочисленное значение: ", i+1);
                    numbers[i] = scanner.nextInt();
                }
                findMax(numbers);
            } catch (InputMismatchException ex) {
                System.out.println("Программа завершена.");
                break;
            }
        }
    }
}
