package com.mycompany.pruebatec1.persistencia;

import com.mycompany.pruebatec1.logica.Empleado;
import com.mycompany.pruebatec1.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    
    public void crearEmpleado(Empleado empleado) {
        empleadoJPA.create(empleado);
    }
    
    public List<Empleado> mostrarEmpleados(){
        return empleadoJPA.findEmpleadoEntities();
    }
    
    public void modificarEmpleado (Empleado empleado){
        
        try {
            empleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void borrarEmpleado(int id){
        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            System.out.println("El empleado que intenta eliminar no existe en el registro");
        }
    }
    
    public Empleado encontrarEmpleado(int id){
        return empleadoJPA.findEmpleado(id);
         
    }
    
    public List<Empleado> mostrarEmpleadosPorCargo(String cargo){
        return empleadoJPA.findEmpleadoByCargo(cargo);
    }
    
    
}
