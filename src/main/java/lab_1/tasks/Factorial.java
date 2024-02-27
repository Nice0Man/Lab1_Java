package lab_1.tasks;

import java.math.BigInteger;

public class Factorial {
    private static BigInteger calculate(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 1000;
        // Вычисление факториала с использованием класса BigInteger
        BigInteger factorial = calculate(n);

        System.out.printf("Факториал %d: ",n);
        System.out.println(factorial);
    }
}
