import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = {3, 1, 2};
        System.out.println("Choose a method: ");
        int a = scan.nextInt();
        switch (a) {
            case 1: // 3
                var new_array = lr1.arrayPaste(array);
                showArray(new_array);
                break;
            case 2: // 12
                if (array.length > 1) {
                    lr1.arraySort(array);
                }
                showArray(array);
                break;
            case 3: // 15
                System.out.println("Type your message: ");
                scan.nextLine();
                String str = scan.nextLine();
                String encodedStr = encodingTable.encodeString(str);
                System.out.println(encodedStr);
                String decodedStr = encodingTable.decodeString(encodedStr);
                System.out.println(decodedStr);
                break;
            case 4: // 27
                System.out.println(lr1.decToOct(9));
                break;
            case 5: // 29
                int[] array1 = {6, 7, -1};
                System.out.println(lr1.minNumber(array, array1));
                break;
            case 6: // практичне
                System.out.println("Enter your key");
                int key = scan.nextInt();
                System.out.println("Type your message: ");
                scan.nextLine();
                String code = scan.nextLine();
                System.out.println(lr1.caesarEncoding(code, key));
                break;
            default:
                System.out.println("Wrong input!");
                break;
        }
    }

    static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print('\t');
        }
    }
}
