package lab_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move_test() {
        Car car = new Car(10); // Создаем автомобиль с расходом топлива 10 км/л
        car = car.refuel(20); // Заполняем бак на 20 литров
        car = car.move(100); // Двигаем автомобиль на 100 км
        assertEquals(100, car.getDistance(), 0.01); // Проверяем пройденное расстояние
        assertEquals(10, car.getFuelLevel(), 0.01); // Проверяем уровень топлива после поездки
    }

    @Test
    void refuel_test() {
        Car car = new Car(10); // Создаем автомобиль с расходом топлива 10 км/л
        car = car.refuel(20); // Заполняем бак на 20 литров
        assertEquals(20, car.getFuelLevel(), 0.01); // Проверяем уровень топлива после заправки
    }

    @Test
    void get_distance_test_with_throwing_exception() {
        Car car = new Car(10); // Создаем автомобиль с расходом топлива 10 км/л
        assertThrows(IllegalStateException.class, () -> car.move(150)); //  Двигаем автомобиль на 150 км Проверяем пройденное расстояние
    }

    @Test
    void get_distance_test() {
        Car car = new Car(10, 10); // Создаем автомобиль с расходом топлива 10 км/л с 10 литрами топлива
        car = car.move(10);
        assertEquals(10, car.getDistance(), 0.01); //  Двигаем автомобиль на 10 км Проверяем пройденное расстояние
        car = car.move(10);
        assertEquals(20, car.getDistance(), 0.01); //  Двигаем автомобиль еще на 10 км Проверяем пройденное расстояние
    }

    @Test
    void get_fuel_level_test() {
        Car car = new Car(10, 10); // Создаем автомобиль с расходом топлива 10 км/л с 10 литрами топлива
        car = car.refuel(20); // Заполняем бак на 20 литров
        assertEquals(30, car.getFuelLevel(), 0.01); // Проверяем уровень топлива после заправки
    }
}
