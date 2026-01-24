import java.util.Scanner;
public class ActividadSwitchCalculadora {
    public static void main (String[]args){
        Scanner leer= new Scanner(System.in);
        double a;
        double b;
        int opcion;
        double resultado;

        System.out.println("Menú de operaciones:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        System.out.println("Elige una opcion:");
        opcion= leer.nextInt();
        System.out.println("Ingresa el valor a:");
        a= leer.nextInt();
        System.out.println("Ingresa el valor b");
        b= leer.nextInt();

        switch(opcion){
            case 1:
                System.out.println("Suma");
                resultado= a+b;
                System.out.println("El resultado es: "+ resultado);
                break;
            case 2:
                System.out.println("Restar");
                resultado= a-b;
                System.out.println(" El resultado es: " + resultado);
                break;
            case 3:
                System.out.println("Multiplicar");
                resultado= a*b;
                System.out.println(" El resultado es: " + resultado);
                break;
            case 4:
                System.out.println("Dividir");
                if(b==0){
                    System.out.println("Tu opcion es invalida");
                }else{
                    resultado= a/b;
                    System.out.println("El resultado es: " + resultado);
                }
                break;
            default:
                System.out.println("Tu opcion es invalida");
                break;



        }
        leer.close();
    }
}
