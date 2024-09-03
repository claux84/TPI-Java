package ar.com.eventos.service.menu.impl;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.com.eventos.service.cheff.CheffService;
import ar.com.eventos.service.menu.MenuService;

public class MenuServiceCheffImpl implements MenuService{
    private CheffService cheffService;

    MenuServiceCheffImpl(CheffService cheffService){
        this.cheffService = cheffService;
    }
    
    @Override
    public void accept(Scanner scanner) {
        int opcion;
        do {
            System.out.println("------------------------------------------");
            System.out.println("Gestión de Cheffs");
            System.out.println("---------------------------------");
            System.out.println("\n Ingrese opcion : \n");
            System.out.println("1. Registrar nuevo cheff");
            System.out.println("2. Editar datos de un cheff (No implementado)");
            System.out.println("3. Eliminar chef de un evento gastronómico (No implementado)");
            System.out.println("4. Volver al menú anterior");

            opcion = controlEntradaEnteros(scanner);

            switch (opcion){
                case 1:
                    cheffService.registrarCheff(scanner);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }

        }while (opcion != 4);
    }
    public static int controlEntradaEnteros(Scanner scanner){
        int entero = -1;
        try {
            entero = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Por favor ingrese un número entero");
            scanner.nextLine();
        }
        return entero;   
    }

}
