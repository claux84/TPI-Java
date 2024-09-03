package ar.com.eventos.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntradaUtil {

    public static int controlEntradaEnteros(Scanner scanner){
        int entero = -1;
        Boolean esEntero = Boolean.FALSE;
        do {
            try {
                entero = scanner.nextInt();
                scanner.nextLine();
                esEntero = Boolean.TRUE;
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese un número entero");
            } 
        } while (!esEntero);
        return entero;   
    }

    public static LocalDateTime controlEntradaFecha(Scanner scanner){
        LocalDateTime fechaYHora = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Boolean esFecha = Boolean.FALSE;
        
        do {
            try {
                String fechaString = scanner.nextLine();
                scanner.nextLine();
                fechaYHora = LocalDateTime.parse(fechaString, formatter);
                esFecha = Boolean.TRUE;
            } catch (DateTimeParseException e) {
                System.out.println("Por favor ingrese una fecha con el siguiente formato (01/01/2024 12:00)");
            }
        } while (!esFecha);
        return  fechaYHora;   
    }
    public static String controlEntradaDni(Scanner scanner){
        String patronDni = "[0-9]{7,8}";
        Pattern patron = Pattern.compile(patronDni);
        Boolean esDni = Boolean.FALSE;
        String dni = null;
        do {
            try {
                dni= scanner.nextLine();
                scanner.nextLine();
                Matcher coincidencia = patron.matcher(dni);
                if (coincidencia.matches()) {
                    esDni = Boolean.TRUE;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese el DNI correctamente");
            }
        } while (!esDni);
        return  dni;   
    }

    public static int controlEntradaCalificacion(Scanner scanner){
        int calificacion;
        Boolean calificacionValida = Boolean.FALSE;
        do {
            calificacion = controlEntradaEnteros(scanner);
            if (calificacion >= 1 && calificacion <= 5) {
                calificacionValida = Boolean.TRUE;
            } else {
                System.out.println("Para calificar el evento ingrese un número entero entre 1 y 5");
            }
        } while (!calificacionValida);
        return calificacion;
    }
}
