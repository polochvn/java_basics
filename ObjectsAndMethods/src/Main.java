public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1" + "\n");
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("Juice",50, 2, 0.3);
        basket.print("Корзина");
        Basket basket2 = new Basket();
        basket2.add("Butter", 60, 5,0.54);
        basket2.add("Bread", 70);
        basket2.print("Корзина 2");
        Basket.getAverageCostBasket();
        Basket.getAverageCostItem();
        System.out.println("Cредняя стоимость товара: " + Basket.averageCostItems);
        System.out.println("Средняя стоимость корзины: " + Basket.averageCostBasket);
        System.out.println("\n");

        System.out.println("Задание 2" + "\n");

        Ariphmetic ariphmetic = new Ariphmetic(20, 90);
        ariphmetic.sum();
        ariphmetic.result();
        ariphmetic.max();
        ariphmetic.min();
        System.out.println("\n");

        System.out.println("Задание 3"+ "\n");

        Printer document = new Printer();
        document.append("Текст первого документа");
        document.print("Печать");
        document.clear();
        document.append("Текст второго документа", "Документ_2");
        document.print("Печать");
        document.clear();
        document.append("Текст третьего документа", "Документ_3", 312);
        document.print("Печать");
        document.clear();

    }
}
