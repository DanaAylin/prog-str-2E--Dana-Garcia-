import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[25];

        int opcion;

        do {
            System.out.println("===MENU===");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID (solo activos)");
            System.out.println("3) Actualizar promedio por ID (solo activos)");
            System.out.println("4) Baja logica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Selecciona tu opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    if (id <= 0) {
                        System.out.println("ID invalido");
                        break;
                    }

                    boolean repetido = false;
                    for (Alumno a : alumnos) {
                        if (a!= null && a.getId() == id) {
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
                        System.out.println("Nombre vacio");
                        break;
                    }

                    System.out.print("Promedio: ");
                    double promedio = sc.nextDouble();

                    if (promedio < 0 || promedio > 10) {
                        System.out.println("Promedio invalido");
                        break;
                    }

                    boolean agregado = false;
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] == null) {
                            alumnos[i] = new Alumno(id, nombre, promedio, true);
                            agregado = true;
                            break;
                        }
                    }

                    if (agregado) {
                        System.out.println("Alumno agregado");
                    } else {
                        System.out.println("Arreglo lleno");
                    }

                    break;

                case 2:
                    System.out.print("ID a buscar: ");
                    int idBuscar = sc.nextInt();
                    boolean encontrado = false;

                    for (Alumno a : alumnos) {
                        if (a != null && a.getId() == idBuscar && a.isActivo()) {
                            System.out.println("ID: " + a.getId());
                            System.out.println("Nombre: " + a.getNombre());
                            System.out.println("Promedio: " + a.getPromedio());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("inactivo");
                    }

                    break;

                case 3:
                    System.out.print("ID: ");
                    int idActualizar = sc.nextInt();
                    boolean actualizado = false;

                    for (Alumno a : alumnos) {
                        if (a != null && a.getId() == idActualizar && a.isActivo()) {
                            System.out.print("Nuevo promedio: ");
                            double nuevo = sc.nextDouble();

                            if (nuevo >= 0 && nuevo <= 10) {
                                a.setPromedio(nuevo);
                                System.out.println("Promedio actualizado");
                            } else {
                                System.out.println("Promedio invalido");
                            }

                            actualizado = true;
                            break;
                        }
                    }

                    if (!actualizado) {
                        System.out.println("No encontrado o inactivo");
                    }

                    break;

                case 4:
                    System.out.print("ID: ");
                    int idBaja = sc.nextInt();
                    boolean baja = false;

                    for (Alumno a : alumnos) {
                        if (a != null && a.getId() == idBaja && a.isActivo()) {
                            a.setActivo(false);
                            System.out.println("Alumno dado de baja");
                            baja = true;
                            break;
                        }
                    }

                    if (!baja) {
                        System.out.println("inactivo");
                    }

                    break;

                case 5:
                    for (Alumno a : alumnos) {
                        if (a != null && a.isActivo()) {
                            System.out.println("ID: " + a.getId());
                            System.out.println("Nombre: " + a.getNombre());
                            System.out.println("Promedio: " + a.getPromedio());
                        }
                    }
                    break;

                case 6:

                    double suma = 0;
                    int contador = 0;
                    Alumno mayor = null;
                    Alumno menor = null;
                    int mayoresA8 = 0;

                    for (Alumno a : alumnos) {
                        if (a != null && a.isActivo()) {

                            suma += a.getPromedio();
                            contador++;

                            if (mayor == null || a.getPromedio() > mayor.getPromedio()) {
                                mayor = a;
                            }

                            if (menor == null || a.getPromedio() < menor.getPromedio()) {
                                menor = a;
                            }

                            if (a.getPromedio() >= 8.0) {
                                mayoresA8++;
                            }
                        }
                    }

                    if (contador > 0) {
                        double promedioGeneral = suma/contador;
                        System.out.println("Promedio general: " + promedioGeneral);

                        System.out.println("Mayor promedio:");
                        System.out.println(mayor.getId() + " - " + mayor.getNombre() + " - " + mayor.getPromedio());

                        System.out.println("Menor promedio:");
                        System.out.println(menor.getId() + " - " + menor.getNombre() + " - " + menor.getPromedio());

                        System.out.println("Alumnos con promedio >= 8: " + mayoresA8);

                    } else {
                        System.out.println("No hay alumnos activos");
                    }

                    break;

                case 0:
                    System.out.println("Salistee, chau. ");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
