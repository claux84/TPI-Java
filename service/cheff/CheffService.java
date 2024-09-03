package ar.com.eventos.service.cheff;

import ar.com.eventos.domain.Cheff;
import java.util.Scanner;


public interface CheffService {
    Cheff registrarCheff(Scanner scanner);
    Cheff buscarCheff(Integer idCheff);

}
