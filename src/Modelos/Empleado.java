package Modelos;

import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {
    private static final int FILTRO_NOMBRE = 1;
    private static final int FILTRO_EDAD = 2;
    private static final int FILTRO_DEPARTAMENTO = 3;
    private static final int FILTRO_SALARIO = 4;
    private static Scanner scan = new Scanner(System.in);
    private String nombre;
    private int edad;
    private double salario;
    private String departamento;


    public Empleado(String departamento, int edad, String nombre, double salario) {
        this.departamento = departamento;
        this.edad = edad;
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static void mostrarEmpleados(ArrayList<Empleado> empleados) {
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("| Numero de fila | Nombre del empleado | Edad del empleado | Departamento del empleado | Salario del empleado |");
        System.out.println("---------------------------------------------------------------------------------------------");
        int i = 0;
        for (Empleado empleado : empleados) {
            System.out.printf("| %d | %s | %d | %s | %2f |", i, empleado.getNombre(), empleado.getEdad(), empleado.getDepartamento(), empleado.getSalario());
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            i++;
        }
    }

    public static ArrayList<Empleado> filtrarEmpleados(ArrayList<Empleado> empleados, int filtro) {
        ArrayList<Empleado> filtrado = new ArrayList<>();
        switch (filtro) {
            case FILTRO_NOMBRE -> {
                filtrado = filtrarNombre(empleados);
            }
            case FILTRO_EDAD -> {
                filtrado = filtrarEdad(empleados);
            }
            case FILTRO_DEPARTAMENTO -> {
                filtrado = filtrarDepartamento(empleados);
            }
            case FILTRO_SALARIO -> {
                filtrado = filtrarSalario(empleados);
            }
        }
        return filtrado;

    }

    public static ArrayList<Empleado> filtrarNombre(ArrayList<Empleado> empleados) {
        System.out.println("Ingrese el nombre a filtrar");
        String nombre = scan.nextLine();
        ArrayList<Empleado> filtrado = new ArrayList<>();
        for (Empleado empleado:empleados){
            if(empleado.getNombre().equals(nombre)){
                filtrado.add(empleado);
            }
        }
        return filtrado;
    }

    public static ArrayList<Empleado> filtrarEdad(ArrayList<Empleado> empleados) {
        System.out.println("Ingrese la edad mínima para el filtro");
        int min = scan.nextInt();
        System.out.println("Ingrese la edad maxima para el filtro");
        int max = scan.nextInt();
        ArrayList<Empleado> filtrado = new ArrayList<>();
        for (Empleado empleado:empleados){
            if(empleado.getEdad()<max && empleado.getEdad()>min){
                filtrado.add(empleado);
            }
        }

        return filtrado;
    }

    public static ArrayList<Empleado> filtrarDepartamento(ArrayList<Empleado> empleados) {
        System.out.println("Ingrese el departamento a filtrar");
        ArrayList<Empleado> filtrado = empleados;
        return filtrado;
    }

    public static ArrayList<Empleado> filtrarSalario(ArrayList<Empleado> empleados) {
        System.out.println("Ingrese el salario mínimo para el filtro");
        System.out.println("Ingrese el salario maximo para el filtro");
        ArrayList<Empleado> filtrado = empleados;
        return filtrado;
    }

}
