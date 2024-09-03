package ar.com.eventos.service.resenia.impl;

import java.util.Scanner;

import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.domain.Resenia;
import ar.com.eventos.service.resenia.ReseniaService;

public class ReseniaServiceImpl implements ReseniaService {
    @Override
    public Resenia crearResenia(Participante participante, EventoGastronomico eventoGastronomico, Scanner scanner) {
        System.out.println("-----------------------------------------------------");
        System.out.println("Crear Reseña");
        System.out.println("-----------------------------------------------------");
        System.out.println("Ingrese la calificación del particpante al evento gastronómico: " );
        int calificacionEvento = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el comentario del participante acerca del evento gastronómico: ");
        String comentarioEvento = scanner.nextLine();
        scanner.nextLine();
        Resenia resenia =new Resenia(participante, eventoGastronomico, calificacionEvento, comentarioEvento);
        return resenia;
    }

}
