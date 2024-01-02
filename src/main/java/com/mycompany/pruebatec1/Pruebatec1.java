package com.mycompany.pruebatec1;

import com.mycompany.pruebatec1.logica.ControladoraLogica;
import com.mycompany.pruebatec1.logica.Menu;

public class Pruebatec1 {

    public static void main(String[] args) {
        
        ControladoraLogica controladoraLogica = new ControladoraLogica();
                
        //Bandera
        boolean flag = true;
        
        do{
            //Mostrar menu
            
            int opcion = controladoraLogica.mostrarMenu();
            
            switch (opcion) {
                case 1:
                    controladoraLogica.menuAgregarEmpleado();
                    break;
                case 2:
                    controladoraLogica.menuMostrarEmpleados();
                    break;
                case 3:
                    controladoraLogica.menuActualizarEmpleado();
                    break;
                case 4:
                    controladoraLogica.menuEliminarEmpleado();
                    break;
                case 5:
                    controladoraLogica.menuMostrarEmpleadosPorCargo();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicacion. \nHasta la proxima!");
                    flag = false;
                    break;
                default:
                    System.out.println("Introduzca un valor valido.");
            }
            
        }while(flag); 
        
        
            
    }
}
