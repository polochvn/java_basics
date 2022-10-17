public class Main {
    public static void main(String[] args) {
        Container container = new Container(56);
        container.addCount(5672);
        System.out.println(container.getCount());

        System.out.println("\n" + "Задание 2");

        for (int i = 0; i < 65535; i++) {
            char code = (char) i;
            if (code == 'Ё' || code == 'ё') {
                System.out.println(i + " - " + code);
            } else if (code >= 'А' && code <= 'я') {
                System.out.println(i + " - " + code);
            }
        }

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

    }
}
