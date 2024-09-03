package ar.com.eventos.service.participante;

import java.util.List;
import java.util.Scanner;

import ar.com.eventos.domain.*;

public interface ParticipanteService {
    Participante registrarParticipante(Scanner scanner);
    Participante buscarParticipante(Integer idParticipante);
    Integer buscarParticipantePorDni(String dniParticipante);
    List<EventoGastronomico> crearHistorial(Integer idParticipante);
}
