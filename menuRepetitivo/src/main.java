import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        int contC = 0;
        int contF = 0;
        int contM = 0;
        int contKm = 0;

        do {
            System.out.println("Menú:");
            System.out.println("1. Convertir °C a °F");
            System.out.println("2. Convertir °F a °C");
            System.out.println("3. Convertir Millas a Km");
            System.out.println("4. Convertir Km a Millas");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error, debes ingresar un número del 1 al 5");
                scanner.next();
                continue;
            }

            opcion = scanner.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción inválida, elige de nuevo");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa los grados Celsius: ");
                    if (scanner.hasNextDouble()) {
                        double celsius = scanner.nextDouble();
                        System.out.println("Resultado: " + celciusAFarenheit(celsius));
                        contC++;
                    } else {
                        System.out.println("Dato inválido, debe ser numérico");
                        scanner.next();
                    }
                    break;

                case 2:
                    System.out.print("Ingresa los grados Fahrenheit: ");
                    if (scanner.hasNextDouble()) {
                        double fahrenheit = scanner.nextDouble();
                        System.out.println("Resultado: " + farenheitACelcius(fahrenheit));
                        contF++;
                    } else {
                        System.out.println("Dato inválido, debe ser numérico");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.print("Ingresa las millas: ");
                    if (scanner.hasNextDouble()) {
                        double millas = scanner.nextDouble();
                        System.out.println("Resultado: " + millasAKm(millas));
                        contM++;
                    } else {
                        System.out.println("Dato inválido, debe ser numérico");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.print("Ingresa los kilómetros: ");
                    if (scanner.hasNextDouble()) {
                        double km = scanner.nextDouble();
                        System.out.println("Resultado: " + kmAMillas(km));
                        contKm++;
                    } else {
                        System.out.println("Dato inválido, debe ser numérico");
                        scanner.next();
                    }
                    break;

                case 5:
                    System.out.println("Resumen de las conversiones:");
                    int total = contC + contF + contM + contKm;
                    System.out.println("Total de conversiones: " + total);
                    System.out.println("°C a °F: " + contC);
                    System.out.println("°F a °C: " + contF);
                    System.out.println("Millas a Km: " + contM);
                    System.out.println("Km a Millas: " + contKm);
                    System.out.println("Saliste del sistema");
                    break;
            }

        } while (opcion != 5);

        scanner.close();
    }

    public static double celciusAFarenheit(double celcius) {
        return (celcius * 1.8) + 32;
    }

    public static double farenheitACelcius(double farenheit) {
        return (farenheit - 32) * 5 / 9;
    }

    public static double millasAKm(double millas) {
        return millas * 1.609;
    }

    public static double kmAMillas(double km) {
        return km / 1.609;
    }
}
