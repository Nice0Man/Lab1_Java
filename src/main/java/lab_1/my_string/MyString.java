package lab_1.my_string;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public final class MyString{
    private byte[] stringByteArray;

    public byte[] getStringByteArray() {
        return stringByteArray;
    }
    public void setStringByteArray(byte[] ba) {
        this.stringByteArray = new byte[ba.length];
        System.arraycopy(ba,0,this.stringByteArray,0 ,ba.length);
    }
    public void setStringByteArray(MyString s) {
        this.stringByteArray = new byte[s.length()];
        System.arraycopy(s.getStringByteArray(),0,this.stringByteArray,0 ,s.length());
    }
    public MyString() {
        this.stringByteArray = new byte[0];
    }
    public MyString(String s) {
        if (s == null){
            throw new NullPointerException("String is null!");
        }
        this.setStringByteArray(s.getBytes());
    }
    public int length(){
        if (this.stringByteArray == null){
            throw new NullPointerException("Byte array is null!");
        }
        return this.toByteArray().length;
    }
    public byte[] toByteArray() {
        return this.stringByteArray;
    }
    public boolean isEmpty(){
        return this.stringByteArray.length == 0;
    }
    public MyString concat(MyString s){
        if (s == null || s.isEmpty()) {
            throw new NullPointerException("Cannot concatenate with a null string.");
        }
        byte[] thisBytes = this.toByteArray();
        byte[] otherBytes = s.toByteArray();

        byte[] resultBytes = new byte[thisBytes.length + otherBytes.length];
        System.arraycopy(thisBytes, 0, resultBytes, 0, thisBytes.length);
        System.arraycopy(otherBytes, 0, resultBytes, thisBytes.length, otherBytes.length);

        this.setStringByteArray(resultBytes);
        return this;
    }
    public MyString concat(String s){
        if (s == null || s.isEmpty()) {
            throw new NullPointerException("Cannot concatenate with a null string.");
        }
        byte[] thisBytes = this.toByteArray();
        byte[] otherBytes = s.getBytes();

        byte[] resultBytes = new byte[thisBytes.length + otherBytes.length];
        System.arraycopy(thisBytes, 0, resultBytes, 0, thisBytes.length);
        System.arraycopy(otherBytes, 0, resultBytes, thisBytes.length, otherBytes.length);

        this.setStringByteArray(resultBytes);
        return this;
    }
    public MyString join(String delimiter, String... strings) {
        MyString result = new MyString();

        for (int i = 0; i < strings.length; i++) {
            MyString tmpStr = new MyString(strings[i]);
            if (!tmpStr.isEmpty()){
                result.concat(tmpStr);

                if (i < strings.length - 1 && strings[i + 1] != null && !strings[i + 1].isEmpty()) {
                    result.concat(delimiter);
                }
            }
        }
        this.setStringByteArray(result);
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
        int length = endIndex - startIndex;
        byte[] tmpArray = new byte[length];
        System.arraycopy(this.stringByteArray, startIndex, tmpArray, 0, length);
        this.setStringByteArray(tmpArray);
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
        return new String(this.stringByteArray);
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
        System.out.println("New String: " + customString );
        System.out.println("Trimmed String: |" + customString.trim() + "|");

        customString.concat(" Java is awesome!");
        System.out.println("Concatenated String: " + customString);

        customString.join("-","JavaScript", "for", "kids!");
        System.out.println("Joined String: " + customString);
//        String[] splitArray = customString.split("-");
//        System.out.println("Split String: " + Arrays.toString(splitArray));

        byte[] byteArray = customString.toByteArray();
        System.out.println("String to ByteArray: " + Arrays.toString(byteArray));

        boolean includesSymbol = customString.includeSymbol('W');
        System.out.println("Includes symbol 'W': " + includesSymbol);
    }
}