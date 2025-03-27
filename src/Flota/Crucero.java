package Flota;

import TableroMar.Casilla;

public class Crucero extends Barco {
    public Crucero()  {
        super(2);
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
            if (!estaDestapada)  {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getEmoji(){
        return "\uD83D\uDEE5\uFE0F";
    }
}
