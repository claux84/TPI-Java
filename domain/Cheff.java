package ar.com.eventos.domain;

import java.util.*;

public class Cheff extends Persona {
    private String especialidad;
    private List<EventoGastronomico> eventos = new ArrayList<>();

    public Cheff(String nombre, String apellido, String dni, String telefono, String correoelectronico, String especialidad, List<EventoGastronomico> eventos){
        super(nombre, apellido, dni, telefono, correoelectronico);
        setEspecialidad(especialidad);
        setEventos(eventos);
    }

    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEventos(List<EventoGastronomico> eventos) {
        this.eventos = eventos;
    }
    public List<EventoGastronomico> getEventos() {
        return eventos;
    }

    @Override
    public String toString(){
        return  "ID: " + this.getId()
                + " Nombre y Apellido : " + this.getNombre() + " " + this.getApellido()
                + " DNI: " + this.getDni()
                + " Telefono : " + this.getTelefono()
                + " Correo electronico : " + this.getCorreoElectronico()
                + " Especialidad: " + this.especialidad;
    }
}