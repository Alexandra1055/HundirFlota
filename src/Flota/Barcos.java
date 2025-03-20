package Flota;

import TableroMar.Casilla;

public abstract class Barcos{
    private int posicion;
    public Casilla[] coordenadas;
    private boolean hundido;

    Barcos(int posicion, Casilla[] coordenadas){
        this.coordenadas = coordenadas;
        this.posicion = posicion;
        this.hundido = false;
    }

    public boolean isHundido() {
        return hundido;
    }

    public void setHundido(boolean hundido) {
        this.hundido = hundido;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Casilla[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Casilla[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public abstract String getEmoji();

}
