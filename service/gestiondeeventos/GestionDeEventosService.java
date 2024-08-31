package ar.com.eventos.service.gestiondeeventos;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.domain.Cheff;


public interface GestionDeEventosService {
    List<EventoGastronomico> getEventos();
    Map<Integer, Cheff> getCheffs();
    void listarEventosDisponibles(LocalDateTime fechaYHora);
    void listarEventosNoDisponibles(LocalDateTime fechaYHora);
    void listarEventosRealizados();
    void listarEventos();

    void listarCheffs();

}
