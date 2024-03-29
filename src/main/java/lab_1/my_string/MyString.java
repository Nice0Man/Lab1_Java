package lab_1.my_string;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Объект класса <code>MyString</code> представляет пользовательскую строку
 * и предоставляет различные операции для работы с ней.
 *
 * <p>Класс MyString обеспечивает функциональность работы с текстовыми данными,
 * включая конкатенацию, обрезку, поиск символов, разделение строк и другие операции.
 * Данный класс является пользовательской реализацией работы со строками,
 * позволяя осуществлять разнообразные манипуляции с текстом.</p>
 *
 * @Автор: Eugene K.
 * @Версия: 1.0
 */

public final class MyString {
    private byte[] stringByteArray;

    // Конструкторы

    /**
     * Создает новый объект MyString с пустой последовательностью байтов.
     */
    public MyString() {
        this.stringByteArray = new byte[0];
    }

    /**
     * Создает новый объект MyString с указанной последовательностью байтов.
     *
     * @param ba Массив байтов, используемый для инициализации строки.
     * @throws NullPointerException если переданный массив байтов равен null.
     */
    public MyString(byte[] ba) {
        this.setStringByteArray(ba);
    }

    /**
     * Создает новый объект MyString с последовательностью байтов, полученной из строки s.
     *
     * @param s Строка, из которой извлекается последовательность байтов.
     * @throws NullPointerException если переданная строка s равна null.
     */
    public MyString(String s) {
        if (s == null) {
            throw new NullPointerException("String is null!");
        }
        this.setStringByteArray(s.getBytes());
    }

    /**
     * Возвращает массив байтов, представляющий текущий объект MyString.
     *
     * @return Массив байтов текущего объекта MyString.
     */
    public byte[] getStringByteArray() {
        return stringByteArray;
    }

    /**
     * Устанавливает последовательность байтов текущего объекта MyString из переданного массива байтов.
     *
     * @param ba Массив байтов, используемый для установки новой последовательности байтов.
     * @throws NullPointerException если переданный массив байтов равен null.
     */
    private void setStringByteArray(byte[] ba) {
        if (ba == null) {
            throw new NullPointerException("Byte Array is null!");
        }
        this.stringByteArray = Arrays.copyOf(ba, ba.length);
    }

    /**
     * Устанавливает последовательность байтов текущего объекта MyString из переданного объекта MyString.
     *
     * @param s Объект MyString, из которого извлекается последовательность байтов.
     * @throws NullPointerException если переданный объект MyString s равен null.
     */
    public void setStringByteArray(MyString s) {
        this.stringByteArray = Arrays.copyOf(s.getStringByteArray(), s.length());
    }

    /**
     * Возвращает длину строки в байтах.
     *
     * @return Длина строки в байтах.
     */
    public int length() {
        return this.toByteArray().length;
    }

    /**
     * Возвращает массив байтов, представляющий текущий объект MyString.
     *
     * @return Массив байтов текущего объекта MyString.
     */
    public byte[] toByteArray() {
        return this.stringByteArray;
    }

    /**
     * Проверяет, является ли строка пустой (не содержит байтов).
     *
     * @return true, если строка пуста, в противном случае - false.
     */
    public boolean isEmpty() {
        return this.stringByteArray.length == 0;
    }

    /**
     * Выполняет конкатенацию текущей строки с переданным объектом MyString.
     *
     * @param s Объект MyString, который конкатенируется с текущей строкой.
     * @return Новый объект MyString, представляющий результат конкатенации.
     * @throws NullPointerException если переданный объект MyString s равен null или является пустым.
     */
    public MyString concat(MyString s) {
        if (s == null || s.isEmpty()) {
            throw new NullPointerException("Cannot concatenate with a null or empty string.");
        }
        byte[] thisBytes = this.toByteArray();
        byte[] otherBytes = s.toByteArray();

        byte[] resultBytes = new byte[thisBytes.length + otherBytes.length];
        System.arraycopy(thisBytes, 0, resultBytes, 0, thisBytes.length);
        System.arraycopy(otherBytes, 0, resultBytes, thisBytes.length, otherBytes.length);

        return new MyString(resultBytes);
    }

    /**
     * Выполняет конкатенацию текущей строки с переданной строкой.
     *
     * @param s Строка, которая конкатенируется с текущей строкой.
     * @return Новый объект MyString, представляющий результат конкатенации.
     * @throws NullPointerException если переданная строка s равна null или является пустой.
     */
    public MyString concat(String s) {
        if (s == null || s.isEmpty()) {
            throw new NullPointerException("Cannot concatenate with a null or empty string.");
        }
        byte[] thisBytes = this.toByteArray();
        byte[] otherBytes = s.getBytes();

        byte[] resultBytes = new byte[thisBytes.length + otherBytes.length];
        System.arraycopy(thisBytes, 0, resultBytes, 0, thisBytes.length);
        System.arraycopy(otherBytes, 0, resultBytes, thisBytes.length, otherBytes.length);

        return new MyString(resultBytes);
    }

    /**
     * Выполняет конкатенацию строки с массивом строк, используя указанный разделитель.
     *
     * @param delimiter Разделитель, добавляемый между конкатенируемыми строками.
     * @param strings   Массив строк, который конкатенируется.
     * @return Новый объект MyString, представляющий результат конкатенации.
     */
    public MyString join(String delimiter, String... strings) {
        MyString result = new MyString();

        for (int i = 0; i < strings.length; i++) {
            MyString tmpStr = new MyString(strings[i]);
            if (!tmpStr.isEmpty()) {
                result = result.concat(tmpStr);

                if (i < strings.length - 1 && strings[i + 1] != null && !strings[i + 1].isEmpty()) {
                    result = result.concat(delimiter);
                }
            }
        }
        return result;
    }

