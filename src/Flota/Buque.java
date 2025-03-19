package Flota;

import TableroMar.Casilla;

public class Buque extends Barcos{
    Buque(int posicion, Casilla[] coordenadas) {
        super(0, new Casilla[Piezas.BUQUE.getTamano()]);
    }
}
