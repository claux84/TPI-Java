package ar.com.eventos.domain;

import java.util.concurrent.atomic.AtomicInteger;


public class Persona {
    protected int id;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    protected String nombre;
    protected String apellido;
    protected String dni;

    public Persona( String nombre, String apellido, String dni){
        setId();
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
    }

    public void setId() {
        this.id = atomicInteger.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }



    public String getDni() {
        return dni;
    }
    


}
