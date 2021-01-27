// 15 Створіть 2 методи, які можуть кодувати та розкодувати будь який рядок у відповідності з таблицею перекодування в якій наприклад символу =а= відповідає символ =й=
// Таблиці перекодування повинні бути атрибутами класу, в якому будуть знаходитися методи.
public class encodingTable {
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char[] coding_alphabet = "qwertyuioplkjhgfdsazxcvbnm".toCharArray();

    public static String encodeString(String str) {
        char[] temp = new char[str.length()];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if(str.charAt(i) == alphabet[j]) temp[i] = coding_alphabet[j];
            }
        }
        return new String(temp);
    }

    public static String decodeString(String str) {
        char[] temp = new char[str.length()];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if(str.charAt(i) == coding_alphabet[j]) temp[i] = alphabet[j];
            }
        }
        return new String(temp);
    }
}
