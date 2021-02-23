public class Test {
    private int number;
    private static int[] numbers;
    private static int counter = 0;

    static {
        numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + i;
        }
        System.out.println("Static block");
    }

    {
        number = 3 + 11;
        System.out.println("Initialization block");
    }

    public Test() {

    }

    public Test(int number) {
        this.number += number;
        ++counter;
    }

    public void showNumber() {
        System.out.println(number);
    }

    public static void showNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();
    }

    public static void showCounter() {
        System.out.println(counter);
    }
}
