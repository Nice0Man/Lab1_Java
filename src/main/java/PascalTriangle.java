import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle {
    private static ArrayList<ArrayList<Integer>> generatePascalTriangle(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    // Крайние элементы всегда равны 1
                    row.add(1);
                } else {
                    // Остальные элементы равны сумме двух предыдущих элементов в строке выше
                    int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(value);
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        int n = scanner.nextInt();// Заданная величина n
        ArrayList<ArrayList<Integer>> pascalTriangle = generatePascalTriangle(n);

        // Вывод треугольника Паскаля
        for (ArrayList<Integer> row : pascalTriangle) {
            System.out.println(row);
        }
    }
}
