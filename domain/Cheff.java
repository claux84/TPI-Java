package ar.com.eventos.domain;

import java.util.*;

import ar.com.eventos.enumeration.TiposDeCocinaEnum;

public class Cheff extends Persona {
    private TiposDeCocinaEnum especialidad;
    private List<EventoGastronomico> eventos = new ArrayList<>();

    public Cheff(String nombre, String apellido, String dni, TiposDeCocinaEnum especialidad, List<EventoGastronomico> eventos){
        super(nombre, apellido, dni);
        setEspecialidad(especialidad);
        setEventos(eventos);
    }

    public void setEspecialidad(TiposDeCocinaEnum especialidad) {
        this.especialidad = especialidad;
    }
    public TiposDeCocinaEnum getEspecialidad() {
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
                + " Especialidad: " + this.especialidad
                + " Eventos Asignados: " + this.eventos.toString();
    }
}

    