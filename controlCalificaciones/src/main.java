import java.util.Scanner;

public class main{
public static String alumnoNoVacio(Scanner sc, String msg){
    String texto;
    do {
        System.out.print(msg);
        texto = sc.nextLine().trim();
    } while (texto.isEmpty());
    return texto;

}
public static double Calificacion (Scanner sc, String msg, int min, int max){
    int valor;
    do{
        System.out.print(msg);
        valor=sc.nextInt();
    }while (valor<min || valor>max);
    return valor;
}
public static int dAsistencia(Scanner sc, String msg, int min, int max){
    int valor;
    do {
        System.out.print(msg);
        valor=sc.nextInt();
    }while (valor <min || valor> max);
    return valor;
}
public static boolean entregarproyecto(Scanner sc, String msg){
    boolean valor;
    while (true){
        System.out.println(msg);
        if (sc.hasNextBoolean()){
            valor= sc.nextBoolean();
            break;
        }else{
            System.out.printf("Escribe true o false");
            sc.next();
        }
    }
    return valor;
}
public static void imprimirReporte(String nombre, double p1, double p2, double p3, double promedio,int asistencia, boolean entregarProyecto, double calfinal, String estado) {
    System.out.printf("REPORTE FINAL:");
    System.out.println("nombre: "+ nombre);
    System.out.println("parcial1: " + p1);
    System.out.println("parcial2: " + p2);
    System.out.println("parcial3: " + p3);
    System.out.printf("promedio= "+ promedio);
    System.out.println("Asistencia: "+ asistencia);
    System.out.println("Entrego proyecto:" + entregarProyecto);
    System.out.println("Calificacion Final: "+ calfinal);
    System.out.println("Estado: "+ estado);
}


    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        GradeService gs = new GradeService();

        String nombre= alumnoNoVacio(sc, "Escribe el nombre del alumno" );
        double calP1= Calificacion(sc, "Calificacion del parcial 1", 0, 100);
        double calP2= Calificacion(sc, "Calificacion del parcial 2", 0, 100);
        double calP3= Calificacion(sc, "Calificacion del parcial 3", 0, 100);
        int asistencia= dAsistencia(sc, "asistencia", 0, 100);
        boolean entregaProyecto= entregarproyecto (sc, "entrego proyecto? true or false");

        double promedio= gs.calcularPromedio(calP1, calP2, calP3);
        double calfinal= gs.calcularFinal(promedio, asistencia);
        String determinarEstado= gs.determinarEstado(calfinal, asistencia, entregaProyecto);

        imprimirReporte(nombre,calP1, calP2, calP3, promedio, asistencia, entregaProyecto, calfinal, determinarEstado);
        sc.close();
    }

}
