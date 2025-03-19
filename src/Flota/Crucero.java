package Flota;

import TableroMar.Casilla;

public class Crucero extends Barcos{
    Crucero(int posicion, Casilla[] coordenadas) {
        super(0, new Casilla[Piezas.CRUCERO.getTamano()]);
    }
}
