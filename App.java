package ar.com.eventos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

import ar.com.eventos.domain.GestionDeEventos;
import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.domain.Cheff;
import ar.com.eventos.service.archivos.ArchivosEventosService;
import ar.com.eventos.service.archivos.impl.ArchivosEventosServiceImpl;
import ar.com.eventos.service.cheff.CheffService;
import ar.com.eventos.service.cheff.impl.CheffServiceImpl;
import ar.com.eventos.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventos.service.eventogastronomico.impl.EventoGastronomicoServiceImpl;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;
import ar.com.eventos.service.gestiondeeventos.impl.GestionDeEventosServiceImpl;
import ar.com.eventos.service.menu.MenuService;
import ar.com.eventos.service.menu.impl.MenuServiceImpl;
import ar.com.eventos.service.participante.ParticipanteService;
import ar.com.eventos.service.participante.impl.ParticipanteServiceImpl;
import ar.com.eventos.service.resenia.ReseniaService;
import ar.com.eventos.service.resenia.impl.ReseniaServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        List<EventoGastronomico> eventosGastronomicos = new ArrayList<>();
        Map<Integer, Cheff> cheffs = new TreeMap<>();
        
        ArchivosEventosService archivosEventosService = new ArchivosEventosServiceImpl();
        GestionDeEventos gestionDeEventos = new GestionDeEventos(eventosGastronomicos, cheffs);
        GestionDeEventosService gestionDeEventosService = new GestionDeEventosServiceImpl(gestionDeEventos);
        ParticipanteService participanteService = new ParticipanteServiceImpl(gestionDeEventosService);
        CheffService cheffService = new CheffServiceImpl(gestionDeEventosService);
        ReseniaService reseniaService = new ReseniaServiceImpl();
        EventoGastronomicoService eventoGastronomicoService = new EventoGastronomicoServiceImpl(gestionDeEventosService, participanteService, cheffService, reseniaService);
        MenuService menuService = new MenuServiceImpl(eventoGastronomicoService, archivosEventosService, cheffService, gestionDeEventosService, participanteService);
        Scanner scanner = new Scanner((System.in));
        menuService.mostrarMenu(scanner);

        scanner.close();
        archivosEventosService.cerrarWriter();
    }
}
