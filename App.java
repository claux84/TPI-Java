package ar.com.eventos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import ar.com.eventos.enumeration.TiposDeCocinaEnum;
import ar.com.eventos.domain.*;

import ar.com.eventos.domain.Participante;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        Set<TiposDeCocinaEnum> interesesCulinarios1 = new HashSet<>();
        interesesCulinarios1.add(TiposDeCocinaEnum.PANADERIA);
        interesesCulinarios1.add(TiposDeCocinaEnum.PASTELERIA);
        interesesCulinarios1.add(TiposDeCocinaEnum.COCINA_INTERNACIONAL);
        List<EventoGastronomico> eventoGastronomico1 = new ArrayList<>();


    
       Participante participante = new Participante("Claudio", "Ramirez", "30789604", interesesCulinarios1, eventoGastronomico1 );
        System.out.println(participante.toString());
    }
}
