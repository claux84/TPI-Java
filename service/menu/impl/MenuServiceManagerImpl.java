package ar.com.eventos.service.menu.impl;

import java.util.Scanner;

import ar.com.eventos.service.menu.MenuService;

public class MenuServiceManagerImpl {
    public void accept(Scanner scanner, MenuService menu){
        menu.accept(scanner);
    }

}
