package Flota;

import TableroMar.Casilla;

public class Buque extends Barco {
    public Buque() {
        super(4);
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
            if  (!estaDestapada)  {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getEmoji(){
        return "⛴\uFE0F";
    }
}
