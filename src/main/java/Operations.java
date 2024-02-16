import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.InputMismatchException;
public class Operations {
    private static void calculate(short num1, short num2){
        // Вычисление и вывод результатов операций
        System.out.println("[RES] Сумма: " + (short) (num1 + num2));
        System.out.println("[RES] Разность: " + (short) (num1 - num2));
        System.out.println("[RES] Произведение: " + (short) (num1 * num2));

        if (num2 != 0) {
            System.out.println("[RES] Частное: " + (short) (num1 / num2));
            System.out.println("[RES] Остаток: " + (short) (num1 % num2));
        } else {
            System.out.println("Невозможно вычислить частное и остаток, так как второе число равно нулю.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите 2 значения от 0 до 65535 (для выхода введите любой символ)");
            try {
                // Ввод двух чисел в пределах от 0 до 65535
                System.out.print("[INPUT] Введите первое число: ");
                short num1 = (short) scanner.nextInt();

                System.out.print("[INPUT] Введите второе число: ");
                short num2 = (short) scanner.nextInt();
                calculate(num1,num2);
            } catch (InputMismatchException ex) {
                System.out.println("[INFO] Программа завершена.");
                break;
            }
        }
    }
}
