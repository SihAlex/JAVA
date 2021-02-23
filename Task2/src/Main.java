import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // 35
        Student sort = new Student();
        Student[] stList = {
                new Student(19, "Petrov", "Ivan"),
                new Student(18, "Ivanov", "Petr"),
                new Student(18, "Sidorov", "Ivan")
        };
        sort.bubbleSort(stList, 3);
        // 47
        Plant plantRef;
        Tree mangoTree = new Tree("Mango", "Tropics", 10, 50);
        plantRef = mangoTree;
        plantRef.showInfo();

        // 50
        new Test(3).showNumber();
        new Test(4).showNumber();

        // 51
        Test.showNumbers();
        Test.showCounter();

        // 48
        Lecturer Sviridov = new Lecturer("Michael", "Sviridov", 46, "Mathematics");
        System.out.println(Sviridov);
    }
}
