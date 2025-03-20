package Flota;

import TableroMar.Casilla;

public class Crucero extends Barcos{
    public Crucero() {
        super(0, new Casilla[Piezas.CRUCERO.getTamano()]);
    }

    @Override
    public String getEmoji(){
        return "\uD83D\uDEE5\uFE0F";
    }
}
