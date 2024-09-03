package ar.com.eventos.domain;

import java.util.*;

import ar.com.eventos.enumeration.TiposDeCocinaEnum;

public class Participante extends Persona{
    private Set<TiposDeCocinaEnum> interesesCulinarios = new HashSet<>();
    private List<EventoGastronomico> historialDeEventos = new ArrayList<>(); 

    public Participante(String nombre, String apellido, String dni, Set<TiposDeCocinaEnum> interesesCulinarios, List<EventoGastronomico> historialDeEventos){
        super(nombre, apellido, dni);
        setInteresesCulinarios(interesesCulinarios);
        setHistorialDeEventos(historialDeEventos);
    }
    public void setInteresesCulinarios(Set<TiposDeCocinaEnum> interesesCulinarios) {
        this.interesesCulinarios = interesesCulinarios;
    }
    public Set<TiposDeCocinaEnum> getInteresesCulinarios() {
        return interesesCulinarios;
    }

    public void setHistorialDeEventos(List<EventoGastronomico> historialDeEventos) {
        this.historialDeEventos = historialDeEventos;
    }
    public List<EventoGastronomico> getHistorialDeEventos() {
        return historialDeEventos;
    }  

    private String historialToString(){
        String toString = null;
        for (EventoGastronomico eventoGastronomico : this.historialDeEventos) {
            toString = "Nombre: " + eventoGastronomico.getNombre()
                        + " Descripción: " + eventoGastronomico.getDescripcion()
                        + "Fecha y Hora: " + eventoGastronomico.getFechaYHora();
        }
        return toString;
    }

   


    @Override
    public String toString(){
        return  "ID: " + this.getId()
                + " Nombre y Apellido : " + this.getNombre() + " " + this.getApellido()
                + " DNI: " + this.getDni()
                + " Intereses Culinarios : " + this.interesesCulinarios.toString()
                + " Historial de Eventos: " + historialToString();

    }
}