# Aplicación de Gestión de Empleados 

<p>Primer proyecto desarrollado durante el curso de Java en HaB. El objetivo de esta prueba es poner en practica los conocimientos en Java, incluyendo sintaxis, estructuras repetitivas, estructuras selectivas, manejo de colecciones y operaciones CRUD (Crear, Leer, Actualizar y Borrar) utilizando JPA (Java Persistence API) para interactuar con una base de datos. </p>
<p>Para ello se ha desarrollado un backend lógico para una aplicación de gestión de empleados de una empresa.</p>

## Pre-requisitos 📋

_Programas y herramientas necesarias para utilizar el programa_

```
Java 17 o superior
IDE compatible con Java 17 o superior
Un gestor de bases de datos compatible con MySQL
```
Es supuesto que el usuario tiene conocimiento del id de los empleados de la BBDD asi como del usuario y contraseña de la misma.

```
Usuario: root
Contraseña: ""
```

## Instalación 🔧

- Descargar el proyecto o realizar un git clone.
- Importar el archivo .sql alojado en la carpeta BBDD dentro de resources del proyecto al SGBD compatible con MySql deseado.
- Abrir el proyecto en el IDE deseado.


## Funcionalidades del proyecto :hammer:
La aplicación permite a los usuarios realizar las siguientes operaciones:

  ![MenuInicio](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec1/assets/113154741/20d8c1fc-7762-49d2-af55-b72d1cdb9d3f)

- `Agregar empleados`: Agrega un nuevo empleado a la base de dato, proporcionando imformacion sobre los siguientes campos: Nombre, Apellido, Cargo, Salario y Fecha de inicio del puesto.
  
  ![MenuAgregar](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec1/assets/113154741/c512aaac-cc0b-45f8-92e4-72b26eb2d5fe)

- `Listar empleados`: Devuelve todos los empleados existentes en la tabla de la base de datos.
  
  ![MenuMostrar](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec1/assets/113154741/7ab84a3c-e503-4d71-b00f-ca381b6777d8)

- `Actualizar informacion de un empleado`: Permite actualizar la informacion de un empleado de la base de datos.
  
  ![MenuActualizar1](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec1/assets/113154741/be34849f-952f-4060-915d-ed697e780788)
  ![MenuActualizar2](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec1/assets/113154741/2d3dad41-96c4-42b5-a26b-ecede689688a)

- `Eliminar un empleado`: Permite eliminar el registro de un empleado de la base de datos.
  
  ![MenuEliminar](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec1/assets/113154741/c52736cd-3a66-4e66-9a3a-e38e37c2489a)

- `Buscar empleados por cargo`: Filtra los empleados de la base de datos en funcion del cargo deseado.
  
  ![BuscarPorCargo](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec1/assets/113154741/19f33949-819d-4c47-a500-ce429ff478bf)


## Construido con 🛠️

* [Java](https://docs.oracle.com/en/java/javase/17/docs/api/index.html) - Lenguaje utilizado, especificamente el JDK17
* [JPA](https://www.ibm.com/docs/es/was-liberty/nd?topic=liberty-java-persistence-api-jpa) - Acceso a la base de datos
* [Maven](https://maven.apache.org/) - Manejador de dependencias

## Autor ✒️
* **Jose Enrique Garcia** [Yokidev](https://github.com/Yokidev)
