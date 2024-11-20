import Modelo.Empleado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int seleccion = 0;
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Empleado> filtrados = empleados;
        do {
            System.out.println("\n--- Sistema de Gestión de Empleados ---");
            System.out.println("1. Mostrar todos los empleados");
            System.out.println("2. Crear empleado");
            System.out.println("3. Filtrar empleados");
            System.out.println("4. Ordenar empleados");
            System.out.println("5. Incrementar salario");
            System.out.println("6. Limpiar filtros");
            System.out.println("7. Salir");

            seleccion = ingresarNumero();
            switch (seleccion) {
                case 1 -> Empleado.mostrarEmpleados(filtrados);
                case 2 -> Empleado.crearEmpleado(empleados);
                case 3 -> filtrados= Empleado.filtarEmpleados(empleados);
                case 4 -> empleados= Empleado.ordenarEmpleados(filtrados);
                case 5 -> Empleado.incrementarSalario(empleados);
                case 6 -> filtrados = empleados;
                case 7 -> System.out.println("Saliendo ...");
                default -> System.out.println("Opción no permitida");
            }

        } while (seleccion != 7);
    }

    public static int ingresarNumero() {
        boolean esNumber = false;
        int num = 0;

        do {
            esNumber = true;
            try {
                num = Integer.valueOf(scan.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Error, ingrese un número");
                esNumber = false;
            }

        } while (!esNumber);

        return num;
    }
}