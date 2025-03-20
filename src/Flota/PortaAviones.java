package Flota;

import TableroMar.Casilla;

public class PortaAviones extends Barcos{

    public PortaAviones() {
        super(0, new Casilla[Piezas.PORTAAVIONES.getTamano()]);
    }

    @Override
    public String getEmoji(){
        return "\uD83D\uDEA2";
    }
}
