package ar.com.eventos.domain;


import java.util.concurrent.atomic.AtomicInteger;

public class Resenia {
    private int id;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private Participante participante;
    private EventoGastronomico eventoGastronomico;
    private int calificacion;
    private String comentario;

    public Resenia( Participante participante, EventoGastronomico eventoGastronomico, int calificacion, String comentario){
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
    public void setCalificacion(int calificacion) {
        boolean calificacionValida = validarCalificacion(calificacion);
        if (calificacionValida){
            this.calificacion = calificacion;
        } else {
            System.out.println( "Calificacion invalida");
        }
    }
    public int getCalificacion() {
        return calificacion;
    }
    private boolean validarCalificacion(int calificacion){
        if (calificacion >= 1 && calificacion <= 5){
            return true;
        } else {
            return false;
        }
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

