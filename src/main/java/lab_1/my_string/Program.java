package lab_1.my_string;

import java.util.Arrays;

public class Program {
    // Тестирование методов
    public static void main(String[] args) {
        MyString customString = new MyString("   Hello, World!   ");
        System.out.println("New String: " + customString);
        System.out.println("Trimmed String: |" + customString.trim() + "|");

        customString.concat(" Java is awesome!");
        System.out.println("Concatenated String: " + customString);

        customString.join("-", "JavaScript", "for", "kids!");
        System.out.println("Joined String: " + customString);

        MyString[] splitArray = customString.split('-');
        System.out.println("Split String: " + Arrays.toString(splitArray));

        byte[] byteArray = customString.toByteArray();
        System.out.println("String to ByteArray: " + Arrays.toString(byteArray));

        boolean includesSymbol = customString.includeSymbol('W');
        System.out.println("Includes symbol 'W': " + includesSymbol);
    }
}
