package lab_1.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberConversion {
    private static void conversion(int number){
        // Вывод числа в двоичной, восьмеричной и шестнадцатеричной форме
        System.out.println("Двоичное представление: " + Integer.toBinaryString(number));
        System.out.println("Восьмеричное представление: " + Integer.toOctalString(number));
        System.out.println("Шестнадцатеричное представление: " + Integer.toHexString(number));

        // Вывод обратного значения в виде шестнадцатеричного числа с плавающей точкой
        float reversedNumber = 1.0f / number;
        System.out.println("Обратное значение в виде шестнадцатеричного числа с плавающей точкой: " + Float.toHexString(reversedNumber));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите целое число (для выхода введите любой символ): ");
            try {
                int number = scanner.nextInt();
                conversion(number);
            } catch (InputMismatchException ex) {
                System.out.println("Программа завершена.");
                break;
            }
        }
    }
}
