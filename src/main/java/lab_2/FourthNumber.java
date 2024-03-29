package lab_2;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicInteger;

public class FourthNumber {
    public static void swapAtomicIntegers(@NotNull AtomicInteger a, @NotNull AtomicInteger b) {
        int temp = a.get();
        a.set(b.get());
        b.set(temp);
    }

    public static void main(String[] args) {
        AtomicInteger x = new AtomicInteger(5);
        AtomicInteger y = new AtomicInteger(10);

        System.out.println("Before swap: x = " + x + ", y = " + y);

        swapAtomicIntegers(x, y);

        System.out.println("After swap: x = " + x + ", y = " + y);
    }
}