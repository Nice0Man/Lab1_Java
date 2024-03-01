package lab_1.my_string;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyStringTest {

    @Test
    void testGetStringByteArray() {
        MyString myString = new MyString("Hello");
        assertArrayEquals("Hello".getBytes(), myString.getStringByteArray());
    }

    @Test
    void testSetStringByteArray() {
        MyString myString = new MyString();
        myString.setStringByteArray("Test".getBytes());
        assertThrows(NullPointerException.class, ()-> myString.setStringByteArray((byte[]) null));
        assertArrayEquals("Test".getBytes(), myString.getStringByteArray());
    }

    @Test
    void testSetStringByteArrayFromMyString() {
        MyString sourceString = new MyString("Hello");
        MyString myString = new MyString();
        myString.setStringByteArray(sourceString);
        assertArrayEquals("Hello".getBytes(), myString.getStringByteArray());
    }

    @Test
    void testLength() {
        MyString myString = new MyString("Hello");
        assertEquals(5, myString.length());
    }

    @Test
    void testToByteArray() {
        MyString myString = new MyString("Hello");
        assertArrayEquals("Hello".getBytes(), myString.toByteArray());
    }

    @Test
    void testIsEmpty() {
        MyString emptyString = new MyString();
        assertTrue(emptyString.isEmpty());

        MyString nonEmptyString = new MyString("Hello");
        assertFalse(nonEmptyString.isEmpty());
    }

    @Test
    void testConcat() {
        MyString myString = new MyString("Hello");
        myString = myString.concat(" World");
        assertEquals("Hello World", myString.toString());
    }

    @Test
    void testConcatWithNull() {
        MyString myString = new MyString("Hello");
        assertThrows(NullPointerException.class, () -> myString.concat((MyString) null));
    }

    @Test
    void testConcatWithString() {
        MyString myString = new MyString("Hello");
        myString = myString.concat(" World");
        assertEquals("Hello World", myString.toString());
    }

    @Test
    void testJoin() {
        MyString myString = new MyString();
        myString = myString.join("-", "Java", "is", "awesome");
        assertEquals("Java-is-awesome", myString.toString());
    }

    @Test
    void testTrim() {
        MyString myString = new MyString("   Hello, World!   ");
        myString = myString.trim();
        assertEquals("Hello, World!", myString.toString());
    }

    @Test
    void testIndexOf() {
        MyString myString = new MyString("Hello, World!");
        assertEquals(7, myString.indexOf("World".getBytes()));
        assertEquals(-1, myString.indexOf("Java".getBytes()));
    }

    @Test
    void testIndexOfWithOffset() {
        MyString myString = new MyString("Hello, World!");
        assertEquals(4, myString.indexOf('o', 0));
        assertEquals(-1, myString.indexOf('H', 6));
        assertThrows(IndexOutOfBoundsException.class,() -> myString.indexOf('o', 14));
    }

    @Test
    void testSubstring() {
        MyString myString = new MyString("Hello, World!");
        assertEquals("World", myString.substring(7, 12).toString());
    }

    @Test
    void testSplit() {
        MyString myString = new MyString("Java-is-awesome");
        MyString[] splitArray = myString.split('-');
        assertArrayEquals(new MyString[]{new MyString("Java"), new MyString("is"), new MyString("awesome")}, splitArray);
    }

    @Test
    void testToString() {
        MyString myString = new MyString("Hello, World!");
        assertEquals("Hello, World!", myString.toString());
    }

    @Test
    void testIncludeSymbol() {
        MyString myString = new MyString("Hello, World!");
        assertTrue(myString.includeSymbol('W'));
        assertFalse(myString.includeSymbol('Z'));
    }
}
