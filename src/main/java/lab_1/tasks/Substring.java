package lab_1.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Substring {
    private static void printNonEmptySubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (!substring.isEmpty()) {
                    System.out.println(substring);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[INFO] Введите символьную строку (для выхода введите exit");
            try {
                System.out.print("[INPUT] Введите символьную строку: ");
                String inputString = scanner.nextLine();
                if ("exit".equalsIgnoreCase(inputString)) {
                    System.out.println("[INFO] Программа завершена.");
                    break;
                }
                printNonEmptySubstrings(inputString);

            } catch (InputMismatchException ex) {
                System.out.printf("[ERR] %s\n", ex);
                break;
            }
        }
    }
}
