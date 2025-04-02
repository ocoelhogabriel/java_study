package classe;

public class AreaCircTeste {

    public static void main(String[] args) {

        AreaCirc a1 = new AreaCirc(10);
        a1.raio = 10;
        // a1.pi = 1000000;

        // AreaCirc.PI = 3.1415;

        System.out.println(a1.area());

        System.out.println(AreaCirc.area(100));
        System.out.println(AreaCirc.PI);
        System.out.println(Math.PI);
    }

    public class AreaCirc {

        double raio;
        final static double PI = 3.1415;

        AreaCirc(double raioInicial) {
            raio = raioInicial;
        }

        double area() {
            return PI * Math.pow(raio, 2);
        }

        static double area(double raio) {
            return PI * Math.pow(raio, 2);
        }
    }

}
