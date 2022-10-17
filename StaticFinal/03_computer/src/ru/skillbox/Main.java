package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Screen screen = new Screen(17, ScreenType.LCD, 5.3);
        Keyboard keyboard = new Keyboard(KeyboardType.Mechanical, true, 2.5);
        HardDisc hardDisc = new HardDisc(HardDiscType.HDD, 1000, 1.8);
        Processor processor = new Processor(2.2, 4, ProcessorManufacturer.Intel, 1.5);
        RAM ram = new RAM(RandomAccessMemoryType.DIMM,4, 2.47);
        Computer comp = new Computer("HP", "620");
        comp.setHardDisc(hardDisc);
        comp.setKeyboard(keyboard);
        comp.setScreen(screen);
        comp.setRandomAccessMemory(ram);
        comp.setProcessor(processor);
        System.out.println(comp.toString());
    }
}
