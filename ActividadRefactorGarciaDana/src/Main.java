import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = pedirEntero("a: ", scanner);
        int b = pedirEntero("b: ", scanner);
        int c = pedirEntero("c: ", scanner);

        int Suma = calcularSuma(a, b, c);
        imprimirResultado(Suma);
    }

    private static void imprimirResultado(int Suma) {
        System.out.println("suma=" + Suma);
        System.out.println("prom=" + calcularPromedio(Suma));
    }

    private static double calcularPromedio(int Suma) {
        return Suma / 3.0;
    }

    private static int calcularSuma(int a, int b, int c) {
        int Suma = a + b + c;
        return Suma;
    }

    private static int pedirEntero(String s, Scanner scanner) {
        System.out.print(s);
        int a = scanner.nextInt();
        return a;
    }
}
