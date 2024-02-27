package lab_1.my_string;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public final class MyString{
    private byte[] stringByteArray;

    public byte[] getStringByteArray() {
        return stringByteArray;
    }
    public void setStringByteArray(byte[] ba) {
        this.stringByteArray = Arrays.copyOf(ba,ba.length);
    }

    public void setStringByteArray(ArrayList<byte[]> stringArrayList){
        for (int i = 0; i <stringArrayList.toArray().length ; i++) {

        }
    }
    public MyString() {
        this.stringByteArray = null;
    }
    public MyString(String s) {
        if (s == null){
            throw new NullPointerException("String is null!");
        }
        this.setStringByteArray(s.getBytes());
    }

    public int length(){
        return this.toByteArray().length;
    }

    public byte[] toByteArray() {
        return this.stringByteArray;
    }

    public MyString join(MyString delimiter, MyString... strings) {
        for (MyString str : strings) {
            this.stringArrayList.addLast(str.toByteArray());
            this.stringArrayList.addLast(delimiter.toByteArray());
        }
        // Удаляем последний добавленный разделитель
        if (strings.length > 0) {
            this.stringArrayList.removeLast();
        }
        return this;
    }
    public MyString join(String delimiter, String... strings) {
        this.stringArrayList = new ArrayList<byte[]>();
        for (String str : strings) {
            if (str != null){
                this.stringArrayList.addLast(str.getBytes());
                this.stringArrayList.addLast(delimiter.getBytes());
            }
        }
        // Удаляем последний добавленный разделитель
        if (strings.length > 0) {
            this.stringArrayList.removeLast();
        }
        this.setStringByteArray(stringArrayList);
        return this;
    }

    public MyString trim(){
        int startIndex = 0;
        int endIndex = this.length();
        while (startIndex < endIndex && this.stringByteArray[startIndex] == ' ') {
            startIndex++;
        }
        while (endIndex > startIndex && this.stringByteArray[endIndex - 1] == ' ') {
            endIndex--;
        }
        byte[] tmp = Arrays.copyOfRange(this.stringByteArray, startIndex, endIndex);
        this.setStringByteArray(tmp);
        return this;
    }

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
//    public MyString[] split(String regex) {
//        ArrayList<MyString> tmp;
//        for (int i = 0; i < this.length(); i++){
//            MyString s = this;
//
//        }
//    }
    @Override
    public String toString() {
        return new String(stringByteArray);
    }
    public boolean includeSymbol(char symbol) {
        for (int i = 0; i < this.length(); i++){
            if (this.getStringByteArray()[i] == symbol){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyString customString = new MyString("   Hello, World!   ");
        System.out.println("New String: " + customString);
        System.out.println("Trimmed String: " + customString.trim());

        customString.join("-", "Java", "is", "awesome");
        System.out.println("Joined String: " + customString);

//        String[] splitArray = customString.split("-");
//        System.out.println("Split String: " + Arrays.toString(splitArray));
        System.out.println("Joined String: " + customString.indexOf("-".getBytes()));

        byte[] byteArray = customString.toByteArray();
        System.out.println("String to ByteArray: " + Arrays.toString(byteArray));

        boolean includesSymbol = customString.includeSymbol('W');
        System.out.println("Includes symbol 'W': " + includesSymbol);
    }
}
