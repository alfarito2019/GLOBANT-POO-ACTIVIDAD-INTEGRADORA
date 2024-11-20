package Modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {
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
        if(empleados.isEmpty()){
            System.out.println("No hay empleados");
        }else{
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println("| Numero de fila | Nombre del empleado | Edad del empleado | Departamento del empleado | Salario del empleado |");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            int i = 0;
            for (Empleado empleado : empleados) {
                System.out.printf("| %d | %s | %d | %s | %2f |", i, empleado.getNombre(), empleado.getEdad(), empleado.getDepartamento(), empleado.getSalario());
                System.out.println("");
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                i++;
            }
        }

    }

    public static ArrayList<Empleado> filtarEmpleados(ArrayList<Empleado> empleados) {
        ArrayList<Empleado> filtrado = new ArrayList<>();
        int decision = 0;
        do{
            try {
                System.out.println("Desea filtrar por Nombre(1), Edad(2), Departamento(3), Salario(4) o Salir(5)?");
                decision = scan.nextInt();
                 switch (decision) {
                    case 1 -> filtrado = filtrarNombre(empleados);
                    case 2 -> filtrado =filtrarEdad(empleados);
                    case 3 -> filtrado = filtrarDepartamento(empleados);
                    case 4 -> filtrado =filtrarSalario(empleados);
                    case 5 -> System.out.println("Saliendo");
                    default -> filtrado = empleados;
                };
                mostrarEmpleados(filtrado);
            } catch (Exception e) {
                System.out.println("Ese valor no está permitido");
            }
        }while(decision !=5);


        return filtrado;
    }

    private static ArrayList<Empleado> filtrarNombre(ArrayList < Empleado > empleados) {
        System.out.println("Ingrese el nombre por el que desea filtrar: ");
        String nombre = scan.nextLine();
        ArrayList<Empleado> filtrado = new ArrayList<>();
        for(Empleado empleado: empleados){
            if(nombre.equals(empleado.getNombre())){
                filtrado.add(empleado);
            }
        }
        return filtrado;
    }

    private static ArrayList<Empleado> filtrarEdad(ArrayList < Empleado > empleados) {
        System.out.println("Ingrese la edad minima para filtrar: ");
        int min = scan.nextInt();
        System.out.println("Ingrese la edad maxima para filtrar: ");
        int max = scan.nextInt();
        scan.nextLine();
        ArrayList<Empleado> filtrado = new ArrayList<>();
        for(Empleado empleado: empleados){
            if(min < empleado.getEdad() && max > empleado.getEdad()){
                filtrado.add(empleado);
            }
        }
        return filtrado;
    }

    private static ArrayList<Empleado> filtrarDepartamento(ArrayList < Empleado > empleados) {
        System.out.println("Ingrese el Departamento por el que desea filtrar: ");
        String departamento = scan.nextLine();
        ArrayList<Empleado> filtrado = new ArrayList<>();
        for(Empleado empleado: empleados){
            if(departamento.equals(empleado.getDepartamento())){
                filtrado.add(empleado);
            }
        }
        return filtrado;
    }

    private static ArrayList<Empleado> filtrarSalario(ArrayList < Empleado > empleados) {
        System.out.println("Ingrese el salario minimo para filtrar: ");
        double min = scan.nextDouble();
        System.out.println("Ingrese el salario máximo para filtrar: ");
        double max = scan.nextDouble();
        scan.nextLine();
        ArrayList<Empleado> filtrado = new ArrayList<>();
        for(Empleado empleado: empleados){
            if(min < empleado.getSalario() && max > empleado.getSalario()){
                filtrado.add(empleado);
            }
        }
        return filtrado;
    }

    public static ArrayList<Empleado> ordenarEmpleados(ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ordenado = empleados;
        int decision = 0;
        do{
            try {
                System.out.println("Desea ordenar por Nombre(1), Edad(2), Departamento(3), Salario(4) o Salir(5)?");
                decision = scan.nextInt();
                switch (decision) {
                    case 1 -> ordenado = ordenarNombre(empleados);
                    case 2 -> ordenado = ordenarEdad(empleados);
                    case 3 -> ordenado = ordenarDepartamento(empleados);
                    case 4 -> ordenado = ordenarSalario(empleados);
                    case 5 -> System.out.println("Saliendo");
                    default -> ordenado = empleados;
                };
            } catch (Exception e) {
                System.out.println("Ese valor no está permitido");
            }
        }while(decision !=5);


        return ordenado;
    }

    private static ArrayList<Empleado> ordenarNombre(ArrayList < Empleado > empleados) {
        return bubbleSortNombre(empleados);
    }

    private static ArrayList<Empleado> ordenarEdad(ArrayList < Empleado > empleados) {
        return bubbleSortEdad(empleados);
    }

    private static ArrayList<Empleado> ordenarDepartamento(ArrayList < Empleado > empleados) {
        return bubbleSortDepartamento(empleados);
    }

    private static ArrayList<Empleado> ordenarSalario(ArrayList < Empleado > empleados) {
        return bubbleSortSalario(empleados);
    }

    static ArrayList<Empleado> bubbleSortEdad(ArrayList<Empleado> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getEdad()>list.get(j + 1).getEdad()) {
                    Empleado temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }
    static ArrayList<Empleado> bubbleSortSalario(ArrayList<Empleado> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getSalario() > list.get(j + 1).getSalario()) {
                    Empleado temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }
    static ArrayList<Empleado> bubbleSortNombre(ArrayList<Empleado> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getNombre().compareToIgnoreCase(list.get(j + 1).getNombre())>0) {
                    Empleado temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

    static ArrayList<Empleado> bubbleSortDepartamento(ArrayList<Empleado> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getDepartamento().compareToIgnoreCase(list.get(j + 1).getDepartamento())>0) {
                    Empleado temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }


    static Empleado buscarPorNombre(ArrayList<Empleado> empleados, String nombre) {
        for(Empleado empleado: empleados){
            if(nombre.equals(empleado.getNombre())){
                return empleado;
            }
        }
        return null;
    }

    public static Empleado incrementarSalario(ArrayList<Empleado> empleados){
        System.out.println("Ingrese el nombre del empleado a incrementar salario");
        String nombre= scan.nextLine();
        Empleado empleado = buscarPorNombre(empleados,nombre);
        if (empleado == null){
            System.out.println("Empleado no encontrado");
        }else{
            System.out.println("Ingrese el porcentaje del empleado a incrementar salario");
            double porcentaje= scan.nextDouble();
            empleado.setSalario(empleado.getSalario()*(1+(porcentaje/100)));
            System.out.println("Salario incrementado");
        }

        return empleado;
    }

    public static void crearEmpleado(ArrayList<Empleado> empleados){
        System.out.println("Ingrese el nombre del empleado a crear");
        String nombre = scan.nextLine();
        if(buscarPorNombre(empleados,nombre)==null){
            System.out.println("Ingrese la edad del empleado a crear");
            int edad = ingresarNumero();
            System.out.println("Ingrese el departamento del empleado a crear");
            String departamento = scan.nextLine();
            System.out.println("Ingrese el salario del empleado a crear");
            double salario = scan.nextDouble();
            scan.nextLine();
            Empleado empleado = new Empleado(departamento,edad,nombre,salario);
            empleados.add(empleado);
        }
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



