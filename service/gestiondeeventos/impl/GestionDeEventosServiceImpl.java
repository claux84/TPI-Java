package ar.com.eventos.service.gestiondeeventos.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import ar.com.eventos.domain.Cheff;
import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.domain.GestionDeEventos;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;

public class GestionDeEventosServiceImpl implements GestionDeEventosService{
    private GestionDeEventos gestionDeEventos;
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
        System.out.println("-------------------------------------------------------------------------------");
        Boolean existeEvento = Boolean.FALSE;
        for (EventoGastronomico eventoGastronomico : gestionDeEventos.getEventosGastronomicos()) {
            if (eventoGastronomico.getFechaYHora().isAfter(fechaYHora) && eventoGastronomico.getParticipantes().size() < eventoGastronomico.getCapacidad()) {
                System.out.println(eventoGastronomico.toString());
                existeEvento = Boolean.TRUE;
            }
        }
        if (!existeEvento) {
            System.out.println("No hay eventos no disponibles");
        }
              
    }

    @Override
    public void listarEventosNoDisponibles(LocalDateTime fechaYHora) {
        System.out.println("Listado de eventos gastronómicos no disponibles a partir de " + fechaYHora.toString());
        System.out.println("-------------------------------------------------------------------------------");
        Boolean existeEvento = Boolean.FALSE;
        for (EventoGastronomico eventoGastronomico : gestionDeEventos.getEventosGastronomicos()) {
            if (eventoGastronomico.getFechaYHora().isAfter(fechaYHora) && eventoGastronomico.getParticipantes().size() == eventoGastronomico.getCapacidad()) {
                System.out.println(eventoGastronomico.toString());
                existeEvento = Boolean.TRUE;
            }
        }
        if (!existeEvento) {
            System.out.println("No hay eventos disponibles");
        }      
    }


    @Override
    public void listarEventos() {
        
        if (gestionDeEventos.getEventosGastronomicos().size() == 0) {
            System.out.println("No hay eventos");
            
        } else {
            System.out.println("Listado de todos los eventos gastronómicos");
            System.out.println("-------------------------------------------------------------------------------");
            for (EventoGastronomico eventoGastronomico : gestionDeEventos.getEventosGastronomicos()) {
                System.out.println(eventoGastronomico.toString());
            }       
        }
            
    }
        

    @Override
    public void listarEventosRealizados() {
        LocalDateTime fechaYHora = LocalDateTime.now();
        System.out.println("Listado de los eventos gastronómicos ya realizados");
        System.out.println("-------------------------------------------------------------------------------");
        Boolean existeEvento = Boolean.FALSE; 
        for (EventoGastronomico eventoGastronomico : gestionDeEventos.getEventosGastronomicos()) {
            if (eventoGastronomico.getFechaYHora().isBefore(fechaYHora)) {
                System.out.println(eventoGastronomico.toString());
                existeEvento = Boolean.TRUE;
            }
        }
        if (!existeEvento) {
            System.out.println("No hay eventos ya realizados");
        }   
    }



    @Override
    public void listarCheffs() {
        
        if (gestionDeEventos.getCheffs().size() == 0) {
            System.out.println("No hay cheffs");
        } else {
            System.out.println("Lista de cheffs");
            System.out.println("----------------------------");
            for (Cheff cheff : gestionDeEventos.getCheffs().values()) {
                System.out.println(cheff.toString());
            }
        }
        System.out.println("----------------------------");
        
    }


}
