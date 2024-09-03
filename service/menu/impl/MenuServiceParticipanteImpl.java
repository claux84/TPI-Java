package ar.com.eventos.service.menu.impl;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ar.com.eventos.domain.Participante;
import ar.com.eventos.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;
import ar.com.eventos.service.menu.MenuService;
import ar.com.eventos.service.participante.ParticipanteService;
import ar.com.eventos.util.EntradaUtil;

public class MenuServiceParticipanteImpl implements MenuService {
    private ParticipanteService participanteService;
    private GestionDeEventosService gestionDeEventosService;
    private EventoGastronomicoService eventoGastronomicoService;

    MenuServiceParticipanteImpl(ParticipanteService participanteService, GestionDeEventosService gestionDeEventosService, EventoGastronomicoService eventoGastronomicoService){
        this.participanteService = participanteService;
        this.gestionDeEventosService = gestionDeEventosService;
        this.eventoGastronomicoService = eventoGastronomicoService;
    }

   
    @Override
    public void accept(Scanner scanner) {
        int opcion;
        do {
            System.out.println("------------------------------------------");
            System.out.println("Gestión de Participantes");
            System.out.println("---------------------------------");
            System.out.println("\n Ingrese opcion : \n");
            System.out.println("1. Inscribir nuevo participante a evento gastronómico");
            System.out.println("2. Editar datos de partipante (No implementado)");
            System.out.println("3. Eliminar participante de un evento Gastronómico(No implementado)");
            System.out.println("4. Volver al menú anterior");

            opcion = EntradaUtil.controlEntradaEnteros(scanner);

            switch (opcion){
                case 1:
                    System.out.println("Inscribir nuevo participante a evento gastronómico \n");
                    LocalDateTime fechaActual = LocalDateTime.now();
                    gestionDeEventosService.listarEventosDisponibles(fechaActual);
                    System.out.println("Ingrese id del evento gastronómico al cual desea inscribir al participante");
                    Integer idEvento = EntradaUtil.controlEntradaEnteros(scanner);
                    Participante participante = participanteService.registrarParticipante(scanner);
                    try{
                        eventoGastronomicoService.inscribirParticipante(idEvento, participante);
                    }catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                    }   
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }

        }while (opcion != 4);
    }

}
