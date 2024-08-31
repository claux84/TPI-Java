package ar.com.eventos.service.archivos.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.opencsv.CSVWriter;

import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.service.archivos.ArchivosEventosService;

public class ArchivosEventosServiceImpl implements ArchivosEventosService{
    private final String UBICACION_ARCHIVO = "\\eventos-gastronomicos-project\\src\\main\\java\\ar\\com\\eventos\\recursos\\";

    CSVWriter csvWriter;

    @Override
    public void exportarEventosCsv(List<EventoGastronomico> eventosGastronomicos) {
        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("eventos.csv");
        LocalDateTime fechaActual = LocalDateTime.now();

        try{
            this.csvWriter = new CSVWriter(new FileWriter(ruta));
            String[] encabezado = {"ID","NOMBRE","DESCRIPCION","FECHA Y HORA", "UBICACION", "CAPACIDAD", "CHEFF A CARGO", "CANTIDAD DE PARTICIPANTES INSCRIPTOS", "CANTIDAD DE RESENIAS DEL EVENTO" };
            this.csvWriter.writeNext(encabezado);

            for (EventoGastronomico eventoGastronomico : eventosGastronomicos) {
                if (eventoGastronomico.getFechaYHora().isAfter(fechaActual) && eventoGastronomico.getCapacidad() == eventoGastronomico.cantidadDeParticipantes() ) {
                    String[] datos = {
                        Integer.valueOf(eventoGastronomico.getId()).toString(),
                        eventoGastronomico.getNombre(),
                        eventoGastronomico.getDescripcion(),
                        eventoGastronomico.getFechaYHora().toString(),
                        eventoGastronomico.getUbicacion(),
                        Integer.valueOf(eventoGastronomico.getCapacidad()).toString(),
                        eventoGastronomico.cheffToString(),
                        Integer.valueOf(eventoGastronomico.cantidadDeParticipantes()).toString(),
                        Integer.valueOf(eventoGastronomico.cantidadDeResenias()).toString()
                    };
                    this.csvWriter.writeNext(datos);
                } 
            }
            System.out.println("Exportacion exitosa");

        }catch (IOException e){
            System.out.println("Algo salio mal motivo :" + e.getMessage().concat(" Ubicacion archivo : " + ruta));
        }
        
        
    }

    @Override
    public void cerrarWriter() {
        if (this.csvWriter != null){
            try{
                this.csvWriter.close();
            }catch (IOException e){
                System.out.println("Algo salio mal motivo :" + e.getMessage());
            }
        }
    }

}
