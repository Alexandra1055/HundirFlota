package TableroMar;

public class Casilla {
    protected int fila;
    protected int columna;
    protected boolean agua;


    public Casilla (int fila, int columna, boolean agua){
        this.fila = fila;
        this.columna = columna;
        this.agua = agua;

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

}
