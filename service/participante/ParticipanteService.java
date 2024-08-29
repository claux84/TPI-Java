package ar.com.eventos.service.participante;

import ar.com.eventos.domain.*;

public interface ParticipanteService {
    Participante registrarParticipante();
    Participante buscarParticipante(Integer idParticipante);
    Participante buscarParticipantePorDni(String dniParticipante);
}
