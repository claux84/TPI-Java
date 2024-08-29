package ar.com.eventos.service.eventogastronomico;


import ar.com.eventos.domain.EventoGastronomico;
import java.util.Scanner;

public interface EventoGastronomicoService {
    EventoGastronomico crearEvento(Scanner scanner);
    void listarEventos();
    void inscribirParticipante(Integer idEvento);
    void inscribirParticipanteAEvento(Integer idEvento, Integer idParticipante );
    void asignarCheffAEvento(Integer idEvento, Integer idCheff);
    void agregarReseniaDeParticipanteAEvento();
    int buscarEventoGastronomico(Integer idEvento);

}
