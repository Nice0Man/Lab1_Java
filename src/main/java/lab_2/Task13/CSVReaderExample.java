package lab_2.Task13;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class CSVReaderExample {
    public static void main(String[] args) throws Exception {
        // Проверяем, что передано имя файла в аргументах командной строки
        if (args.length == 0) {
            System.out.println("Usage: java CSVReaderExample <csv-file>");
            return;
        }

        // Получаем имя файла из аргументов командной строки
        String fileName = args[0];

        // Создаем объект CSVReader для чтения файла
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] nextLine;
            // Читаем и выводим каждую строку файла
            while ((nextLine = reader.readNext()) != null) {
                for (String value : nextLine) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }
}
