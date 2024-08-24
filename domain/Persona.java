package ar.com.eventos.domain;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
    private int id;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private String nombre;
    private String apellido;
    private String dni;

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
        boolean dniValido = validarDni(dni);
        if (dniValido) {
            this.dni = dni;
        } else {
            System.out.println(" DNI invalido");
        }
    }

    private boolean validarDni(String dni){
        String patronDni = "[0-9]{7,8}";
        Pattern patron = Pattern.compile(patronDni);
        if (dni!= null) {
            Matcher coincidencia = patron.matcher(dni);
            if (coincidencia.matches()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public String getDni() {
        return dni;
    }
    


}
