package Flota;

import TableroMar.Casilla;

public class Submarino extends Barcos{
    public Submarino() {
        super(0, new Casilla[Piezas.SUBMARINO.getTamano()]);
    }

    @Override
    public String getEmoji(){
        return "\uD83D\uDEF3\uFE0F";
    }
}
