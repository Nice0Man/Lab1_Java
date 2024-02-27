package lab_1.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class LotteryCombinationGenerator {
    private static final short RANGE_EDGE = 49;
    private static final short LENGTH = 6;
    private static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= RANGE_EDGE; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static List<Integer> chooseLotteryCombination(List<Integer> numbers) {
        List<Integer> lotteryCombination = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(numbers.size());
            int chosenNumber = numbers.remove(randomIndex);
            lotteryCombination.add(chosenNumber);
        }

        Collections.sort(lotteryCombination);
        return lotteryCombination;
    }
    public static void main(String[] args) {
        List<Integer> numbers = generateNumbers();
        List<Integer> lotteryCombination = chooseLotteryCombination(numbers);

        System.out.println("Лотерейная комбинация: " + lotteryCombination);
    }
}
