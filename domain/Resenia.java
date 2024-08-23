package ar.com.eventos.domain;

import ar.com.eventos.enumeration.CalificacionEnum;
import java.util.concurrent.atomic.AtomicInteger;

public class Resenia {
    private int id;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private Participante participante;
    private EventoGastronomico eventoGastronomico;
    private CalificacionEnum calificacion;
    private String comentario;

    public Resenia( Participante participante, EventoGastronomico eventoGastronomico, CalificacionEnum calificacion, String comentario){
        setId();
        setParticipante(participante);
        setEventoGastronomico(eventoGastronomico);
        setCalificacion(calificacion);
        setComentario(comentario);
    }

    public void setId() {
        this.id = atomicInteger.incrementAndGet();
    }
    public int getId() {
        return id;
    }
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    public Participante getParticipante() {
        return participante;
    }
    public void setEventoGastronomico(EventoGastronomico eventoGastronomico) {
        this.eventoGastronomico = eventoGastronomico;
    }
    public EventoGastronomico getEventoGastronomico() {
        return eventoGastronomico;
    }
    public void setCalificacion(CalificacionEnum calificacion) {
        this.calificacion = calificacion;
    }
    public CalificacionEnum getCalificacion() {
        return calificacion;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString(){
        return  "ID: " + this.id
                + " Evento Gastronomico: " + this.eventoGastronomico.getNombre() 
                + " Participante : " + this.participante.getNombre() + " " + this.participante.getApellido()
                + " Calificación: " + this.calificacion
                + " Comentario : " + this.comentario;
    
    }


}

