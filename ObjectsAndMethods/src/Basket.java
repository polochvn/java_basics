public class Basket {

    private static int count = 0;
    private String items = "";
    private int costBasket;
    private int limit;
    private double totalWeight = 0;
    public static int countItems;
    public static int costForAllBaskets;
    public static int averageCostBasket;
    public static int averageCostItems;

    public Basket() {
        increaseCount(1);
        increaseCostForAllBaskets(0);
        increaseCountItems(0);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int costBasket) {
        this();
        this.items = this.items + items;
        this.costBasket = costBasket;
    }

    public static int getCount() {
        return count;
    }

    public void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static void increaseCountItems(int countItems) {
        Basket.countItems += + countItems;
    }

    public static void increaseCostForAllBaskets(int costForAllBaskets) {
        Basket.costForAllBaskets += costForAllBaskets;
    }

    public static int getAverageCostItem() {
        averageCostItems = costForAllBaskets / countItems;
    }

    public static void getAverageCostBasket() {
        averageCostBasket = costForAllBaskets / count;
    }

    public void add(String name, int price) { add(name, price, 1); }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (costBasket + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        costBasket = costBasket + count * price;
        countItems = countItems + count;
        costForAllBaskets = costForAllBaskets + count * price;
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (costBasket + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + " - " +
                count + " шт. - " + count * weight + " кг. - " +  price;
        costBasket = costBasket + count * price;
        totalWeight = totalWeight + count * weight;
        countItems = countItems + count;
        costForAllBaskets = costForAllBaskets + count * price;
    }

    public void clear() {
        items = "";
        costBasket = 0;
    }

    public static int getItemsBaskets() {  return countItems; }

    public static int getTotalPriceBaskets() { return costForAllBaskets; }

    public double getTotalWeight() { return totalWeight; }

    public int getTotalPrice() {
        return costBasket;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общий вес товаров: " + totalWeight + " кг.");
        }
    }
}
