package Flota;

import TableroMar.Casilla;

public class PortaAviones extends Barcos{

    PortaAviones(int posicion, Casilla[] coordenadas) {
        super(0, new Casilla[Piezas.PORTAAVIONES.getTamano()]);
    }
}
