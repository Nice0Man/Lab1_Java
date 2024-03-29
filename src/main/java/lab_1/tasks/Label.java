package lab_1.tasks;

public class Label {
    public static void labelMethod(){
        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i * j > 6) {
                    System.out.println("Breaking outer loop");
                    break outer; // Прерывание внешнего цикла с меткой outer если значение больше 6
                }
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }
    public static void noLabelMethod(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i * j > 6) {
                    System.out.println("Breaking outer loop");
                    i = 5;
                    break; // Прерывание внешнего цикла с меткой если значение больше 6
                }
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }
    public static void main(String[] args) {
        labelMethod();
        System.out.println("----------------------------------------------------");
        noLabelMethod();
    }
}