    /**
     * Удаляет пробелы с начала и конца строки.
     *
     * @return Новый объект MyString, представляющий результат обрезки.
     */
    public MyString trim() {
        int startIndex = 0;
        int endIndex = this.length();
        while (startIndex < endIndex && this.stringByteArray[startIndex] == ' ') {
            startIndex++;
        }
        while (endIndex > startIndex && this.stringByteArray[endIndex - 1] == ' ') {
            endIndex--;
        }
        return new MyString(Arrays.copyOfRange(this.stringByteArray, startIndex, endIndex));
    }

    /**
     * Ищет первое вхождение заданной подстроки в текущей строке.
     *
     * @param target Подстрока, которую необходимо найти.
     * @return Индекс первого вхождения подстроки или -1, если подстрока не найдена.
     */
    public int indexOf(byte[] target) {
        for (int i = 0; i <= this.length() - target.length; i++) {
            boolean found = true;
            for (int j = 0; j < target.length; j++) {
                if (this.stringByteArray[i + j] != target[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i; // Возвращаем индекс, если подстрока найдена
            }
        }
        return -1; // Возвращаем -1, если подстрока не найдена
    }

    /**
     * Ищет первое вхождение заданного символа в текущей строке, начиная с указанного индекса.
     *
     * @param ch        Символ, который необходимо найти.
     * @param fromIndex Индекс, с которого начинается поиск.
     * @return Индекс первого вхождения символа или -1, если символ не найден.
     * @throws IndexOutOfBoundsException если переданный индекс fromIndex некорректен.
     */
    public int indexOf(char ch, int fromIndex) {
        if (fromIndex < 0 || fromIndex >= this.length()) {
            throw new IndexOutOfBoundsException("Invalid fromIndex");
        }

        for (int i = fromIndex; i < this.length(); i++) {
            if (this.getStringByteArray()[i] == ch) {
                return i; // Возвращаем индекс, если символ найден
            }
        }
        return -1; // Возвращаем -1, если символ не найден после fromIndex
    }

    /**
     * Возвращает подстроку текущей строки, начиная с заданного индекса и заканчивая указанным индексом.
     *
     * @param startIndex Индекс начала подстроки.
     * @param endIndex   Индекс конца подстроки.
     * @return Новый объект MyString, представляющий подстроку.
     * @throws IndexOutOfBoundsException если переданные индексы startIndex или endIndex некорректны.
     */
    public MyString substring(int startIndex, int endIndex) {
        if (startIndex < 0 || startIndex >= this.length() || endIndex < 0 || endIndex > this.length() || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid startIndex or endIndex");
        }

        byte[] substringBytes = Arrays.copyOfRange(this.stringByteArray, startIndex, endIndex);

        return new MyString(substringBytes);
    }

    /**
     * Разделяет текущую строку на подстроки по указанному символу.
     *
     * @param ch Символ, по которому производится разделение.
     * @return Массив объектов MyString, представляющих подстроки.
     */
    public MyString[] split(char ch) {
        return split(ch, this.length());
    }

    /**
     * Разделяет текущую строку на подстроки по указанному символу с ограничением количества подстрок.
     *
     * @param ch    Символ, по которому производится разделение.
     * @param limit Максимальное количество подстрок.
     * @return Массив объектов MyString, представляющих подстроки.
     */
    public MyString[] split(char ch, int limit) {
        int matchCount = 0;
        int off = 0;
        int next;
        boolean limited = limit > 0;
        ArrayList<MyString> list = new ArrayList<>();
        while ((next = indexOf(ch, off)) != -1) {
            if (!limited || matchCount < limit - 1) {
                list.add(substring(off, next));
                off = next + 1;
                ++matchCount;
            } else {    // last one
                int last = length();
                list.add(substring(off, last));
                off = last;
                ++matchCount;
                break;
            }
        }
        // If no match was found, return this
        if (off == 0)
            return new MyString[]{this};

        // Add remaining segment
        if (!limited || matchCount < limit)
            list.add(substring(off, length()));

        // Construct result
        int resultSize = list.size();
        if (limit == 0) {
            while (resultSize > 0 && list.get(resultSize - 1).isEmpty()) {
                resultSize--;
            }
        }
        MyString[] result = new MyString[resultSize];
        return list.subList(0, resultSize).toArray(result);
    }

    /**
     * Преобразует текущий объект MyString в строку.
     *
     * @return Строка, представляющая текущий объект MyString.
     */
    @Override
    public String toString() {
        return new String(this.stringByteArray);
    }

    /**
     * Проверяет наличие указанного символа в текущей строке.
     *
     * @param symbol Символ, наличие которого проверяется.
     * @return true, если символ присутствует в строке, в противном случае - false.
     */
    public boolean includeSymbol(char symbol) {
        for (int i = 0; i < this.length(); i++) {
            if (this.getStringByteArray()[i] == symbol) {
                return true;
            }
        }
        return false;
    }

    /**
     * Сравнивает текущий объект MyString с другим объектом.
     *
     * @param obj Объект, с которым производится сравнение.
     * @return true, если объекты равны, в противном случае - false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyString myString = (MyString) obj;
        return Arrays.equals(stringByteArray, myString.stringByteArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(stringByteArray);
    }
}