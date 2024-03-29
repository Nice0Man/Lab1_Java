package lab_2;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности класса RandomNumbers.
 */
class RandomNumbersTest {

    @Test
    void test_get_instance() {
        // Тестирование метода getInstance
        RandomNumbers instance1 = RandomNumbers.getInstance();
        RandomNumbers instance2 = RandomNumbers.getInstance();

        // Проверяем, что возвращается один и тот же экземпляр
        assertSame(instance1, instance2);
    }

    @Test
    void test_random_element() {
        // Тестирование метода randomElement для массива
        int[] array = {1, 2, 3, 4, 5};
        int result = RandomNumbers.randomElement(array);
        // Проверяем, что результат находится в пределах массива
        assertTrue(result >= 1 && result <= 5);
    }

    @Test
    void test_random_element_list() {
        // Тестирование метода randomElement для списка
        RandomNumbers instance = RandomNumbers.getInstance();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i * 10);
        }
        int result = RandomNumbers.randomElement(list);
        // Проверяем, что результат находится в пределах списка
        assertTrue(result >= 0 && result <= 100);
    }
}
