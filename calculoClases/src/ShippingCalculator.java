public class ShippingCalculator {

    public double calcularSubtotal ( double peso2, int distancia2, int tipoServicio2, boolean esZonaRemota2){
        double subtotal=0;
        if (tipoServicio2==1){
            subtotal+=50;

        }else if(tipoServicio2==2){
            subtotal+=90;
        }

        subtotal=peso2*12;

        if (distancia2<=50){
            subtotal+=20;
        }else if(distancia2 <=200){
            subtotal+=60;
        }else{
            subtotal+=120;
        }
        if (esZonaRemota2){
            subtotal*=1.10;
        }
        return subtotal;
    }

    public double calcularIva (double subtotal){
        return subtotal*0.16;
    }

    public double calcularTotal(double subtotal, double IVA){
        return subtotal+IVA;
    }

}
