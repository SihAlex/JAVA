interface StudentSort {
    void bubbleSort(Student[] students, String property);
}

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

    public <T> T getProp(String property) {
        if (property == "age") {
            return (T) (Integer) getAge();
        }
        if (property == "surname") {
            return (T) (String) getSurname();
        }
        if (property == "name") {
            return (T) (String) getName();
        }
        return null;
    }

    class BubbleSort implements StudentSort {
        @Override
        public void bubbleSort(Student[] students, String property) {
            Sorter sorter = new Sort();
            int n = students.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (sorter.compare(students, students[j].getProp(property), students[j + 1].getProp(property), j, j + 1)) {
                        sorter.swap(students, j, j + 1);
                    }
                }
            }
            showStudents(students);
        }
    }


    void showStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    public String toString() {
        return age + "\t" + surname + "\t" + name;
    }
}