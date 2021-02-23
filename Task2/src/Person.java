public class Person {
    String name;
    String surname;
    int age;

    public Person() {
        name = null;
        surname = null;
        age = -1;

        System.out.println("Person constructor has been called.");
    }

    public Person(Person ob) {
        name = ob.name;
        surname = ob.surname;
        age = ob.age;

        System.out.println("Person constructor has been called.");
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;

        System.out.println("Person constructor has been called.");
    }

    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.surname + "\t" + this.age;
    }
}

class Learner extends Person {
    int height;

    public Learner() {
        super();
        height = -1;

        System.out.println("Learner constructor has been called.");
    }

    public Learner(Learner ob) {
        super(ob);
        height = ob.height;

        System.out.println("Learner constructor has been called.");
    }

    public Learner(String name, String habitat, int age, int height) {
        super(name, habitat, age);
        this.height = height;

        System.out.println("Learner constructor has been called.");
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + this.height;
    }
}

class Lecturer extends Person {
    String subject;

    public Lecturer() {
        super();
        subject = null;

        System.out.println("Lecturer constructor has been called.");
    }

    public Lecturer(Lecturer ob) {
        super(ob);
        subject = ob.subject;

        System.out.println("Lecturer constructor has been called.");
    }

    public Lecturer(String name, String habitat, int age, String subject) {
        super(name, habitat, age);
        this.subject = subject;

        System.out.println("Lecturer constructor has been called.");
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + this.subject;
    }
}
