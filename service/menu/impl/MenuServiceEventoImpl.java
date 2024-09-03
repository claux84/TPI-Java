package ar.com.eventos.service.menu.impl;

import java.time.LocalDateTime;
import java.util.Scanner;

import ar.com.eventos.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;
import ar.com.eventos.service.menu.MenuService;
import ar.com.eventos.service.participante.ParticipanteService;
import ar.com.eventos.util.EntradaUtil;

public class MenuServiceEventoImpl implements MenuService{
    private EventoGastronomicoService eventoGastronomicoService;
    private ParticipanteService participanteService;
    private GestionDeEventosService gestionDeEventosService;

    MenuServiceEventoImpl(EventoGastronomicoService eventoGastronomicoService, ParticipanteService participanteService, GestionDeEventosService gestionDeEventosService){
        this.eventoGastronomicoService = eventoGastronomicoService;
        this.participanteService = participanteService;
        this.gestionDeEventosService = gestionDeEventosService;
    }

   
    @Override
    public void accept(Scanner scanner) {
        int opcion;
        do {
            System.out.println("------------------------------------------");
            System.out.println("Gestión de Eventos");
            System.out.println("---------------------------------");
            System.out.println("\n Ingrese opción : \n");
            System.out.println("1. Crear evento gastronomico");
            System.out.println("2. Inscribir participante ya registrado a un evento gastronómico");
            System.out.println("3. Asignar cheff a un evento gastronómico");
            System.out.println("4. Modificar evento gastronómico (No implementado)");
            System.out.println("5. Cancelar evento gastronómico (No implementado)");
            System.out.println("6. Volver al menú principal"); 
            opcion = EntradaUtil.controlEntradaEnteros(scanner);
        
        
            switch (opcion) {
                case 1:
                    eventoGastronomicoService.crearEvento(scanner);
                    break;
                case 2:
                    System.out.println("Inscripción de un participante ya registrado en un evento gastronómico \n");
                    System.out.println("¿Desea buscar al participante por su dni? S/N");
                    String alternativa = scanner.nextLine();
                    Integer idParticipante = -1;
                    scanner.nextLine();
                    if (alternativa.equalsIgnoreCase("S")) {
                        System.out.println("Ingrese el DNI del participante");
                        String dni = scanner.nextLine();
                        try {
                            idParticipante = participanteService.buscarParticipantePorDni(dni);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Ingrese id del participante");
                        idParticipante = EntradaUtil.controlEntradaEnteros(scanner);
                    }
                    LocalDateTime fechaActual = LocalDateTime.now();
                    gestionDeEventosService.listarEventosDisponibles(fechaActual);
                    System.out.println("Ingrese id del evento gastronómico al cual desea inscribir al participante");
                    Integer idEvento = EntradaUtil.controlEntradaEnteros(scanner);
                    eventoGastronomicoService.inscribirParticipanteAEvento(idEvento, idParticipante); 
                    break; 
                case 3:
                    System.out.println("Asignar Cheff a un evento gastronómico \n");
                    gestionDeEventosService.listarEventos();
                    System.out.println("Ingrese id del evento gastronómico: ");
                    idEvento = EntradaUtil.controlEntradaEnteros(scanner);
                    gestionDeEventosService.listarCheffs();
                    System.out.println("Ingrese id del cheff");
                    Integer idCheff = EntradaUtil.controlEntradaEnteros(scanner);
                    eventoGastronomicoService.asignarCheffAEvento(idEvento, idCheff);   
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
                }
        } while (opcion != 6);
    }
    
}
