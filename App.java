package ar.com.eventos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

import ar.com.eventos.domain.GestionDeEventos;
import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.domain.Cheff;
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

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        List<EventoGastronomico> eventosGastronomicos = new ArrayList<>();
        Map<Integer, Cheff> cheffs = new TreeMap<>();

        GestionDeEventos gestionDeEventos = new GestionDeEventos(eventosGastronomicos, cheffs);
        GestionDeEventosService gestionDeEventosService = new GestionDeEventosServiceImpl(gestionDeEventos);
        ParticipanteService participanteService = new ParticipanteServiceImpl(gestionDeEventosService);
        CheffService cheffService = new CheffServiceImpl(gestionDeEventosService);

        EventoGastronomicoService eventoGastronomicoService = new EventoGastronomicoServiceImpl(gestionDeEventosService, participanteService, cheffService);
        MenuService menuService = new MenuServiceImpl(eventoGastronomicoService, null, cheffService, gestionDeEventosService);
        Scanner scanner = new Scanner((System.in));
        menuService.mostrarMenu(scanner);

        scanner.close();
    }
}
