public interface Sorter<T, K> {
    boolean compare(T[] arr, K el1, K el2, int i, int j);

    boolean isNumeric(K el1, K el2);

    void swap(T[] arr, int i, int j);
}

class Sort<T, K> implements Sorter<T, K> {
    @Override
    public void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public boolean isNumeric(K el1, K el2) {
        String str1 = el1.toString();
        String str2 = el2.toString();
        if (str1.matches("^[0-9]+(\\.[0-9])*$") && str2.matches("^[0-9]+(\\.[0-9])*$")) {
            return true;
        } else return false;
    }

    @Override
    public boolean compare(T[] arr, K el1, K el2, int i, int j) {
        if (isNumeric(el1, el2)) {
            String str1 = el1.toString();
            String str2 = el2.toString();
            return Double.parseDouble(str1) > Double.parseDouble(str2);
        } else {
            String str1 = el1.toString();
            String str2 = el2.toString();
            int length, cmp;
            if (str1.length() > str2.length()) {
                length = str2.length();
                swap(arr, i, j);
            } else {
                length = str1.length();
            }
            for (int k = 0; k < length; k++) {
                cmp = Character.compare(str1.charAt(k), str2.charAt(k));
                if(cmp == 0) {
                    continue;
                }
                if (cmp < 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}