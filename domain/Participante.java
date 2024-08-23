package ar.com.eventos.domain;

import java.util.*;

public class Participante extends Persona{
    private String interesesCulinarios;
    private List<EventoGastronomico> historialDeEventos = new ArrayList<>(); 

    public Participante(String nombre, String apellido, String dni, String telefono, String correoelectronico, String interesesCulinarios, List<EventoGastronomico> historialDeEventos){
        super(nombre, apellido, dni, telefono, correoelectronico);
        setInteresesCulinarios(interesesCulinarios);
        setHistorialDeEventos(historialDeEventos);
    }

    public void setInteresesCulinarios(String interesesCulinarios) {
        this.interesesCulinarios = interesesCulinarios;
    }
    public String getInteresesCulinarios() {
        return interesesCulinarios;
    }
    public void setHistorialDeEventos(List<EventoGastronomico> historialDeEventos) {
        this.historialDeEventos = historialDeEventos;
    }
    public List<EventoGastronomico> getHistorialDeEventos() {
        return historialDeEventos;
    }  



    @Override
    public String toString(){
        return  "ID: " + this.getId()
                + "Nombre y Apellido : " + this.getNombre() + " " + this.getApellido()
                + " DNI: " + this.getDni()
                + " Telefono : " + this.getTelefono()
                + " Correo electronico : " + this.getCorreoElectronico()
                + " Intereses Culinarios : " + this.interesesCulinarios;

    }
}