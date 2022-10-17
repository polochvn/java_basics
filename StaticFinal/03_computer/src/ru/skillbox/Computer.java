package ru.skillbox;

public class Computer {

    private final String vendor;
    private final String name;

    public Processor processor;
    public RAM randomAccessMemory;
    public HardDisc hardDisc;
    public Screen screen;
    public Keyboard keyboard;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public Processor getProcessor() { return processor; }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public void setRandomAccessMemory(RAM randomAccessMemory) {
        this.randomAccessMemory = randomAccessMemory;
    }

    public HardDisc getHardDisc() {
        return hardDisc;
    }

    public void setHardDisc(HardDisc hardDisc) {
        this.hardDisc = hardDisc;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public double getWeight() {
        double weight = screen.getWeight() + processor.getWeight() + keyboard.getWeight() +
                hardDisc.getWeight() + randomAccessMemory.getWeight();
        return weight;
    }

    public String toString() {
        return "Компьютер" + "\n" +
                "Производитель: " + vendor + "\n" +
                "Название: " + name + "\n" +
                "\n Процессор: "  + "\n" +
                "Частота: " + processor.getFrequency() + " ГГц \n" +
                "Производитель: " + processor.getManufacturer() + "\n" +
                "Количество ядер: " + processor.getNumberCores() + "\n" +
                "Вес: " +  processor.getWeight() +  " КГ \n" +
                "\n Оперативная память: " + "\n" +
                "Тип: " + randomAccessMemory.getType() + "\n" +
                "Обьем памяти: " + randomAccessMemory.getVolumeMemory() + " ГБ \n" +
                "Вес: " + randomAccessMemory.getWeight() + " кг \n" +
                "\n Накопитель информации: " + "\n" +
                "Тип жесткого диска: " + hardDisc.getType() + "\n" +
                "Объем памяти: " + hardDisc.getVolumeMemory() + " ГБ \n" +
                "Вес: " + hardDisc.getWeight() + " кг \n" +
                "\n Экран: " + "\n" +
                "Диагональ: " + screen.getDiagonal() + "''\n" +
                "Тип: " + screen.getType() + "\n" +
                "Вес: " + screen.getWeight() + " кг \n" +
                "Клавиатура: \n" + "\n" +
                "Тип: " + keyboard.getType() + "\n" +
                "Наличие подсветки: " + keyboard.getIsBacklight() + "\n" +
                "Вес: " + keyboard.getWeight() + " кг";
    }
}
