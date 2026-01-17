import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Ingrese un numero entero:");
        int numero= numeroEntero(sc);
        int sumaDeNumeros=sumarHastaNumero(numero);

        System.out.println("El resultado es:"+sumaDeNumeros);
    }
    public static int numeroEntero(Scanner sc){
        int numero;
        return numero= sc.nextInt();
    }
    public static int sumarHastaNumero (int numero){
        int sumaDeNumeros=0;
        for(int i=1;i<=numero;i++) {
            sumaDeNumeros += i;
        }
        return sumaDeNumeros;
    }
}
/**
 * pide el numero al usuario
 *
 *
 */

/* Falta escribir el args
2. n y s no son descriptivas
3.la identacion no es la correcta esta, todo pegado
4. Las lineas de codigo no estan en orden
5. En el momento de imprimir no le muestra al usuario que es lo que esta haciendo
6. El codigo solo esta en main


 */