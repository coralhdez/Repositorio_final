package dominio;

import java.util.*;

public class EmpleadoDTO {

    private int idEmpleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String email;
    private int cat;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    //Para insertar nuevos empleados, como el id es AI se rellena solo
    public EmpleadoDTO(String nombre, String apellido1, String apellido2, String dni, String email, int cat) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.email = email;
        this.cat = cat;
    }

    public EmpleadoDTO(int idEmpleado, String nombre, String apellido1, String apellido2, String dni, String email, int cat) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.email = email;
        this.cat = cat;

    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

   

    @Override
    public String toString() {
        return "EmpleadoDTO{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni + ", email=" + email + ", cat=" + cat + '}';
    }

}
