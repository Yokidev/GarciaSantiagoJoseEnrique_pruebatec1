package com.mycompany.pruebatec1.servicios;

import com.mycompany.pruebatec1.logica.Empleado;
import com.mycompany.pruebatec1.persistencia.ControladoraPersistencia;
import java.util.List;

public class EmpleadoServicio {
    
    private ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
    
    /***
     * Metodo para crear empleado en la base de datos
     * @param empleado 
     */
    public void crearEmpleado(Empleado empleado){
        controladoraPersistencia.crearEmpleado(empleado);
    }
    
    /***
     * Metodo para mostrar la lista de los empleados en la base de datos
     * @return Lista de empleados
     */
    public List<Empleado> mostrarEmpleados() {
        return controladoraPersistencia.mostrarEmpleados();
    }

    /***
     * Metodo para eliminar empleado en funcion de su id
     * @param idEliminar 
     */
    public void borrarEmpleado(int idEliminar) {
            controladoraPersistencia.borrarEmpleado(idEliminar);
    }

    /***
     * Metodo para modificar atributos de un empleado
     * @param empleado 
     */
    public void modificarEmpleado(Empleado empleado) {
            controladoraPersistencia.modificarEmpleado(empleado);
    }
    
    /***
     * Metodo para encontrar un empleado en funcion de su id
     * @param idEncontrar
     * @return Empleado
     */
    public Empleado encontrarEmpleado(int idEncontrar){
        return controladoraPersistencia.encontrarEmpleado(idEncontrar);
    }
    
    /***
     * Metodo para mostrar los empleados filtrados segun cargo
     * @param cargo
     * @return Lista de empleados filtrados por cargo
     */
    public List<Empleado> mostrarEmpleadosPorCargo(String cargo){
        return controladoraPersistencia.mostrarEmpleadosPorCargo(cargo);
    }
    
}
