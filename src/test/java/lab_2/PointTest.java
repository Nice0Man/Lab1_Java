package lab_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @Test
    void test_get_x() {
        Point point = new Point(3, 4);
        assertEquals(3, point.getX());
    }

    @Test
    void test_get_y() {
        Point point = new Point(3, 4);
        assertEquals(4, point.getY());
    }

    @Test
    void test_translate() {
        Point point = new Point(3, 4);
        Point translatedPoint = point.translate(1, 3);
        assertEquals(new Point(4, 7), translatedPoint);
    }

    @Test
    void test_scale() {
        Point point = new Point(3, 4);
        Point scaledPoint = point.scale(0.5);
        assertEquals(new Point(1.5, 2), scaledPoint);
    }

    @Test
    void test_to_string() {
        Point point = new Point(3, 4);
        assertEquals("(3.0, 4.0)", point.toString());
    }

    @Test
    void test_main() {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        assertEquals(new Point(2.0, 3.5), p);
    }
}
