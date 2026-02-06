public class GradeService {
    public double calcularPromedio(double a, double b, double c){
        return (a + b + c)/3;
    }
    public double calcularFinal( double promedio, int asistencia ){
        return (promedio*0.7)* (asistencia * 0.3);
    }
    public String determinarEstado(double calfinal, int asistencia, boolean entregarProyecto){
        if (asistencia < 80){
            return "REPROBADO por asistencia";
        }
        if (!entregarProyecto){
            return "REPROBADO por proyecto";
        }
        if (calfinal>=70){
            return "APROBADO!!";
        }else{
            return "Reprobado por calificación";
        }
    }
}
