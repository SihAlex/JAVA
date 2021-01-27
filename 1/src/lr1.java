import java.util.InputMismatchException;
import java.util.Scanner;

public class lr1 {
    // 3 Створіть метод, який дозволяє вставляти в будь яку позицію масиву будь яке число. Метод повинен повертати новий масив.
    public static int[] arrayPaste(int[] array) {
        var result = array;
        int number, index;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter your number: ");
                number = scanner.nextInt();
                System.out.print("Where do you want to place your number?: ");
                index = scanner.nextInt();
                result = paste(array, number, index);
            } catch (InputMismatchException valueException) {
                System.err.println("Wrong input! Enter an integer!");
                result = null;
                number = 0;
            } catch (ArrayIndexOutOfBoundsException arrayException) {
                System.err.println("Wrong index! Enter a proper one!");
                result = null;
                index = 0;
            }
        } while (result == null);
        return result;
    }

    public static int[] paste(int[] array, int number, int index) {
        int[] new_array = new int[array.length + 1];
        for (int i = 0, j = 0; j < new_array.length; i++, j++) {
            new_array[j] = array[i];
            if (i == index) {
                new_array[index] = number;
                i--;
                index = -9;
            }
        }
        return new_array;
    }
    /*
    // 12  Створіть метод, який сортує будь який масив int[] методом вставок.
    public static void arraySort(int[] array) {
        var key = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < key) {
                for (int j = i; j > 0; j--) {
                    if(array[j] < array[j-1]) {
                        swapElements(array, j);
                    }
                }
            }
            key = array[i];
        }
    }
    */
    public static void arraySort(int[] array) {
        var key = 0;
        for (int i = 0; i < array.length; i++) {
            key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j + 1] = key;
        }
    }

    // 27 Створіть метод, який приймає параметр int та конвертує його з десятичної у восьмирічну систему числення та повертає у вигляді String.
    public static String decToOct(int num) {
        String result = "";
        boolean negative = false;
        if (num < 0) negative = true;
        int modulo = 0;
        while (num != 0) {
            modulo = num % 8;
            result += modulo;
            num /= 8;
        }
        if (negative) result += 1;
        else result += 0;
        return new StringBuilder(result).reverse().toString();
    }

    // 29 Створіть метод, який приймає будь-яку кількість масивів int[] та повертає найменше число яке є у складі цих масивів.
    public static int minNumber(int[]... array) {
        if (array == null) {
            System.out.println("No arrays are given!");
            return -999;
        }

        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) min = array[i][j];
            }
        }
        return min;
    }

    public static String caesarEncoding(String str, int key) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] code = str.toCharArray();
        for (int i = 0; i < code.length; i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(code[i] == alphabet[j]) {
                    if((j + key) > alphabet.length - 1) {
                        code[i] = alphabet[key - (alphabet.length - j)];
                        break;
                    }
                    code[i] = alphabet[j + key];
                    break;
                }
            }
        }
        return new String(code);
    }
}