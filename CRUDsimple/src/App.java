import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        persona[] personas = new persona[20];
        int contador = 0;
        int opcion;

        do {
            System.out.println("===== MENÚ =====");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    if (id <= 0) {
                        System.out.println("ID inválido");
                        break;
                    }

                    boolean repetido = false;
                    for (int i = 0; i < contador; i++) {
                        if (personas[i].getId() == id) {
                            repetido = true;
                            break;
                        }
                    }

                    if (repetido) {
                        System.out.println("ID repetido");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    if (nombre.isEmpty()) {
                        System.out.println("Nombre vacío");
                        break;
                    }

                    personas[contador] = new persona(id, nombre);
                    contador++;
                    System.out.println("Persona dada de alta");
                    break;

                case 2:
                    System.out.print("ID a buscar: ");
                    int idBuscar = sc.nextInt();
                    boolean encontrada = false;

                    for (int i = 0; i < contador; i++) {
                        if (personas[i].getId() == idBuscar && personas[i].isActive()) {
                            System.out.println("Nombre: " + personas[i].getNombre());
                            encontrada = true;
                            break;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("No encontrada o inactiva");
                    }
                    break;

                case 3:
                    System.out.print("ID dar de baja: ");
                    int idBaja = sc.nextInt();
                    boolean baja = false;

                    for (int i = 0; i < contador; i++) {
                        if (personas[i].getId() == idBaja && personas[i].isActive()) {
                            personas[i].setActive(false);
                            baja = true;
                            System.out.println("Persona dada de baja");
                            break;
                        }
                    }

                    if (!baja) {
                        System.out.println("No encontrada o ya inactiva");
                    }
                    break;

                case 4:
                    System.out.println("--- Personas activas ---");
                    for (int i = 0; i < contador; i++) {
                        if (personas[i].isActive()) {
                            System.out.println(personas[i].getId() + " - " + personas[i].getNombre());
                        }
                    }
                    break;

                case 5:
                    System.out.print("ID a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();
                    boolean actualizada = false;

                    for (int i = 0; i < contador; i++) {
                        if (personas[i].getId() == idAct && personas[i].isActive()) {
                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = sc.nextLine();

                            if (!nuevoNombre.isEmpty()) {
                                personas[i].setNombre(nuevoNombre);
                                System.out.println("Nombre actualizado");
                            }
                            actualizada = true;
                            break;
                        }
                    }

                    if (!actualizada) {
                        System.out.println("No encontrada o inactiva");
                    }
                    break;

                case 0:
                    System.out.println("Saliste");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }
}
