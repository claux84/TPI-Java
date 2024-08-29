package ar.com.eventos.service.gestiondeeventos.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import ar.com.eventos.domain.Cheff;
import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.domain.GestionDeEventos;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;

public class GestionDeEventosServiceImpl implements GestionDeEventosService{
    GestionDeEventos gestionDeEventos;

    public GestionDeEventosServiceImpl (GestionDeEventos gestionDeEventos){
        this.gestionDeEventos = gestionDeEventos;
    }



    @Override
    public List<EventoGastronomico> getEventos() {
        return this.gestionDeEventos.getEventosGastronomicos();
    }

    @Override
    public Map<Integer, Cheff> getCheffs() {
        return this.gestionDeEventos.getCheffs();
    }

    @Override
    public void listarEventosDisponibles(LocalDateTime fechaYHora) {
        System.out.println("Listado de eventos gastronómicos disponibles a partir de " + fechaYHora.toString());
        for (EventoGastronomico eventoGastronomico : gestionDeEventos.getEventosGastronomicos()) {
            if (eventoGastronomico.getFechaYHora().isAfter(fechaYHora) && eventoGastronomico.getParticipantes().size() <= eventoGastronomico.getCapacidad()) {
                System.out.println(eventoGastronomico.toString());
            }

        }      
    }
    @Override
    public void listarEventos() {
        System.out.println("Listado de eventos gastronómicos");
        LocalDateTime fechaYHora = LocalDateTime.now();
        for (EventoGastronomico eventoGastronomico : gestionDeEventos.getEventosGastronomicos()) {
            if (eventoGastronomico.getFechaYHora().isAfter(fechaYHora) ) {
                System.out.println(eventoGastronomico.toString());
            }

        }       
    }

    @Override
    public void listarCheff() {
        System.out.println("Lista de cheffs");

        for (Cheff cheff : gestionDeEventos.getCheffs().values()) {
            System.out.println(cheff.toString());
        }
        
    }


}
