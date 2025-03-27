package Flota;

import TableroMar.Casilla;

public abstract class Barco {
    private int longitud;
    private Casilla[] coordenadas;
    private boolean hundido;

    public Barco(int longitud) {
        this.longitud = longitud;
        this.hundido = false;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setCoordenadas(Casilla[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Casilla[] getCoordenadas() {
        return coordenadas;
    }

    public boolean isHundido() {
        return hundido;
    }

    public void setHundido(boolean hundido) {
        this.hundido = hundido;
    }

    public abstract boolean estaHundido();

    public abstract String getEmoji();
}
