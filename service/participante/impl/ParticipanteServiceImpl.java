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
    public Participante registrarParticipante() {
        Participante nuevoParticipante = new Participante(null, null, null, null, null);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del participante: ");
        String nombreParticipante = scanner.nextLine();
        scanner.nextLine();
        nuevoParticipante.setNombre(nombreParticipante);

        System.out.println("Ingrese el apellido del participante: ");
        String apellidoParticipante = scanner.nextLine();
        scanner.nextLine();
        nuevoParticipante.setApellido(apellidoParticipante);

        System.out.println("Ingrese el dni del participante: ");
        String dniParticipante = scanner.nextLine();
        nuevoParticipante.setDni(dniParticipante);
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

            interesesCulinarios.add(
                switch (opcion){
                    case 1 -> TiposDeCocinaEnum.PANADERIA;
                    case 2 -> TiposDeCocinaEnum.PASTELERIA;
                    case 3 -> TiposDeCocinaEnum.COCINA_NACIONAL;
                    case 4 -> TiposDeCocinaEnum.COCINA_INTERNACIONAL;
                    case 5 -> TiposDeCocinaEnum.BAR_Y_COCTELERIA;
                    default -> null;
                }
        );
        } while (opcion != 6);
        nuevoParticipante.setInteresesCulinarios(interesesCulinarios);
        List<EventoGastronomico> historialDeEventos = new ArrayList<>();
        nuevoParticipante.setHistorialDeEventos(historialDeEventos);        
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
                break;
            }
        }
        if (!existeElParticipante){
            throw new NoSuchElementException("No existe el participante");
        }
        return participante;
    }

    @Override
    public Participante buscarParticipantePorDni(String dniParticipante) {
        Boolean existeParticipante = Boolean.FALSE;
        Participante participanteBuscado = null;
        for (EventoGastronomico eventoGastronomico: gestionDeEventosService.getEventos()){
            for (Participante participante : eventoGastronomico.getParticipantes().values()) {
                if (dniParticipante.equals(participante.getDni())) {
                    participanteBuscado = participante;
                }   
            }
        }
        if (!existeParticipante){
            throw new NoSuchElementException("No existe el participante");
        }
        return participanteBuscado;
    }

}
