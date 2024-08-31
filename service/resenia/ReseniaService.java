package ar.com.eventos.service.resenia;

import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.domain.Resenia;

public interface ReseniaService {
    Resenia crearResenia(Participante participante, EventoGastronomico eventoGastronomico); 

}
