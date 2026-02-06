public class ShippingCalculator {

    public double calcularSubtotal(double peso, int distancia, int tipoServicio, boolean esZonaRemota){
        double subtotal = 0;

        if (tipoServicio == 1){
            subtotal += 50;
        } else if (tipoServicio == 2){
            subtotal += 90;
        }
        subtotal += peso * 12;

        if (distancia <= 50){
            subtotal += 20;
        } else if (distancia <= 200){
            subtotal += 60;
        } else {
            subtotal += 120;        }

        if (esZonaRemota){
            subtotal *= 1.10;
        }
        return subtotal;
    }

    public double calcularIva(double subtotal){
        return subtotal * 0.16;
    }

    public double calcularTotal(double subtotal, double iva){
        return subtotal + iva;
    }
}