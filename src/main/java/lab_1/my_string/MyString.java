package lab_1.my_string;

import java.util.ArrayList;
import java.util.Arrays;

public final class MyString {
    private byte[] stringByteArray;

    // Конструкторы
    public MyString() {
        this.stringByteArray = new byte[0];
    }

    public MyString(byte[] ba) {
        this.setStringByteArray(ba);
    }

    public MyString(String s) {
        if (s == null) {
            throw new NullPointerException("String is null!");
        }
        this.setStringByteArray(s.getBytes());
    }

    // Методы для работы с массивом байтов
    public byte[] getStringByteArray() {
        return stringByteArray;
    }

    public void setStringByteArray(byte[] ba) {
        this.stringByteArray = Arrays.copyOf(ba, ba.length);
    }

    public void setStringByteArray(MyString s) {
        this.stringByteArray = Arrays.copyOf(s.getStringByteArray(), s.length());
    }

    // Основные операции со строками
    public int length() {
        return this.toByteArray().length;
    }

    public byte[] toByteArray() {
        return this.stringByteArray;
    }

    public boolean isEmpty() {
        return this.stringByteArray.length == 0;
    }

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

    // Операции поиска и обработки символов
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

    public MyString substring(int startIndex, int endIndex) {
        if (startIndex < 0 || startIndex >= this.length() || endIndex < 0 || endIndex > this.length() || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid startIndex or endIndex");
        }

        byte[] substringBytes = Arrays.copyOfRange(this.stringByteArray, startIndex, endIndex);

        MyString substring = new MyString();
        substring.setStringByteArray(substringBytes);
        return substring;
    }

    // Операции разделения строки
    public MyString[] split(char ch) {
        return split(ch, this.length());
    }

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

    // Преобразование в строку
    @Override
    public String toString() {
        return new String(this.stringByteArray);
    }

    // Проверка наличия символа в строке
    public boolean includeSymbol(char symbol) {
        for (int i = 0; i < this.length(); i++) {
            if (this.getStringByteArray()[i] == symbol) {
                return true;
            }
        }
        return false;
    }

    //  Метод сравнения
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyString myString = (MyString) obj;
        return Arrays.equals(stringByteArray, myString.stringByteArray);
    }

}
