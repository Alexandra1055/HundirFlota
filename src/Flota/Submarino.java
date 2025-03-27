package Flota;

import TableroMar.Casilla;
public class Submarino extends Barco {
    public Submarino()  {
        super(3);
    }

    @Override
    public boolean estaHundido() {
        Casilla[] coordenadasDelBarco = getCoordenadas();

        if (coordenadasDelBarco == null) {
            return false;
        }

        for (int i = 0; i < coordenadasDelBarco.length; i++) {
            Casilla casillaActual = coordenadasDelBarco[i];
            boolean estaDestapada = casillaActual.isDestapado();
            if (!estaDestapada) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getEmoji(){
        return "\uD83D\uDEF3\uFE0F";
    }
}
