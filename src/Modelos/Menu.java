package Modelos;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public Scanner sc = new Scanner(System.in);

    private static void menu(Scanner sc) {
        int opcion = 0;
        ArrayList<Empleado> empleados = new ArrayList<>();
        do {
            System.out.println("Seleccione una opcion \n 1. Mostrar empleados \n 2. Crear empleado \n 3. Filtrar empleados \n 4. Ordernar empleados \n 5. Incrementar salario \n 6. Limpiar filtros \n 7. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Empleado.mostrarEmpleados(empleados);
                    break;
                case 2:
                    //empleados.add(new Empleado())
                    break;
                case 3:
// filtrarEmpleados();
                    break;
                case 4:
// ordenarEmpleados();
                    break;
                case 5:
// incrementarSalario();
                    break;
                case 6:
// limpiarFiltros();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 5);
    }
}
