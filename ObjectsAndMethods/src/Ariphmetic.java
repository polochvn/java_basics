public class Ariphmetic {

    int a = 0;
    int b = 0;

    public Ariphmetic(int x, int y) {
        a = x;
        b = y;
    }

    public void sum () {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    public void result () {
        System.out.println(a + " * " + b + " = " + a*b);
    }

    public void max () {
        if (a >= b) {
            System.out.println("MaxNumber = " + a);
        } else {
            System.out.println("MaxNumber = " + b);
        }
    }

    public void min () {
            if (a >= b) {
                System.out.println("MinNumber = " + b);
            } else {
                System.out.println("MinNumber = " + a);
            }
        }
}


