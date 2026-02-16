public class Alumno {

    private int id;
    private String nombre;
    private double promedio;
    private boolean activo;

    public Alumno(int id, String nombre, double promedio, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
