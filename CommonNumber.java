import java.util.Arrays;

public class CommonNumber {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 6, 6, 7, 3, 2, 3, 3, 3, 3, 9, 9, 9, 9, 9, 4, 5, 7, 0 };
        CommonNumber m = new CommonNumber();

        m.showArray(numbers);
        System.out.println("The most common number is " + m.mostCommonNumber(numbers));
    }

    int mostCommonNumber(int[] array) {
        try {
            Arrays.sort(array);

            int maxCountedNumber = array[0];
            int previousNumber = array[0];
            int maxCount = 1;
            int count = 1;

            for (int i = 1; i < array.length; i++) {
                if (array[i] == previousNumber) {
                    count++;
                } else {
                    if (count > maxCount) {
                        maxCountedNumber = array[i - 1];
                        maxCount = count;
                    }
                    previousNumber = array[i];
                    count = 1;
                }
            }

            return maxCountedNumber;

        } catch(Exception e) {
            System.out.println("ERROR! " + e);
            return -9999999;
        }
    }

    void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}