package ar.com.eventos.domain;

import java.util.ArrayList;
import java.util.List;

public class GestionDeEventos {
    private List<EventoGastronomico> eventosGastronomicos = new ArrayList<>();
    private List<Cheff> cheffs = new ArrayList<>();
    private List<Participante> participantes = new ArrayList<>();

    public void setEventosGastronomicos(List<EventoGastronomico> eventosGastronomicos) {
        this.eventosGastronomicos = eventosGastronomicos;
    }

    public List<EventoGastronomico> getEventosGastronomicos() {
        return eventosGastronomicos;
    }

    public void setCheffs(List<Cheff> cheffs) {
        this.cheffs = cheffs;
    }

    public List<Cheff> getCheffs() {
        return cheffs;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }
    
}