package ar.com.eventos.service.menu.impl;


import ar.com.eventos.service.menu.MenuService;

import ar.com.eventos.service.archivos.ArchivosEventosService;
import ar.com.eventos.service.cheff.CheffService;
import ar.com.eventos.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MenuServiceImpl implements MenuService {
    private EventoGastronomicoService eventoGastronomicoService;
    private ArchivosEventosService archivosEventosService;
    private CheffService cheffService;
    private GestionDeEventosService gestionDeEventosService;
    

    public MenuServiceImpl( EventoGastronomicoService eventoGastronomicoService, ArchivosEventosService archivosEventosService, CheffService cheffService, GestionDeEventosService gestionDeEventosService){
        this.eventoGastronomicoService = eventoGastronomicoService;
        this.archivosEventosService = archivosEventosService;
        this.cheffService = cheffService;
        this.gestionDeEventosService = gestionDeEventosService;
    }

    @Override
    public void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Ingrese opcion : \n");
            System.out.println("1. Gestionar evento gastronómico");
            System.out.println("2. Gestionar participante");
            System.out.println("3. Gestionar cheff");
            System.out.println("4. Gestionar reseñas");
            System.out.println("5. Listados y archivos");
            System.out.println("6. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    mostrarMenuEventos(scanner);
                    break;
                case 2:
                    mostrarMenuParticipante(scanner);
                    break;
                case 3:
                    mostrarMenuCheff(scanner);
                    break;
                case 4:
                    mostrarMenuResenia(scanner);
                    break;
                case 5:
                    mostrarMenuListado(scanner);
                case 6:
                    System.out.println("\n Aplicacion finalizada");
                    break;
                default:
                    break;
            }

        }while (opcion != 6);
        scanner.close();
        
        
    }

    private void mostrarMenuEventos(Scanner scanner){
        int opcion;
        do {
            System.out.println("Gestión de Eventos");
            System.out.println("---------------------------------");
            System.out.println("Ingrese opción : \n");
            System.out.println("1. Crear evento gastronomico");
            System.out.println("2. Inscribir participante ya registrado a un evento gastronómico");
            System.out.println("3. Asignar cheff a un evento gastronómico");
            System.out.println("4. Modificar evento gastronómico (No implementado)");
            System.out.println("5. Cancelar evento gastronómico (No implementado)");
            System.out.println("6. Volver al menú principal"); 
            opcion = scanner.nextInt();
            scanner.nextLine();
        
        
            switch (opcion) {
                case 1:
                    eventoGastronomicoService.crearEvento(scanner);
                    break;
                case 2:
                    System.out.println("Ingrese id del evento gastronómico");
                    Integer idEvento = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese id del participante");
                    Integer idParticipante = scanner.nextInt();
                    scanner.nextLine();
                    eventoGastronomicoService.inscribirParticipanteAEvento(idEvento, idParticipante); 
                    break; 
                case 3:
                    System.out.println("Ingrese id del evento gastronómico");
                    idEvento = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese id del cheff");
                    Integer idCheff = scanner.nextInt();
                    scanner.nextLine();
                    try{
                        eventoGastronomicoService.asignarCheffAEvento(idEvento, idCheff);
                    }catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                    }   
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

    private void mostrarMenuParticipante(Scanner scanner){
        int opcion;
        do {
            System.out.println("Ingrese opcion : \n");
            System.out.println("1. Inscribir nuevo participante a evento gastronómico");
            System.out.println("2. Editar datos de partipante (No implementado)");
            System.out.println("3. Eliminar participante de un evento Gastronómico(No implementado)");
            System.out.println("4. Volver al menú anterior");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese id del evento gastronómico");
                    Integer idEvento = scanner.nextInt();
                    scanner.nextLine();
                    try{
                        eventoGastronomicoService.inscribirParticipante(idEvento);
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

    private void mostrarMenuCheff(Scanner scanner){
        int opcion;
        do {
            System.out.println("Ingrese opcion : \n");
            System.out.println("1. Registrar nuevo cheff");
            System.out.println("2. Editar datos de un cheff (No implementado)");
            System.out.println("3. Eliminar chef de un evento gastronómico (No implementado)");
            System.out.println("4. Volver al menú anterior");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    cheffService.registrarCheff();
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

    private void mostrarMenuResenia(Scanner scanner){
        int opcion;
        do {
            System.out.println("Ingrese opcion : \n");
            System.out.println("1. Cargar reseña de un evento gastronomico realizada por un participante");
            System.out.println("2. Editar reseña de un evento gastronomico realizada por un participante (No implementado)");
            System.out.println("3. Eliminar reseña de un evento gastronomico realizada por un participante (No implementado)");
            System.out.println("4. Volver al menú anterior");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese id del evento gastronómico");
                    Integer idEvento = scanner.nextInt();
                    System.out.println("Ingrese id de estudiante");
                    String idParticipante = scanner.nextLine();
                    scanner.nextLine();
                    try{
                        eventoGastronomicoService.agregarReseniaDeParticipanteAEvento();
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

    private void mostrarMenuListado(Scanner scanner){
        int opcion;
        do {
            System.out.println("Ingrese opcion : \n");
            System.out.println("1. Listar eventos disponibles a partir de una fecha dada");
            System.out.println("2. Listar eventos no disponibles a partir de una fecha dada (No implementado)");
            System.out.println("3. Listar todos los eventos (No implementado)");
            System.out.println("4. Listar cheffs");
            System.out.println("5. Listar participantes de un evento (No implementado)");
            System.out.println("6. Listar reseñas de un evento (No implementado)");
            System.out.println("7. Exportar eventos no disponibles a partir de una fecha dada");
            System.out.println("8. Volver al menú anterior");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese la fecha y hora a partir de la cual necesita la lista (formato: 01-01-2024 12:00 ): ");
                    String fechaString = scanner.nextLine();
                    scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    LocalDateTime fechaYHora = LocalDateTime.parse(fechaString, formatter);
                    gestionDeEventosService.listarEventosDisponibles(fechaYHora);
                    break;
                case 2:
                    break;
                case 3:
                    gestionDeEventosService.listarEventos();
                    break;
                case 4:
                    gestionDeEventosService.listarCheff();
                    break;
                case 5:
                    
                    break;
                case 6:
                    break;
                case 7:
                    archivosEventosService.exportarEventosCsv();
                    break;
                case 8:    
                    break;
                default:
                    break;
            }
        }while (opcion != 8);

    }

}
