package ar.com.eventos.service.menu.impl;

import java.time.LocalDateTime;
import java.util.Scanner;


import ar.com.eventos.service.archivos.ArchivosEventosService;
import ar.com.eventos.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;
import ar.com.eventos.service.menu.MenuService;
import ar.com.eventos.util.EntradaUtil;

public class MenuServiceListadoImpl implements MenuService{
    private GestionDeEventosService gestionDeEventosService;
    private EventoGastronomicoService eventoGastronomicoService;
    private ArchivosEventosService archivosEventosService;

    public MenuServiceListadoImpl(GestionDeEventosService gestionDeEventosService, EventoGastronomicoService eventoGastronomicoService, ArchivosEventosService archivosEventosService){
        this.gestionDeEventosService = gestionDeEventosService;
        this.eventoGastronomicoService = eventoGastronomicoService;
        this.archivosEventosService = archivosEventosService;
    }

    
    @Override
    public void accept(Scanner scanner) {
        int opcion;
        do {
            System.out.println("------------------------------------------");
            System.out.println("Listados y exportación de archivos");
            System.out.println("---------------------------------");
            System.out.println("Ingrese opcion : \n");
            System.out.println("1. Listar eventos disponibles a partir de una fecha dada");
            System.out.println("2. Listar eventos no disponibles a partir de una fecha dada");
            System.out.println("3. Listar todos los eventos");
            System.out.println("4. Listar eventos ya realizados");
            System.out.println("5. Listar cheffs");
            System.out.println("6. Listar participantes de un evento");
            System.out.println("7. Listar reseñas de un evento");
            System.out.println("8. Exportar eventos no disponibles a partir de una fecha dada");
            System.out.println("9. Volver al menú anterior");

            opcion = EntradaUtil.controlEntradaEnteros(scanner);

            switch (opcion){
                case 1:
                    System.out.println("Desea el listado de eventos disponibles a partir de la fecha actual?S/N");
                    String alternativa = scanner.nextLine();
                    scanner.nextLine();
                    LocalDateTime fechaYHora;
                    if (alternativa.equalsIgnoreCase("S")) {
                        fechaYHora = LocalDateTime.now();
                    } else {
                        System.out.println("Ingrese la fecha y hora a partir de la cual necesita la lista (formato: 01-01-2024 12:00 ): ");
                        fechaYHora = EntradaUtil.controlEntradaFecha(scanner);
                    }
                    gestionDeEventosService.listarEventosDisponibles(fechaYHora);
                    break;
                case 2:
                    System.out.println("Desea el listado de eventos no disponibles a partir de la fecha actual?S/N");
                    alternativa = scanner.nextLine();
                    scanner.nextLine();
                    if (alternativa.equalsIgnoreCase("S")) {
                        fechaYHora = LocalDateTime.now();
                    } else {
                        System.out.println("Ingrese la fecha y hora a partir de la cual necesita la lista (formato: 01-01-2024 12:00 ): ");
                        fechaYHora = EntradaUtil.controlEntradaFecha(scanner);
                    }
                    gestionDeEventosService.listarEventosNoDisponibles(fechaYHora);
                    break;
                case 3:
                    gestionDeEventosService.listarEventos();
                    break;
                case 4:
                    gestionDeEventosService.listarEventosRealizados();
                    break;
                case 5:
                    gestionDeEventosService.listarCheffs();
                    break;
                case 6:
                    gestionDeEventosService.listarEventos();
                    System.out.println("Ingrese id del evento gastronómico");
                    int idEvento = EntradaUtil.controlEntradaEnteros(scanner);
                    eventoGastronomicoService.listarParticipantesDeEvento(idEvento); 
                    break;
                case 7:
                    gestionDeEventosService.listarEventosRealizados();
                    System.out.println("Ingrese id del evento gastronómico");
                    idEvento = EntradaUtil.controlEntradaEnteros(scanner);
                    eventoGastronomicoService.listarReseniasDeEvento(idEvento);
                    break;
                case 8: 
                    archivosEventosService.exportarEventosCsv(gestionDeEventosService.getEventos());
                    break;
                case 9:
                    break;
                default:
                    break;
            }
        }while (opcion != 9);
    }
}
    
