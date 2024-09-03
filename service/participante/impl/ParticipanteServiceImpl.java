package ar.com.eventos.service.participante.impl;

import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;
import ar.com.eventos.service.participante.ParticipanteService;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.enumeration.TiposDeCocinaEnum;

public class ParticipanteServiceImpl implements ParticipanteService{
    private GestionDeEventosService gestionDeEventosService;

    public ParticipanteServiceImpl( GestionDeEventosService gestionDeEventosService){
        this.gestionDeEventosService = gestionDeEventosService;
    }



    @Override
    public Participante registrarParticipante(Scanner scanner) {

        System.out.println("Ingrese el nombre del participante: ");
        String nombreParticipante = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese el apellido del participante: ");
        String apellidoParticipante = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese el dni del participante: ");
        String dniParticipante = scanner.nextLine();
        scanner.nextLine();

        Set<TiposDeCocinaEnum> interesesCulinarios = new HashSet<>();
        int opcion;
        do {
            System.out.println("Ingrese los intereses culinarios del Participante (puede seleccionar mas de uno)");
            System.out.println("1. Panaderia");
            System.out.println("2. Pasteleria");
            System.out.println("3. Cocina Nacional");
            System.out.println("4. Cocina Internacional");
            System.out.println("5. Bar y Cocteleria");
            System.out.println("6. Finalizar elección");

            opcion= scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: interesesCulinarios.add(TiposDeCocinaEnum.PANADERIA);
                    break;
                case 2: interesesCulinarios.add(TiposDeCocinaEnum.PASTELERIA);
                    break;
                case 3: interesesCulinarios.add(TiposDeCocinaEnum.COCINA_NACIONAL);
                    break;
                case 4: interesesCulinarios.add(TiposDeCocinaEnum.COCINA_INTERNACIONAL);
                    break;
                case 5: interesesCulinarios.add(TiposDeCocinaEnum.BAR_Y_COCTELERIA);
                    break;
                default:
                    break;
            }
        } while (opcion != 6);
        List<EventoGastronomico> historialDeEventos = new ArrayList<>();
        Participante nuevoParticipante = new Participante(nombreParticipante, apellidoParticipante, dniParticipante, interesesCulinarios, historialDeEventos);        
        return nuevoParticipante;
    }
    @Override
    public Participante buscarParticipante(Integer idParticipante) {
        Participante participante = null;
        boolean existeElParticipante = Boolean.FALSE;
        for (EventoGastronomico eventoGastronomico: gestionDeEventosService.getEventos()){
            if (eventoGastronomico.getParticipantes().containsKey(idParticipante)){
                participante = eventoGastronomico.getParticipantes().get(idParticipante);
                existeElParticipante = Boolean.TRUE;  
            }
        }
        if (!existeElParticipante){
            throw new NoSuchElementException("No existe el participante");
        }
        return participante;
    }

    @Override
    public Integer buscarParticipantePorDni(String dniParticipante) {
        Boolean existeParticipante = Boolean.FALSE;
        Integer participanteBuscado = null;
        for (EventoGastronomico eventoGastronomico: gestionDeEventosService.getEventos()){
            for (Participante participante : eventoGastronomico.getParticipantes().values()) {
                if (dniParticipante.equals(participante.getDni())) {
                    participanteBuscado = participante.getId();
                    existeParticipante = Boolean.TRUE;
                }   
            }
        }
        if (!existeParticipante){
            throw new NoSuchElementException("No existe el participante");
        }
        return participanteBuscado;
    }

    public List<EventoGastronomico> crearHistorial(Integer idParticipante) {
        List<EventoGastronomico> historialDeEventoGastronomicos = new ArrayList<>();
        boolean poseeHistorial = Boolean.FALSE;
        for (EventoGastronomico eventoGastronomico: gestionDeEventosService.getEventos()){
            if (eventoGastronomico.getParticipantes().containsKey(idParticipante)){
                historialDeEventoGastronomicos.add(eventoGastronomico); 
                poseeHistorial = Boolean.TRUE;  
            }
        }
        if (!poseeHistorial){
            throw new NoSuchElementException("No posee historial");
        }
        return historialDeEventoGastronomicos;
    }

}
