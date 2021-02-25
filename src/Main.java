public class Main {
    public static void main(String[] args) {
        // 35
        Student[] stList = {
                new Student(18, "Petrov", "Ivan"),
                new Student(19, "Ivanov", "Petr"),
                new Student(18, "Sidorov", "Ivan")
        };
        StudentSort sort = new Student().new BubbleSort();
        sort.bubbleSort(stList, "surname");
    }
}
