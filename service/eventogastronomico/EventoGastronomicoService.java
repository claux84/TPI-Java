package ar.com.eventos.service.eventogastronomico;


import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.domain.Participante;

import java.util.Scanner;

public interface EventoGastronomicoService {
    EventoGastronomico crearEvento(Scanner scanner);
    void inscribirParticipante(Integer idEvento, Participante participante);
    void inscribirParticipanteAEvento(Integer idEvento, Integer idParticipante );
    void asignarCheffAEvento(Integer idEvento, Integer idCheff);
    void agregarReseniaDeParticipanteAEvento(Integer idEvento, Integer idParticipante, Scanner scanner);
    int buscarEventoGastronomico(Integer idEvento);
    void listarParticipantesDeEvento(Integer idEvento);
    void listarReseniasDeEvento(Integer idEvento);
    Participante buscarParticipanteEnEvento(Integer idParticipante, int index);

}
