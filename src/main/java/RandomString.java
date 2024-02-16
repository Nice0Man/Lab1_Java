import java.util.Random;
public class RandomString {
    private static long generateRandomLong() {
        Random random = new Random();
        return random.nextLong();
    }

    private static String convertToBase36(long value) {
        return Long.toString(value, 36);
    }
    public static void main(String[] args) {
        // Генерация произвольного значения типа long
        long randomLongValue = generateRandomLong();

        // Перевод значения в основание 36 и вывод
        String base36String = convertToBase36(randomLongValue);
        System.out.println("Произвольная символьная строка из букв и цифр: " + base36String);
    }
}
