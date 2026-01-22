import java.util.Scanner;
public class main {
    public static void main (String [] args){
        Scanner leer= new Scanner(System.in);

        int edad;
        boolean esEstudiente=true;

        System.out.println("¿Cúal es tu edad?");
        edad= leer.nextInt();
        if (edad < 12){
            System.out.println("tu edad es:" + edad + "la tarifa es de 50");
        } else if (edad>= 12&&edad <=17) {
            if (esEstudiente){
                System.out.println("tu edad es: "+ edad + "a tarifa es de 60");

            }else{
                System.out.println("Tu edad es: "+ edad+ "La tarfifa es de 80");
            }if (edad >=18){
                if(esEstudiente){
                    System.out.println("Tu edad es: " + "La tarifa es de 90");
                }else{
                    System.out.println("tu edad es: " +edad + "a tarifa es de 120");
                }if (edad <=0 && edad>=120){
                    System.out.println("Edad inválida");
                }
            }

            }
        }
    }
