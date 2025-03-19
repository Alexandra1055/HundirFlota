package Flota;

import TableroMar.Casilla;

public class Submarino extends Barcos{
    Submarino(int posicion, Casilla[] coordenadas) {
        super(0, new Casilla[Piezas.SUBMARINO.getTamano()]);
    }
}
