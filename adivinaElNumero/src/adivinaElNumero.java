import java.util.Random;
import java.util.Scanner;

public class adivinaElNumero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secreto = random.nextInt(100) + 1;
        int intentos = 0;
        int maxIntentos = 7;

        boolean gano = false;

        int fueraDeRango = 0;
        int noNumerico = 0;

        System.out.println("Adivina el número entre 1 y 100");

        while (intentos < maxIntentos && !gano) {
            System.out.println("Intento " + (intentos + 1) + ":");

            if (!scanner.hasNextInt()) {
                System.out.println("Eso no es un número");
                noNumerico++;
                scanner.next();
                continue;
            }

            int numero = scanner.nextInt();
            intentos++;

            if (numero < 1 || numero > 100) {
                System.out.println("Número fuera de rango");
                fueraDeRango++;
                continue;
            }

            if (numero == secreto) {
                System.out.println("Ganaste!");
                gano = true;
            } else if (numero > secreto) {
                System.out.println("El numero secreto es menor");
            } else {
                System.out.println("El numero secreto es mayor");
            }
        }

        if (!gano) {
            System.out.println("Perdiste, el numero secreto era: " + secreto);
        }

        System.out.println("Numero fuera de rango: " + fueraDeRango);
        System.out.println("Esto es una letra no un numero: " + noNumerico);

        scanner.close();
    }
}
