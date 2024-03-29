package lab_2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Класс для работы с произвольными числами.
 * Предоставляет методы для получения произвольного элемента из массива целых чисел или списка целых чисел.
 * Этот класс реализует паттерн Singleton.
 */
public class RandomNumbers {

    private static final Random random = new Random();
    private static RandomNumbers instance;

    // Приватный конструктор, чтобы предотвратить создание экземпляров класса
    private RandomNumbers() {}

    /**
     * Получает единственный экземпляр класса RandomNumbers.
     *
     * @return экземпляр класса RandomNumbers
     */
    public static RandomNumbers getInstance() {
        // Здесь нет возможности создания копий
        if (instance == null) instance = new RandomNumbers();
        return instance;
    }

    /**
     * Получает произвольный элемент из обычного массива целых чисел.
     *
     * @param array массив целых чисел
     * @return произвольный элемент массива или 0, если массив пуст
     */
    public static int randomElement(int[] array) {
        if (array == null || array.length == 0) {
            return 0; // Возвращаем 0, если массив пуст
        }
        return array[random.nextInt(array.length)];
    }

    /**
     * Получает произвольный элемент из списка целых чисел.
     *
     * @param list список целых чисел
     * @return произвольный элемент списка или 0, если список пуст
     */
    public static int randomElement(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0; // Возвращаем 0, если список пуст
        }
        return list.get(random.nextInt(list.size()));
    }
}
