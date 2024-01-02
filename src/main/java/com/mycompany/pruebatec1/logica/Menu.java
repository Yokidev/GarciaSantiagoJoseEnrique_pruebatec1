package com.mycompany.pruebatec1.logica;

import com.mycompany.pruebatec1.servicios.EmpleadoServicio;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityNotFoundException;

public class Menu {
    
    private EmpleadoServicio empleadoServicio = new EmpleadoServicio();
    
    /***
     * Metodo para mostrar el menu de opciones principales de la aplicacion de gestion de empleados
     * @return 
     */
    public int mostrarMenu() {
        
        int opcion = -1; //Se inicia en -1 para evitar entrar en la opcion de salida si hay algun fallo en la primera entrada
       
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println("*===================================*");
            System.out.println("|                                   |");
            System.out.println("|     Menú gestion de empleados     |");
            System.out.println("|                                   |");
            System.out.println("*===================================*");
            System.out.println("|                                   |");
            System.out.println("|     1. Agregar empleado           |");
            System.out.println("|     2. Mostrar empleados          |");
            System.out.println("|     3. Actualizar empleado        |");
            System.out.println("|     4. Eliminar empleado          |");
            System.out.println("|     5. Buscar empleado por cargo  |");
            System.out.println("|     0. Salir                      |");
            System.out.println("|                                   |");
            System.out.println("*===================================*");

            System.out.print("Introduzca una opcion: ");

            opcion = scanner.nextInt();

            
        }catch(InputMismatchException exception){
            System.out.println("Valor introducido no valido. Por favor, intentelo de nuevo");
        }
        return opcion;
    }
   
    /***
     * Metodo que muestra la opcion del menu asignada para la agregacion de empleados al sistema de gestion
     */
    public void menuAgregarEmpleado() {
        
        try{

            Scanner scanner = new Scanner(System.in);

            System.out.println("*===================================*");
            System.out.println("|       Agrega nuevo empleado       |");
            System.out.println("*===================================*");

            //Nombre
            String nombreAgregar = agregarNombre();
            
            //Apellido
            String apellidoAgregar = agregarApellido();
            
            //Cargo
            String cargoAgregar = agregarCargo();
            
            //Cargo
            double salarioAgregar = agregarSalario();
            
            //Fecha
            LocalDate fechaAgregar = agregarFechaInicio();
            
            //Crear empleado
            Empleado empleado = new Empleado(nombreAgregar,apellidoAgregar,cargoAgregar,salarioAgregar,fechaAgregar);

            //Guardar en base de datos
            empleadoServicio.crearEmpleado(empleado);

            System.out.println("Empleado agregado");

            volverMenuPrincipal();
            
        }catch(InputMismatchException exception){
            System.out.println("Los caracteres introducidos son invalidos. Por favor intentelo de nuevo");
            volverMenuPrincipal();
        }catch(DateTimeException exception){
            System.out.println("Fecha invalida. Intentelo de nuevo");
            volverMenuPrincipal();
        }
    }
    
    /***
     * Metodo que muestra la opcion del menu asignada para mostrar la lista de empleados en la base de datos
     */
    public void menuMostrarEmpleados(){
        
        System.out.println("*===================================*");
        System.out.println("|       Listado de empleados        |");
        System.out.println("*===================================*");
        System.out.println("");
        
        List<Empleado> listaEmpleados = empleadoServicio.mostrarEmpleados();
        
        if (listaEmpleados.size()> 0) {
            for(Empleado empleado: listaEmpleados){
            System.out.println(empleado);
        }
        }else{
            System.out.println("Registro vacío");
        }
        
        
        System.out.println("");
        volverMenuPrincipal();
    }
    
    /***
     * Metodo que muestra la opcion del menu asignada para la eliminacion de empleado en la base de datos
     */
    public void menuEliminarEmpleado(){
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println("*===================================*");
            System.out.println("|         Eliminar empleado         |");
            System.out.println("*===================================*");
            
            //Se muestran primero los empleados en el registro
            List<Empleado> listaEmpleados = empleadoServicio.mostrarEmpleados();
            
            if (listaEmpleados.size()> 0) {
                for(Empleado empleado: listaEmpleados){
                    System.out.println(empleado);
                }

                System.out.print("Introduzca el id del empleado que desee eliminar: ");

                int id = scanner.nextInt();

                empleadoServicio.borrarEmpleado(id);

                System.out.println("Empleado eliminado de la base de datos");
                
                volverMenuPrincipal();
            }else{
                System.out.println("Registro vacío"); //En caso de que el registro esté vacio se devuelve el usuario al menu 
                volverMenuPrincipal();
            }
        }catch(EntityNotFoundException exception){
            System.out.println("El empleado que intenta eliminar no existe en el registro");
            volverMenuPrincipal();
        }catch(InputMismatchException exception){
            System.out.println("Valor introducido no valido. Por favor, intentelo de nuevo");
            volverMenuPrincipal();
        }
    }
    
    
    /***
     * Metodo que muestra la opcion del menu asignada para mostrar los empleados filtrando por el cargo
     */
    public void menuMostrarEmpleadosPorCargo(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("*===================================*");
        System.out.println("|     Buscar empleado por cargo     |");
        System.out.println("*===================================*");
        
        System.out.print("Introduzca el cargo por el que filtrar: ");
        
        String cargo = scanner.nextLine();
        
        List<Empleado> listaEmpleados = empleadoServicio.mostrarEmpleadosPorCargo(cargo);
        
        System.out.println("Puesto: " + cargo);
        if (listaEmpleados.size()> 0) {
            for(Empleado empleado: listaEmpleados){
            System.out.println(empleado);
        }
        }else{
            System.out.println("Registro vacío");
        }
        
        System.out.println("");
        volverMenuPrincipal();
    }
    
    /***
     * Metodo que proporciona la vista de las diferentes opciones para realizar el cambio de atributos al empleado requerido
     */
    public void menuActualizarEmpleado(){
        
                
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("*===================================*");
            System.out.println("|        Actualizar empleado        |");
            System.out.println("*===================================*");
            System.out.println("|    ¿Que empleado desea cambiar?   |");
            System.out.println("*===================================*");

            //Se muestran primero los empleados en el registro
            List<Empleado> listaEmpleados = empleadoServicio.mostrarEmpleados();

            if (listaEmpleados.size()> 0) {
                for(Empleado empleado: listaEmpleados){
                    System.out.println(empleado);
                }
                
                System.out.print("Introduzca la id del empleado: ");
                 
                int id = scanner.nextInt();

                Empleado empleado = empleadoServicio.encontrarEmpleado(id);

                System.out.println("*===================================*");
                System.out.println("|        Actualizar empleado        |");
                System.out.println("*===================================*");
                System.out.println("|                                   |");
                System.out.println("|    ¿Que elemento desea cambiar?   |");
                System.out.println("|     1. Nombre                     |");
                System.out.println("|     2. Apellido                   |");
                System.out.println("|     3. Cargo                      |");
                System.out.println("|     4. Salario                    |");
                System.out.println("|     5. Fecha de inicio            |");
                System.out.println("|     0. Salir                      |");
                System.out.println("|                                   |");
                System.out.println("*===================================*");

                System.out.print("Introduzca una opcion: ");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        opcionActualizarNombre(empleado);
                        break;

                    case 2:
                        opcionActualizarApellido(empleado);
                        break;

                    case 3:
                        opcionActualizarCargo(empleado);
                        break;

                    case 4:
                        opcionActualizarSalario(empleado);
                        break;

                    case 5:
                        try {
                            opcionActualizarFecha(empleado);
                        } catch (DateTimeParseException exception) {
                            System.out.println("Formato introducido no valido. Intentelo de nuevo");
                            volverMenuPrincipal();
                        }
                        break;

                    case 0:
                        System.out.println("Volviendo al menu principal");
                        break;

                    default:
                        System.out.println("Introduzca un valor valido.");
                }
            }else{
                System.out.println("Registro vacío"); //En caso de que el registro esté vacio se devuelve el usuario al menu 
                volverMenuPrincipal();
            }
        }catch(NullPointerException exception){
            System.out.println("El usuario que intenta modificar no existe");
            volverMenuPrincipal();
        }catch(InputMismatchException exception){
            System.out.println("Valor introducido no valido. Por favor, intentelo de nuevo");
            volverMenuPrincipal();
        }
    }
    
    /***
     * Agregar el campo de nombre
     * @return String nombreAgregar
     */
    private String agregarNombre(){
        Scanner scanner = new Scanner(System.in);
        String nombreAgregar;
        do {
                System.out.print("Nombre: ");
                nombreAgregar = scanner.nextLine();
                if (!validarString(nombreAgregar)) {
                    System.out.println("Por favor, rellene el campo");
                }
                    
        } while (!validarString(nombreAgregar));
        return nombreAgregar;
        }
    
    
    /***
     * Actualiza el nombre del empleado elegido
     * @param empleado 
     */
    private void opcionActualizarNombre(Empleado empleado){
        Scanner scanner = new Scanner(System.in);
        
        String nuevoNombre;
        do {
            System.out.print("Nuevo nombre: ");
            nuevoNombre = scanner.next();
            if (!validarString(nuevoNombre)) {
                System.out.println("Por favor, rellene el campo");
            }
            } while (!validarString(nuevoNombre));
        
        empleado.setNombre(nuevoNombre);
        empleadoServicio.modificarEmpleado(empleado);
        
        System.out.println("Nombre actualizado");
        volverMenuPrincipal();
    }
    
    /***
     * Agrega el campo de Apellido
     * @return String apellidoAgregar
     */
    private String agregarApellido() {
        Scanner scanner = new Scanner(System.in);
        String apellidoAgregar;
        do {            
            System.out.print("Apellido: ");
            apellidoAgregar = scanner.nextLine();
            if (!validarString(apellidoAgregar)) {
                System.out.println("Por favor, rellene el campo");
            }
        } while (!validarString(apellidoAgregar));
        
        return apellidoAgregar;
    }
    
    /***
     * Actualiza el apellido del empleado elegido
     * @param empleado 
     */
    private void opcionActualizarApellido(Empleado empleado){
        Scanner scanner = new Scanner(System.in);
        
        String nuevoApellido;
        do {
            System.out.print("Nuevo apellido: ");
            nuevoApellido = scanner.next();
            if (!validarString(nuevoApellido)) {
                System.out.println("Por favor, rellene el campo");
            }
        } while (!validarString(nuevoApellido));
        
        empleado.setApellido(nuevoApellido);
        empleadoServicio.modificarEmpleado(empleado);

        System.out.println("Apellido actualizado");
        volverMenuPrincipal();
    }
    
    /***
     * Agrega el campo de Cargo
     * @return String cargoAgregar
     */
    private String agregarCargo(){
        Scanner scanner = new Scanner(System.in);
        String cargoAgregar;
        do {            
            System.out.print("Cargo: ");
            cargoAgregar = scanner.nextLine();
            if (!validarString(cargoAgregar)) {
                System.out.println("Por favor, rellene el campo");
            }
        } while (!validarString(cargoAgregar));
        
        return cargoAgregar;
    }
    
    /***
     * Actualiza el cargo del empleado elegido
     * @param empleado 
     */
    private void opcionActualizarCargo(Empleado empleado){
        Scanner scanner = new Scanner(System.in);
        
        String nuevoCargo;
        do {            
            System.out.print("Nuevo cargo: ");
            nuevoCargo = scanner.next();
            if (!validarString(nuevoCargo)) {
                System.out.println("Por favor, rellene el campo");
            }
        } while (!validarString(nuevoCargo));
        
        empleado.setCargo(nuevoCargo);
        empleadoServicio.modificarEmpleado(empleado);

        System.out.println("Cargo actualizado");
        volverMenuPrincipal();
    }
    
    /***
     * Agrega el campo de salario
     * @return double salarioAgregar
     */
    private Double agregarSalario(){
        Scanner scanner = new Scanner(System.in);
        Double salarioAgregar = 0.00;
        do { 
                System.out.print("Salario: ");
                salarioAgregar = scanner.nextDouble();
                if (!validarDouble(salarioAgregar)) {
                    System.out.println("Por favor introduzca un valor numérico positivo valido");
                }
        } while (!validarDouble(salarioAgregar));
        
        return salarioAgregar;
    }
    
    /***
     * Actualiza el salario del empleado elegido
     * @param empleado 
     */
    private void opcionActualizarSalario(Empleado empleado){
        try{
        Scanner scanner = new Scanner(System.in);
        
        double nuevoSalario = 0;
            do { 
                System.out.print("Nuevo salario: ");
                nuevoSalario = scanner.nextDouble();
                if (!validarDouble(nuevoSalario)) {
                    System.out.println("Por favor introduzca un valor numérico positivo valido");
                }
            } while (!validarDouble(nuevoSalario));
        
        empleado.setSalario(nuevoSalario);
        empleadoServicio.modificarEmpleado(empleado);

        System.out.println("Salario actualizado");
        volverMenuPrincipal();
        }catch(InputMismatchException exception){
            System.out.println("Valor introducido no valido. Intentelo de nuevo.");
        }
    }
    
    /***
     * Agrega el campo de fecha de inicio
     * @return LocalDate agregarFechaInicio
     */
    private LocalDate agregarFechaInicio() {
        Scanner scanner = new Scanner(System.in);
        String fechaComoTexto;
        do {
            System.out.print("Fecha (AAAA-MM-DD): ");
            fechaComoTexto = scanner.next().trim();
            if (!validarFecha(fechaComoTexto)) {
                System.out.println("Por favor, ingrese una fecha siguiendo el siguiente formato AAAA-MM-DD");
            }
        } while (!validarFecha(fechaComoTexto));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaAgregar = LocalDate.parse(fechaComoTexto, formatter);
        
        return fechaAgregar;
    }
    
    /***
     * Actualiza la fecha del empleado elegido
     * @param empleado 
     */
    private void opcionActualizarFecha(Empleado empleado){
        try {
            
            Scanner scanner = new Scanner(System.in);

            String fechaComoTexto;
                do {
                    System.out.print("Nueva fecha de inicio (AAAA-MM-DD): ");
                    fechaComoTexto = scanner.next().trim();
                    if (!validarFecha(fechaComoTexto)) {
                        System.out.println("Por favor, ingrese una fecha siguiendo el siguiente formato AAAA-MM-DD");
                    }
                } while (!validarFecha(fechaComoTexto));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate nuevaFecha = LocalDate.parse(fechaComoTexto, formatter);
            empleado.setFechaInicio(nuevaFecha);
            empleadoServicio.modificarEmpleado(empleado);

            System.out.println("Fecha actualizada");
            volverMenuPrincipal();
        } catch (InputMismatchException exception) {
            System.out.println("Los caracteres introducidos son invalidos. Por favor intentelo de nuevo");
            volverMenuPrincipal();
        }catch(DateTimeException exception){
            System.out.println("Fecha invalida. Intentelo de nuevo");
            volverMenuPrincipal();
        }
    }
    
    /***
     * Metodo para avisar de que se va a volver al menu principal
     */
    private void volverMenuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        String volver;
        do{
            System.out.print("Presione (y) para volver al menu principal: ");
            volver = scanner.next();
        }while(!volver.equalsIgnoreCase("y"));
    }
    
    /***
     * Metodo para validar que las fechas ingresadas por el usuario se ajusten al formato requerido
     * @param fecha
     * @return Verdadero o falso en funcion de si cumplen la condicion o no
     */
    private static boolean validarFecha(String fecha) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fecha);
        return matcher.matches();
    }
    
    /***
     * Metodo para validar que las Strings ingresadas por el usuario se ajusten al formato requerido
     * @param cadena
     * @return Verdadero o falso en funcion de si cumplen la condicion o no
     */
    private static boolean validarString(String cadena){
        // Verificar si la cadena es nula
        if (cadena == null) {
            return false;
        }

        // Eliminar espacios en blanco al inicio y al final de la cadena
        cadena = cadena.trim();

        // Verificar si la cadena está vacía después de eliminar espacios
        return !cadena.isEmpty();
    }
    
    /***
     * Metodo para validar que los numeros double ingresados por el usuario se ajusten al formato requerido
     * @param numero
     * @return Verdadero o falso en funcion de si cumplen la condicion o no
     */
    private static boolean validarDouble(Double numero){
        // Verificar si el número es nulo
        if (numero == null) {
            return false;
        }

        // Verificar si el número es mayor que 0
        if (numero > 0) {
            // Verificar si el número es un valor válido (no es NaN o infinito)
            return !numero.isNaN() && !numero.isInfinite();
        } else {
            return false;
        }
    }

}
