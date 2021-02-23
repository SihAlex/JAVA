import java.util.Scanner;

public class Student {
    private int age;
    private String surname;
    private String name;

    public Student() {
        age = 0;
        surname = null;
        name = null;
    }

    public Student(int age, String surname, String name) {
        this.age = age;
        this.surname = surname;
        this.name = name;
    }

    public Student(Student obj) {
        this.age = obj.age;
        this.surname = obj.surname;
        this.name = obj.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public void bubbleSort(Student[] students, int criteria) {
        int n = students.length;

        switch (criteria) {
            case 1:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (students[j].age > students[j + 1].age) {
                            Student temp = students[j];
                            students[j] = students[j + 1];
                            students[j + 1] = temp;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (students[j].strCompare(students[j].surname, students[j + 1].surname)) {
                            Student temp = students[j];
                            students[j] = students[j + 1];
                            students[j + 1] = temp;
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (students[j].strCompare(students[j].name, students[j + 1].name)) {
                            Student temp = students[j];
                            students[j] = students[j + 1];
                            students[j + 1] = temp;
                        }
                    }
                }
                break;
            default:
                System.out.println("Wrong option has been chosen!");
                break;
        }


        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    boolean strCompare(String str1, String str2) {
        int length, cmp;
        if (str1.length() < str2.length()) {
            length = str1.length();
        } else {
            length = str2.length();
        }
        for (int i = 0; i < length; i++) {
            cmp = Character.compare(str1.charAt(i), str2.charAt(i));
            if (cmp > 0) {
                return true;
            } else return false;
        }
        return false;
    }

    public String toString() {
        return age + "\t" + surname + "\t" + name;
    }
}
