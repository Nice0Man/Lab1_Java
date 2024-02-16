import java.util.Scanner;

public class NonASCIICharacters {
    private static void printNonASCIICharacters(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch > 127) {
                // Форматирование строки с добавлением нулей
                System.out.println("Символ: " + ch + ", Значение в Юникоде: " + String.format("\\u%04X", (int) ch));
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[INFO] Введите символьную строку (для выхода введите exit)");
        while (true) {
            // Ввод текстовой строки
            System.out.print("[INPUT] Введите текстовую строку: ");
            String inputString = scanner.nextLine();
            if ("exit".equalsIgnoreCase(inputString)) {
                System.out.println("[INFO] Программа завершена.");
                break;
            }
            // Вывод символов, не представленных в коде ASCII, и их значения в Юникоде
            System.out.println("Символы, не представленные в коде ASCII, и их значения в Юникоде.");
            printNonASCIICharacters(inputString);
        }
    }
}
