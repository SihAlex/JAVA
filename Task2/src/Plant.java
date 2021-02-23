public class Plant {
    String name;
    String habitat;
    int age;

    public Plant() {
        name = null;
        habitat = null;
        age = -1;

        System.out.println("Plant constructor has been called.");
    }

    public Plant(Plant ob) {
        name = ob.name;
        habitat = ob.habitat;
        age = ob.age;

        System.out.println("Plant constructor has been called.");
    }

    public Plant(String name, String habitat, int age) {
        this.name = name;
        this.habitat = habitat;
        this.age = age;

        System.out.println("Plant constructor has been called.");
    }

    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.habitat + "\t" + this.age;
    }
}

class Tree extends Plant {
    int height;

    public Tree() {
        super();
        height = -1;

        System.out.println("Tree constructor has been called.");
    }

    public Tree(Tree ob) {
        super(ob);
        height = ob.height;

        System.out.println("Tree constructor has been called.");
    }

    public Tree(String name, String habitat, int age, int height) {
        super(name, habitat, age);
        this.height = height;

        System.out.println("Tree constructor has been called.");
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.habitat + "\t" + this.age + "\t" + this.height;
    }
}

class Flower extends Plant {
    String color;

    public Flower() {
        super();
        color = null;

        System.out.println("Flower constructor has been called.");
    }

    public Flower(Flower ob) {
        super(ob);
        color = ob.color;

        System.out.println("Flower constructor has been called.");
    }

    public Flower(String name, String habitat, int age, String color) {
        super(name, habitat, age);
        this.color = color;

        System.out.println("Flower constructor has been called.");
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.habitat + "\t" + this.age + "\t" + this.color;
    }
}