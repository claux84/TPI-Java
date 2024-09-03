package ar.com.eventos.service.menu.impl;


import ar.com.eventos.service.menu.MenuService;
import ar.com.eventos.service.participante.ParticipanteService;
import ar.com.eventos.util.EntradaUtil;
import ar.com.eventos.service.archivos.ArchivosEventosService;
import ar.com.eventos.service.cheff.CheffService;
import ar.com.eventos.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;


import java.util.Scanner;


public class MenuServiceImpl implements MenuService {
    private EventoGastronomicoService eventoGastronomicoService;
    private ArchivosEventosService archivosEventosService;
    private CheffService cheffService;
    private GestionDeEventosService gestionDeEventosService;
    private ParticipanteService participanteService;
    

    public MenuServiceImpl( EventoGastronomicoService eventoGastronomicoService, ArchivosEventosService archivosEventosService, CheffService cheffService, GestionDeEventosService gestionDeEventosService, ParticipanteService participanteService){
        this.eventoGastronomicoService = eventoGastronomicoService;
        this.archivosEventosService = archivosEventosService;
        this.cheffService = cheffService;
        this.gestionDeEventosService = gestionDeEventosService;
        this.participanteService = participanteService;
    }

    @Override
    public void accept(Scanner scanner) {
        MenuServiceManagerImpl menuManager = new MenuServiceManagerImpl();
        MenuService menuEvento = new MenuServiceEventoImpl(eventoGastronomicoService, participanteService, gestionDeEventosService);
        MenuService menuParticipante = new MenuServiceParticipanteImpl(participanteService, gestionDeEventosService, eventoGastronomicoService);
        MenuService menuCheff = new MenuServiceCheffImpl(cheffService);
        MenuService menuResenia = new MenuServiceReseniaImpl(participanteService, gestionDeEventosService, eventoGastronomicoService);
        MenuService menuListado = new MenuServiceListadoImpl(gestionDeEventosService, eventoGastronomicoService, archivosEventosService);

        System.out.println("------------------------------------------");
        System.out.println("Gestión de Eventos Gastronómicos");
        System.out.println("------------------------------------------");
        int opcion;
        do {
            System.out.println("\n Ingrese opcion : \n");
            System.out.println("1. Gestionar evento gastronómico");
            System.out.println("2. Gestionar participante");
            System.out.println("3. Gestionar cheff");
            System.out.println("4. Gestionar reseñas");
            System.out.println("5. Listados y archivos");
            System.out.println("6. Finalizar aplicación");

            opcion = EntradaUtil.controlEntradaEnteros(scanner);

            switch (opcion){
                case 1:
                    menuManager.accept(scanner, menuEvento);
                    break;
                case 2:
                    menuManager.accept(scanner, menuParticipante);
                    break;
                case 3:
                    menuManager.accept(scanner, menuCheff);
                    break;
                case 4:
                    menuManager.accept(scanner, menuResenia);
                    break;
                case 5:
                    menuManager.accept(scanner, menuListado);
                    break;
                case 6:
                    System.out.println("\n Aplicacion finalizada");
                    break;
                default:
                    break;
            }

        }while (opcion != 6);
        
        
    }
   
   
    // private LocalDateTime controlEntradaFecha(Scanner scanner){
    //     LocalDateTime fechaYHora = null;
    //     try {
    //         String fechaString = scanner.nextLine();
    //         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    //         fechaYHora = LocalDateTime.parse(fechaString, formatter);
            
    //     } catch (InputMismatchException e) {
    //         System.out.println("Por favor ingrese un número entero");
    //         scanner.nextLine();
    //     }
    //     return  fechaYHora;   
    // }



}
