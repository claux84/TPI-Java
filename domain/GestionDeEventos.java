package ar.com.eventos.domain;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;

public class GestionDeEventos {
    private List<EventoGastronomico> eventosGastronomicos = new ArrayList<>();
    private Map<Integer, Cheff> cheffs = new TreeMap<>();

    public GestionDeEventos(List<EventoGastronomico> eventoGastronomicos, Map<Integer, Cheff> cheffs) {
        setEventosGastronomicos(eventoGastronomicos);
        setCheffs(cheffs);
    }

    public void setEventosGastronomicos(List<EventoGastronomico> eventosGastronomicos) {
        this.eventosGastronomicos = eventosGastronomicos;
    }

    public List<EventoGastronomico> getEventosGastronomicos() {
        return eventosGastronomicos;
    }

    public void setCheffs(Map<Integer, Cheff> cheffs) {
        this.cheffs = cheffs;
    }

    public Map<Integer, Cheff> getCheffs() {
        return cheffs;
    }

}