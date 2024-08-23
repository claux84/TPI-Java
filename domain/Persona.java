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
    private String telefono;
    private String correoElectronico;

    public Persona( String nombre, String apellido, String dni, String telefono, String correoElectronico){
        setId();
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
        setTelefono(telefono);
        setCorreoelectronico(correoElectronico);
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
    
    public void setTelefono(String telefono) {
        boolean telefonoValido =validarTelefono(telefono);
        if (telefonoValido) {
            this.telefono = telefono;
        } else {
            System.out.println("Formato de número telefonico invalido");
        }
        
       
        this.telefono = telefono;
    }

    private boolean validarTelefono(String telefono){
        String patronTelefono = "[0-9]{9,10}";
        Pattern patron = Pattern.compile(patronTelefono);
        if (telefono!= null) {
            Matcher coincidencia = patron.matcher(telefono);
            if (coincidencia.matches()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public String getTelefono() {
        return telefono;
    }

    public void setCorreoelectronico(String correoElectronico) {
        boolean correoValido =validarCorreo(correoElectronico);
        if (correoValido) {
            this.correoElectronico = correoElectronico;
        } else {
            System.out.println("Formato de correo electronico invalido");
        }
        
        this.correoElectronico = correoElectronico;
    }

    private boolean validarCorreo(String correoElectronico){
        String patronCorreo = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern patron = Pattern.compile(patronCorreo);
        if (correoElectronico != null) {
            Matcher coincidencia = patron.matcher(correoElectronico);
            if (coincidencia.matches()) {
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }

    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }


}
