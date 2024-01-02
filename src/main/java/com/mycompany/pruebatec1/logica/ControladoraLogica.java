package com.mycompany.pruebatec1.logica;

public class ControladoraLogica {
    
    Menu menu = new Menu();
    
    public int mostrarMenu(){
        return menu.mostrarMenu();
    }
    
    public void menuAgregarEmpleado(){
        menu.menuAgregarEmpleado();
    }
    
    public void menuMostrarEmpleados(){
        menu.menuMostrarEmpleados();
    }
    
    public void menuEliminarEmpleado(){
        menu.menuEliminarEmpleado();
    }
    
    public void menuMostrarEmpleadosPorCargo(){
        menu.menuMostrarEmpleadosPorCargo();
    }
    
    public void menuActualizarEmpleado(){
        menu.menuActualizarEmpleado();
    }
    
}
