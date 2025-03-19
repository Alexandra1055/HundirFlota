package Flota;
import java.util.Random;

public enum Piezas {
    PORTAAVIONES(5),
    BUQUE(4),
    SUBMARINO(3),
    CRUCERO(2),
    LANCHA(1);

    private final int TAMANO;

    Piezas(int TAMANO){
        this.TAMANO = TAMANO;
    }
}
