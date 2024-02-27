package lab_1.tasks;

public class MinMaxDoubleValues {
    public static void main(String[] args) {
        double smallestDouble = Math.nextUp(0.0); // Наименьшее положительное значение
        double largestDouble = Double.MAX_VALUE; // Наибольшее положительное значение

        System.out.println("Наименьшее положительное значение double: " + smallestDouble);
        System.out.println("Наибольшее положительное значение double: " + largestDouble);
    }
}
