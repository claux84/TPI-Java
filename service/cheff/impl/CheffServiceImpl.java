package ar.com.eventos.service.cheff.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ar.com.eventos.domain.Cheff;
import ar.com.eventos.domain.EventoGastronomico;
import ar.com.eventos.enumeration.TiposDeCocinaEnum;
import ar.com.eventos.service.cheff.CheffService;
import ar.com.eventos.service.gestiondeeventos.GestionDeEventosService;

public class CheffServiceImpl implements CheffService {
    private GestionDeEventosService gestionDeEventosService;

    public CheffServiceImpl( GestionDeEventosService gestionDeEventosService){
        this.gestionDeEventosService = gestionDeEventosService;
    }


    @Override
    public Cheff registrarCheff(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cheff: ");
        String nombreCheff = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese el apellido del cheff: ");
        String apellidoCheff = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese el dni del cheff: ");
        String dniCheff = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese la especialidad del cheff");
        System.out.println("1. Panaderia");
        System.out.println("2. Pasteleria");
        System.out.println("3. Cocina Nacional");
        System.out.println("4. Cocina Internacional");
        System.out.println("5. Bar y Cocteleria");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        TiposDeCocinaEnum especialidadCheff;

        especialidadCheff = (
            switch (opcion){
                case 1 -> TiposDeCocinaEnum.PANADERIA;
                case 2 -> TiposDeCocinaEnum.PASTELERIA;
                case 3 -> TiposDeCocinaEnum.COCINA_NACIONAL;
                case 4 -> TiposDeCocinaEnum.COCINA_INTERNACIONAL;
                case 5 -> TiposDeCocinaEnum.BAR_Y_COCTELERIA;
                default -> null;
            }
        );

        List<EventoGastronomico> eventos = new ArrayList<>();
        
        Cheff nuevoCheff = new Cheff(nombreCheff, apellidoCheff, dniCheff, especialidadCheff, eventos);

        gestionDeEventosService.getCheffs().put(nuevoCheff.getId(), nuevoCheff);

        return nuevoCheff;
    }

    @Override
    public Cheff buscarCheff(Integer idCheff) {
        Cheff cheff = null;
        boolean existeElCheff = Boolean.FALSE;
        Map<Integer, Cheff> cheffs = gestionDeEventosService.getCheffs();

        if (cheffs.containsKey(idCheff)){
            cheff = cheffs.get(idCheff);
            existeElCheff = Boolean.TRUE;
        }

        if (!existeElCheff){
            throw new NoSuchElementException("No existe el cheff");
        }
        return cheff;
    }  
    

}
