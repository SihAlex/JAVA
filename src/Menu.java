import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected static List<String> menu = new ArrayList<>();
    static {
        menu.add(Gaspacho.menuEntry());
    }

    protected enum PricePerGram {
        PEPPER(5), TOMATOES(2), TABASCO(12),
        SALAD(0.5), CHEESE(7), POTATOES(1.5),
        EGGS(7), HAM(12), BREAD(3);

        double price;

        PricePerGram(double price) {
            this.price = price;
        }

        public double getPrice() {
            return this.price;
        }
    }

    public static void showMenu() {
        for (String entry : menu) {
            System.out.print(entry);
        }
    }

    public static void showPricesPerGram() {
        for (PricePerGram item : PricePerGram.values()) {
            System.out.print(item + " -- ");
            System.out.println(item.getPrice());
        }
    }

    public abstract Menu getDish();
    public abstract String getDishName();
    public abstract double getDishPrice();
    public abstract void showComponents();
    public abstract boolean equals(Menu order);
}

class Gaspacho extends Menu {
    private final int pepper;
    private final int tomatoes;
    private final int tabasco;
    private final String name = "Gaspacho";
    private final double dishPrice;

    private static final String menuEntryName = "Gaspacho";

    public Gaspacho(Builder order) {
        this.pepper = order.pepper;
        this.tomatoes = order.tomatoes;
        this.tabasco = order.tabasco;

        double pepperPrice = PricePerGram.valueOf("PEPPER").getPrice() * this.pepper;
        double tomatoesPrice = PricePerGram.valueOf("TOMATOES").getPrice() * this.tomatoes;
        double tabascoPrice = PricePerGram.valueOf("TABASCO").getPrice() * this.tabasco;

        this.dishPrice = (pepperPrice + tomatoesPrice + tabascoPrice);
    }

    public static class Builder {
        private int pepper = 3;
        private int tomatoes = 100;
        private int tabasco = 5;

        public Builder pepperOrder(int pepper) {
            this.pepper = pepper;
            return this;
        }

        public Builder tomatoesOrder(int tomatoes) {
            this.tomatoes = tomatoes;
            return this;
        }

        public Builder tabascoOrder(int tabasco) {
            this.tabasco = tabasco;
            return this;
        }

        public Gaspacho build() {
            return new Gaspacho(this);
        }
    }

    @Override
    public Menu getDish() {
        return this;
    }

    @Override
    public String getDishName() {
        return this.name;
    }

    @Override
    public double getDishPrice() {
        return this.dishPrice;
    }

    @Override
    public boolean equals(Menu order) {
        try {
            Gaspacho gaspacho = (Gaspacho)order;
            return this.pepper == gaspacho.pepper
                    && this.tomatoes == gaspacho.tomatoes
                    && this.tabasco == gaspacho.tabasco;
        } catch(Exception e) {
            return false;
        }
    }

    public void showComponents() {
        System.out.println(showPepper() + "\n" + showTomatoes() + "\n" + showTabasco());
    }

    private String showPepper() {
        return "pepper - " + this.pepper;
    }

    private String showTomatoes() {
        return "tomatoes - " + this.tomatoes;
    }

    private String showTabasco() {
        return "tabasco - " + this.tabasco;
    }

    protected static String menuEntry() {
        return menuEntryName;
    }
}