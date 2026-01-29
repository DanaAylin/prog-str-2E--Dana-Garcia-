import java.util.Random;
import java.util.Scanner;
public class main{
    public static void main(String[] args){

        Scanner scanner= new Scanner(System.in);
        Random random= new Random();
        int numMinimo=1;
        int numMaximo=100;
        int intentos=0;
        int limiteIntentos=7;
        int secreto = random.nextInt(numMaximo)+numMinimo;
        System.out.println(secreto);
        boolean gano=false;

        System.out.println("Adivina el numero, esta entre el (1-100) tienes: "+limiteIntentos);

        while(intentos<limiteIntentos && !gano){
            int valor=obtenerNumeroValido(numMinimo, numMaximo, scanner, "Intento numero: "+(intentos+1));
            intentos++;
            if(valor == secreto){
                System.out.println("Has ganado en "+intentos+" intento");
                gano=true;

            }else if(valor>secreto){
                System.out.println("El numero es menor");
            }else{
                System.out.println("El numero es mayor");
            }

        }
        if(!gano){
            System.out.println("Perdiste, el numero secreto no es ese, es: "+secreto);
        }
        scanner.close();

    }

    public static int obtenerNumeroValido(int nummin, int nummax, Scanner scanner, String mensaje){
        int valor;

        while(true){
            System.out.println(mensaje);
            if(scanner.hasNextInt()){

                valor = scanner.nextInt();
                if(valor>=nummin && valor<=nummax){
                    return valor;
                }
                System.out.println("El numero esta fuera de rango, debe de ser entre "+nummin+" y"+nummax);
            }else{
                System.out.println("Eso no es un numero");
                scanner.next();
            }


        }

    }
