public class persona {

    private int id;
    private String nombre;
    private boolean isActive;

    public persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}
