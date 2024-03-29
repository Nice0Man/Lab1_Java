package lab_2;
import java.util.*;

import static java.util.Calendar.MONTH;

public class FirstNumber {
    public static void main(String[] args) {
        // Получаем экземпляр календаря и устанавливаем день недели на воскресенье (1)
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        // Получаем номер текущего месяца
        int currentMonth = calendar.get(MONTH);

        // Выводим заголовок таблицы календаря
        System.out.println("Sun Mon Tus Wed Thu Fri Sat");

        // Перебираем дни месяца
        while (calendar.get(MONTH) == currentMonth) {
            // Выводим день месяца
            System.out.printf("%3d ", calendar.get(Calendar.DAY_OF_MONTH));

            // Переходим к следующему дню
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            // Если текущий день - воскресенье (начало новой недели), добавляем перевод строки
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                System.out.println();
            }
        }
    }
}
