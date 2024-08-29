package ar.com.eventos.service.eventogastronomico.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

import ar.com.eventos.domain.Cheff;
import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.domain.Resenia;
import ar.com.eventos.service.cheff.CheffService;
import ar.com.eventos.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;
import ar.com.eventos.service.participante.ParticipanteService;

public class EventoGastronomicoServiceImpl implements EventoGastronomicoService{
    private GestionDeEventosService gestionDeEventosService;
    private ParticipanteService participanteService;
    private CheffService cheffService;

    public EventoGastronomicoServiceImpl(GestionDeEventosService gestionDeEventosService, ParticipanteService participanteService, CheffService cheffService){
        this.gestionDeEventosService = gestionDeEventosService;
        this.participanteService = participanteService;
        this.cheffService = cheffService;
    }





    @Override
    public EventoGastronomico crearEvento(Scanner scanner) {
        EventoGastronomico nuevoEventoGastronomico = new EventoGastronomico();
        
        System.out.println("Crear nuevo evento Gastronómico");
        System.out.println("---------------------------------");

        nuevoEventoGastronomico.setId();
        System.out.println("Ingrese el nombre del evento gastronómico: ");
        String nombre = scanner.nextLine();
        scanner.nextLine();
        nuevoEventoGastronomico.setNombre(nombre);
        System.out.println("Ingrese la descripción del evento gastronómico: ");
        String descripcion = scanner.nextLine();
        scanner.nextLine();
        nuevoEventoGastronomico.setDescripcion(descripcion);
        System.out.println("Ingrese la fecha y hora en la que se realizara el evento gastronómico (formato: 01-01-2024 12:00 ): ");
        String fechaString = scanner.nextLine();
        scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime fechaYHora = LocalDateTime.parse(fechaString, formatter);
        nuevoEventoGastronomico.setFechaYHora(fechaYHora);
        System.out.println("Ingrese la ubicación del evento gastronómico: ");
        String ubicacion = scanner.nextLine();
        scanner.nextLine();
        nuevoEventoGastronomico.setUbicacion(ubicacion);
        System.out.println("Ingrese la capacidad maxima de participantes del evento gastronómico: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        nuevoEventoGastronomico.setCapacidad(capacidad);
        List<Resenia> resenias = new ArrayList<>();
        nuevoEventoGastronomico.setResenias(resenias);
        Map<Integer, Participante> participantes = new TreeMap<>();
        nuevoEventoGastronomico.setParticipantes(participantes);
        gestionDeEventosService.getEventos().add(nuevoEventoGastronomico);
        System.out.println("Evento gastronómico creado");
        return nuevoEventoGastronomico;
    }

    @Override
    public void listarEventos() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void inscribirParticipante(Integer idEvento) {
        Participante participante = participanteService.registrarParticipante();
        try {
            int index = buscarEventoGastronomico(idEvento);
            gestionDeEventosService.getEventos().get(index).getParticipantes().put(participante.getId(), participante);
            System.out.println("Participante inscripto a evento gastronómico");
        } catch (Exception e) {
                System.out.println(e.getMessage());
        } 
    }

    @Override
    public void inscribirParticipanteAEvento(Integer idEvento, Integer idParticipante) {
        Participante participante = null;
        try {
            participante= participanteService.buscarParticipante(idParticipante);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (participante != null) {
            try {
                int index = buscarEventoGastronomico(idEvento);
                gestionDeEventosService.getEventos().get(index).getParticipantes().put(participante.getId(), participante);
                System.out.println("Participante inscripto a evento gastronómico");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } 
        } 
    }

    @Override
    public void asignarCheffAEvento(Integer idEvento, Integer idCheff) {
        Cheff cheff = null;
        try {
            cheff = cheffService.buscarCheff(idCheff);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (cheff != null){
            try {
                int index = buscarEventoGastronomico(idEvento);
                gestionDeEventosService.getEventos().get(index).setCheff(cheff);
                gestionDeEventosService.getCheffs().get(idCheff).getEventos().add(gestionDeEventosService.getEventos().get(index));
                System.out.println("Cheff asignado a evento gastronómico");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        
    }

    @Override
    public int buscarEventoGastronomico(Integer idEvento) {
        int index = -1;
        boolean existeEvento = Boolean.FALSE;
        for (EventoGastronomico eventoGastronomico: gestionDeEventosService.getEventos()){
            Integer id = Integer.valueOf(eventoGastronomico.getId());
            if (id.equals(Integer.valueOf(idEvento))){
                index = gestionDeEventosService.getEventos().indexOf(eventoGastronomico);
                existeEvento = Boolean.TRUE;
                break;
            }
        }
        if (!existeEvento){
            throw new NoSuchElementException("No existe el evento gastronómico");
        }else {
            return index;
        }
    }

    @Override
    public void agregarReseniaDeParticipanteAEvento() {
        // TODO Auto-generated method stub
        
    }

}
