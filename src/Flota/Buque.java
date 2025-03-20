package Flota;

import TableroMar.Casilla;

public class Buque extends Barcos{
    public Buque() {
        super(0, new Casilla[Piezas.BUQUE.getTamano()]);
    }
    @Override
    public String getEmoji(){
        return "⛴\uFE0F";
    }
}
