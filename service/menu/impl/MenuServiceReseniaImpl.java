package ar.com.eventos.service.menu.impl;


import java.util.Scanner;

import ar.com.eventos.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;
import ar.com.eventos.service.menu.MenuService;
import ar.com.eventos.service.participante.ParticipanteService;
import ar.com.eventos.util.EntradaUtil;

public class MenuServiceReseniaImpl implements MenuService{
    private ParticipanteService participanteService;
    private GestionDeEventosService gestionDeEventosService;
    private EventoGastronomicoService eventoGastronomicoService;

    MenuServiceReseniaImpl(ParticipanteService participanteService, GestionDeEventosService gestionDeEventosService, EventoGastronomicoService eventoGastronomicoService){
        this.participanteService = participanteService;
        this.gestionDeEventosService = gestionDeEventosService;
        this.eventoGastronomicoService = eventoGastronomicoService;
    }

   
    @Override
    public void accept(Scanner scanner) {
        int opcion;
        do {
            System.out.println("------------------------------------------");
            System.out.println("Gestión de Resenias");
            System.out.println("---------------------------------");
            System.out.println("Ingrese opcion : \n");
            System.out.println("1. Cargar reseña de un evento gastronomico realizada por un participante");
            System.out.println("2. Editar reseña de un evento gastronomico realizada por un participante (No implementado)");
            System.out.println("3. Eliminar reseña de un evento gastronomico realizada por un participante (No implementado)");
            System.out.println("4. Volver al menú anterior");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Cargar reseña de un evento gastronomico realizada por un participante");
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
                    gestionDeEventosService.listarEventosRealizados();
                    System.out.println("Ingrese id del evento gastronómico");
                    Integer idEvento = EntradaUtil.controlEntradaEnteros(scanner);  
                    eventoGastronomicoService.agregarReseniaDeParticipanteAEvento(idEvento, idParticipante, scanner);
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
