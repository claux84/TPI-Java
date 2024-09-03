package ar.com.eventos.service.eventogastronomico.impl;

import java.time.LocalDateTime;
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
import ar.com.eventos.service.resenia.ReseniaService;
import ar.com.eventos.util.EntradaUtil;

public class EventoGastronomicoServiceImpl implements EventoGastronomicoService{
    private GestionDeEventosService gestionDeEventosService;
    private ParticipanteService participanteService;
    private CheffService cheffService;
    private ReseniaService reseniaService;

    public EventoGastronomicoServiceImpl(GestionDeEventosService gestionDeEventosService, ParticipanteService participanteService, CheffService cheffService, ReseniaService reseniaService){
        this.gestionDeEventosService = gestionDeEventosService;
        this.participanteService = participanteService;
        this.cheffService = cheffService;
        this.reseniaService = reseniaService;
    }

    @Override
    public EventoGastronomico crearEvento(Scanner scanner) {
        System.out.println("Crear nuevo evento Gastronómico");
        System.out.println("---------------------------------");
        System.out.println("Ingrese el nombre del evento gastronómico: ");
        String nombre = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Ingrese la descripción del evento gastronómico: ");
        String descripcion = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Ingrese la fecha y hora en la que se realizara el evento gastronómico (formato: 01/01/2024 12:00 ): ");
        LocalDateTime fechaYHora = EntradaUtil.controlEntradaFecha(scanner);
        System.out.println("Ingrese la ubicación del evento gastronómico: ");
        String ubicacion = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Ingrese la capacidad maxima de participantes del evento gastronómico: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        List<Resenia> resenias = new ArrayList<>();
        Map<Integer, Participante> participantes = new TreeMap<>();
        EventoGastronomico nuevoEventoGastronomico = new EventoGastronomico(nombre, descripcion, fechaYHora, ubicacion, capacidad, null, resenias, participantes);
        gestionDeEventosService.getEventos().add(nuevoEventoGastronomico);
        System.out.println(" ############## Evento gastronómico creado ###########################");
        return nuevoEventoGastronomico;
    }

    @Override
    public void inscribirParticipante(Integer idEvento, Participante participante) {
        int index = -1;
        try {
            index = buscarEventoGastronomico(idEvento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        if (index != -1) {
            int capacidad = gestionDeEventosService.getEventos().get(index).getCapacidad();
            int cantidadDeParticipantes = gestionDeEventosService.getEventos().get(index).cantidadDeParticipantes();
            if (cantidadDeParticipantes <= capacidad ) {
                gestionDeEventosService.getEventos().get(index).getParticipantes().put(participante.getId(), participante);
                System.out.println("########### Participante inscripto a evento gastronómico ################");
            } else {
                System.out.println("El participante no se pudo inscribir al evento gastronómico porque alcanzo su capacidad maxima");
            }
        }
    }

    @Override
    public void inscribirParticipanteAEvento(Integer idEvento, Integer idParticipante) {
        Participante participante = null;
        int index = -1;
        try {
            participante= participanteService.buscarParticipante(idParticipante);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        try {
            index = buscarEventoGastronomico(idEvento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        if (participante != null  && index != -1) {
            int capacidad = gestionDeEventosService.getEventos().get(index).getCapacidad();
            int cantidadDeParticipantes = gestionDeEventosService.getEventos().get(index).cantidadDeParticipantes();
            try {
                buscarParticipanteEnEvento(idParticipante, index); 
                System.out.println("El participante ya se encuentra inscripto en el evento");
            } catch (Exception e) {
                if (cantidadDeParticipantes <= capacidad ) {
                    participante.setHistorialDeEventos(participanteService.crearHistorial(idParticipante));
                    participante.getHistorialDeEventos().add(gestionDeEventosService.getEventos().get(index));
                    gestionDeEventosService.getEventos().get(index).getParticipantes().put(participante.getId(), participante);
                    System.out.println("############# Participante inscripto a evento gastronómico ################");   
                } else {
                    System.out.println("El participante no se pudo inscribir al evento gastronómico porque alcanzo su capacidad maxima");
                }
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
                System.out.println("########  Cheff asignado a evento gastronómico #####################");
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
            if (id.equals(idEvento)){
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
    public void agregarReseniaDeParticipanteAEvento(Integer idEvento, Integer idParticipante, Scanner scanner ) {
        int index = -1;
        try {
            index = buscarEventoGastronomico(idEvento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        if (index > -1) {
            EventoGastronomico eventoGastronomico = gestionDeEventosService.getEventos().get(index);      
            if (eventoGastronomico.getFechaYHora().isBefore(LocalDateTime.now())) {
                try {
                    Participante participante= buscarParticipanteEnEvento(idParticipante, index);
                    Resenia resenia = reseniaService.crearResenia(participante,eventoGastronomico, scanner);
                    gestionDeEventosService.getEventos().get(index).getResenias().add(resenia);
                    System.out.println("Reseña a evento gastronómico creada");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } 
            }else {
                System.out.println("El evento gastronómico seleccionado aun no se ha realizado");
            } 
        }
        
    }

    @Override
    public void listarParticipantesDeEvento(Integer idEvento) {
        int index = -1;
        try {
            index = buscarEventoGastronomico(idEvento);
        } catch (Exception e) {
            System.out.println(e.getMessage());  
        }
        if (index > -1) {
            if (gestionDeEventosService.getEventos().get(index).getParticipantes().size() == 0) {
                System.out.println(" El evento gastronómico no posee participantes");  
            } else {
                System.out.println("Lista de participantes del evento " + gestionDeEventosService.getEventos().get(index).getNombre());
                System.out.println(" ---------------------------------------------------------------------------------");
                for (Participante participante : gestionDeEventosService.getEventos().get(index).getParticipantes().values()) {
                    System.out.println(participante.toString());
                } 
            }
        }
    }

    @Override
    public void listarReseniasDeEvento(Integer idEvento) {
        int index = -1;
        try {
            index = buscarEventoGastronomico(idEvento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (index > -1) {
            if (gestionDeEventosService.getEventos().get(index).getResenias().size() == 0){
                System.out.println("\n El evento gastronómico no posee reseñas\n");
            } else {
                System.out.println("Lista de reseñas del evento " + gestionDeEventosService.getEventos().get(index).getNombre());
                System.out.println(" ---------------------------------------------------------------------------------");
                for (Resenia resenia : gestionDeEventosService.getEventos().get(index).getResenias()) {
                    System.out.println(resenia.toString());
                }
            }
        }   
    }
        

    @Override
    public Participante buscarParticipanteEnEvento(Integer idParticipante, int index) {
        Participante participante = null;
        boolean existeElParticipante = Boolean.FALSE;
        EventoGastronomico eventoGastronomico = gestionDeEventosService.getEventos().get(index);
        if (eventoGastronomico.getParticipantes().containsKey(idParticipante)){
            participante = eventoGastronomico.getParticipantes().get(idParticipante);
            existeElParticipante = Boolean.TRUE;  
        }
        if (!existeElParticipante){
            throw new NoSuchElementException("No existe el participante");
        }else{
            return participante;
        }
    }
      

}
