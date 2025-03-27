package TableroMar;

public class Casilla {
    private int fila;
    private int columna;
    private boolean agua;
    private boolean destapado;
    private String contenido;

    public Casilla(int fila, int columna, boolean agua) {
        this.fila = fila;
        this.columna = columna;
        this.agua = agua;
        this.destapado = false;
        this.contenido = null;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
