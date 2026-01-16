import java.sql.SQLOutput;
import java.util.Scanner;
public class Main{

    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular el área de un rectángulo");
            System.out.println("3. Calcular °C a °F");
            System.out.println("4. Calcular area de un circulo");
            System.out.println("5. Salir");
            System.out.println("Elije una opción");

            opcion= scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa tu peso en kg");
                    double peso= scanner.nextDouble();
                    System.out.println("ingresa tu altura en metros");
                    double altura= scanner.nextDouble();
                    System.out.println("Tu IMC es: "+ calcularIMC(peso,altura));
                    break;

                case 2:
                    System.out.println("ingresa cuanto mide la base");
                    double base= scanner.nextDouble();
                    System.out.println("ingresa cuanto mide la altura");
                    double h= scanner.nextDouble();
                    System.out.println("El area del rectangulo es: "+ areaRectangulo(base,h));
                    break;

                case 3:
                    System.out.println("ingresa los grados Celcius");
                    double celcius= scanner.nextDouble();
                    System.out.println("El resultado es: " + celciusAFarenheit (celcius));
                    break;

                case 4:
                    System.out.println("ingresa el radio");
                    double radio= scanner.nextDouble();
                    System.out.println("El area del circulo es: "+ areaCirculo(radio));
                    break;

                case 5:
                    System.out.println("Estas saliendo del sistema");
                    break;

                default:
                    System.out.println("Error, tu opcion no es valida");


            }

        }
            while (opcion != 5 );
             scanner.close();
    }
    /**
     * Calcula el indice de masa corporal
     *
     * @param peso peso de la persona en kilo gramos
     * @param altura altura de la persona en metros
     * @return valor del IMC
     */
    public static double calcularIMC(double peso, double altura){
        return peso/(altura * altura);
    }
    /**
     * calcula el area de un rectangulo
     *
     * @param base base del rectangulo
     * @param altura altura del rectangulo
     * @return area del rectangulo
     */
    public static double areaRectangulo(double base,double altura){
        return base * altura;
    }
    /**
     * convierte los grados celcius a farenheit
     *
     * @param celcius la temperatura en grados celcius
     * @return la temperatura convertida a Farenheit
     */
    public static double celciusAFarenheit(double celcius){
        return (celcius * 1.8) + 32;
    }
    /**
     * calcula el area de un circulo
     *
     * @param radio radio del circulo
     * @return area del circulo
     */
    public static double areaCirculo(double radio){
        return 3.1416* radio* radio;
    }

}