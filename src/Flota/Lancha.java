package Flota;

import TableroMar.Casilla;

public class Lancha extends Barcos{
    Lancha(int posicion, Casilla[] coordenadas) {
        super(0, new Casilla[Piezas.LANCHA.getTamano()]);
    }
}
