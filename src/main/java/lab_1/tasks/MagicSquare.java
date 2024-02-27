package lab_1.tasks;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class MagicSquare {
    private int[][] matrix;
    private int size = 0;

    public MagicSquare(int[][] matrix, int size){
        this.matrix = matrix;
        this.size = size;
    }
    public MagicSquare(int[][] matrix){
        this(matrix, 3);
    }
    public int getSize(){
        return this.size;
    }
    public void setSize(int size){
        if (size <= 0){
            throw new InvalidParameterException("Size must be bigger then zero!");
        }
        this.size = size;
    }
    public int[][] getMatrix(){
        return this.matrix;
    }
    public void setMatrix(int size){
        if (size <= 0){
            throw new InvalidParameterException("Size must be bigger then zero!");
        }
        this.matrix = new int[size][size];
    }
    public void insertValuesInMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы двумерного массива (пустая строка для завершения):");
        int rowCount = 0;
        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine().trim();
            if (inputLine.isEmpty()) {
                break;
            }
            String[] values = inputLine.split("\\s+");
            if (values.length != this.size) {
                System.out.println("Некорректный ввод. Повторите ввод строки.");
                continue;
            }
            for (int i = 0; i < this.size; i++) {
                matrix[rowCount][i] = Integer.parseInt(values[i]);
            }
            rowCount++;
            if (rowCount == this.size) {
                break; // Прекратить ввод
            }
        }
    }
    private boolean checkMagicSquare() {
        // Проверка сумм строк
        int rowSum = 0;
        for (int i = 0; i < this.size; i++) {
            int currentRowSum = 0;
            for (int j = 0; j < this.size; j++) {
                currentRowSum += this.matrix[i][j];
            }
            if (rowSum == 0) {
                rowSum = currentRowSum;
            } else if (rowSum != currentRowSum) {
                return false;
            }
        }

        // Проверка сумм столбцов
        for (int j = 0; j < this.size; j++) {
            int columnSum = 0;
            for (int i = 0; i < this.size; i++) {
                columnSum += this.matrix[i][j];
            }
            if (columnSum != rowSum) {
                return false;
            }
        }

        // Проверка сумм диагоналей
        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        for (int i = 0; i < this.size; i++) {
            diagonalSum1 += this.matrix[i][i];
            diagonalSum2 += this.matrix[size - 1 - i][i];
        }
        return diagonalSum1 == rowSum && diagonalSum2 == rowSum;
    }
    public static void main(String[] args) {
        //https://ru.wikipedia.org/wiki/Магический_квадрат
        int [][] matr;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        int size = scanner.nextInt();
        matr = new int[size][size];
        MagicSquare ms = new MagicSquare(matr,size);
        ms.insertValuesInMatrix();
        if (ms.checkMagicSquare()) {
            System.out.println("Введенный массив - магический квадрат.");
        } else {
            System.out.println("Введенный массив не является магическим квадратом.");
        }
    }
}
