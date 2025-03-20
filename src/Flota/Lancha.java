package Flota;

import TableroMar.Casilla;

public class Lancha extends Barcos{
    public Lancha() {
        super(0, new Casilla[Piezas.LANCHA.getTamano()]);
    }

    @Override
    public String getEmoji(){
        return "\uD83D\uDEA4";
    }
}
