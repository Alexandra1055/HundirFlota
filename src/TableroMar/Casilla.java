package TableroMar;

import Flota.Barcos;

public class Casilla {
    protected int fila;
    protected int columna;
    protected boolean agua;
    private boolean destapado;
    private Barcos barco;


    public Casilla (int fila, int columna, boolean agua){
        this.fila = fila;
        this.columna = columna;
        this.agua = agua;
        this.destapado = false;
        this.barco = null;

    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isAgua() {
        return agua;
    }

    public void setAgua(boolean agua) {
        this.agua = agua;
    }

    public boolean isDestapado() {
        return destapado;
    }

    public void setDestapado(boolean destapado) {
        this.destapado = destapado;
    }

    public Barcos getBarco(){
        return barco;
    }

    public void setBarco(Barcos barco){
        this.barco = barco;
    }
}
