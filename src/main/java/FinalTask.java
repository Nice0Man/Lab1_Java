public class FinalTask {
    public static double average(double... values) {
        double sum = 0;
        for (double v : values) {
            sum += v;
        }

        // Если массив values не пустой, вычислить среднее значение, иначе вернуть 0
        return values.length > 0 ? sum / values.length : 0;
    }

    public static void main(String[] args) {
        double result1 = average(1, 2, 3, 4, 5);
        double result2 = average(7.5, 10.0, 15.0);
        double result3 = average(); // Теперь можно вызывать метод с одним параметром

        System.out.println("Среднее значение 1: " + result1);
        System.out.println("Среднее значение 2: " + result2);
        System.out.println("Среднее значение 3: " + result3);
    }
}
