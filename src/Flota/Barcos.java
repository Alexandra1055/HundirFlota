package Flota;

import TableroMar.Casilla;

public class Barcos{
    private int posicion;
    public Casilla[] coordenadas;

    Barcos(int posicion, Casilla[] coordenadas){
        this.coordenadas = coordenadas;
        this.posicion = posicion;
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
}
