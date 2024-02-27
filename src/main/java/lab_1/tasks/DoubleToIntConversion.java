package lab_1.tasks;

public class DoubleToIntConversion {
    public static void main(String[] args) {
        double bigDoubleValue = Integer.MAX_VALUE * 2.0;

        // Попытка приведения к int
        int intValue = (int) bigDoubleValue;

        System.out.println("Double value: " + bigDoubleValue);
        System.out.println("Int value after conversion: " + intValue);
    }
}
