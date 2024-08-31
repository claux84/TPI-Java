package ar.com.eventos.service.archivos;

import ar.com.eventos.domain.EventoGastronomico;
import java.util.List;

public interface ArchivosEventosService {
    void exportarEventosCsv(List<EventoGastronomico> eventosGastronomicos);
    void cerrarWriter();

}
