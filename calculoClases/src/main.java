import java.util.Scanner;
public class main {
    public static void main (String [] args){
        Scanner sc= new Scanner(System.in);

        double peso= vpeso(sc, "Ingresa tu peso en kg", 0.1, 50.0);
        int distancia= vdistancia (sc, "Ingresa la distancia en km", 1, 2000);
        int tipoServicio= vtipoServicio (sc, "Ingrese el tipo de servicio 1) Estandar 2)Express", 1, 2);
        boolean esZonaRemota= vesZonaRemota (sc, "Es zona remota? True or False");

        ShippingCalculator calc= new ShippingCalculator();
        double subtotal= calc.calcularSubtotal(peso, distancia, tipoServicio, esZonaRemota);
        double IVA= calc.calcularIva(subtotal);
        double total= calc.calcularTotal(subtotal, IVA);

        ticket(peso,distancia, tipoServicio, esZonaRemota, subtotal, IVA, total);
    }
    public static double vpeso(Scanner sc, String msg, double min, double max){
        int valor;
        while(true){
            System.out.println(msg);
            valor=sc.nextInt();
            if (valor>= min && valor<max)break;
            System.out.println("Valor invalido");
        }
        return valor;
    }

    public static boolean vesZonaRemota(Scanner sc, String msg) {
        boolean valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                valor = sc.nextBoolean();
                break;
            } else {
                System.out.println("Debes escribir true o false.");
                sc.next();
            }
        }
        return valor;
    }

    public static void ticket (int servicio, double peso, int distancia, boolean zonaRemota,
                                      double subtotal, double iva, double total) {
        System.out.println("---TICKET---");
        System.out.println("Servicio: " + (servicio == 1 ? "Estándar" : "Express"));
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Zona remota: " + zonaRemota);
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("IVA (16%%): $%.2f\n", iva);
        System.out.printf("TOTAL: $%.2f\n", total);
    }

}
