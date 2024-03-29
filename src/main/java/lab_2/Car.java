package lab_2;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

/**
 * Класс Car моделирует передвижение автомобиля на бензиновом топливе по оси x.
 */
@Data
public final class Car {
    private final double fuelConsumption;
    /**
     * -- GETTER --
     *  Возвращает уровень топлива в баке.
     *
     */
    @Getter
    private final double fuelLevel;
    /**
     * -- GETTER --
     *  Возвращает расстояние пройденное от начала координат.
     *
     */
    private final double distance;

    /**
     * Конструктор для создания объекта Car с заданным расходом топлива.
     *
     * @param fuelConsumption расход топлива автомобиля (в км/л)
     */
    public Car(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        this.distance = 0;
        this.fuelLevel = 0; // Изначально бак пуст
    }

    /**
     * Конструктор для создания объекта Car с заданным расходом топлива и уровнем топлива в баке.
     *
     * @param fuelConsumption расход топлива автомобиля (в км/л)
     * @param initialFuelLevel уровень топлива в баке (в литрах)
     *
     */
    public Car(double fuelConsumption, double initialFuelLevel) {
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = initialFuelLevel;
        this.distance = this.getDistance();
    }

    public Car(double fuelConsumption,double fuelLevel, double distance) {
        double fuelNeeded = distance / fuelConsumption;
        if (fuelNeeded > fuelLevel) {
            throw new IllegalStateException("Not enough fuel to cover the distance!");
        }
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
        this.distance = distance;
    }

    /**
     * Перемещает автомобиль на заданное расстояние.
     *
     * @param distance расстояние, на которое следует переместить автомобиль (в км)
     * @return новый объект Car с обновленным уровнем топлива
     * @throws IllegalStateException если уровень топлива недостаточен для перемещения на указанное расстояние
     */
    public Car move(double distance) {
        double fuelNeeded = distance / fuelConsumption;
        if (fuelNeeded > fuelLevel) {
            throw new IllegalStateException("Not enough fuel to cover the distance!");
        }
        return new Car(fuelConsumption, fuelLevel - fuelNeeded, getDistance() + distance);
    }

    /**
     * Заполняет топливный бак заданным количеством литров бензина.
     *
     * @param liters количество литров бензина для заправки
     * @return новый объект Car с обновленным уровнем топлива
     */
    public Car refuel(double liters) {
        return new Car(fuelConsumption, fuelLevel + liters);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(fuelConsumption, car.fuelConsumption) == 0 && Double.compare(fuelLevel, car.fuelLevel) == 0 && Double.compare(distance, car.distance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelConsumption, fuelLevel, distance);
    }

//    /**
//     * Возвращает расстояние, пройденное автомобилем от начала координат.
//     *
//     * @return расстояние, пройденное автомобилем (в км)
//     */
//    public double getDistance() {
//        return distance - fuelLevel + fuelConsumption;
//    }
}

