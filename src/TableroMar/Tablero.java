package TableroMar;
import Flota.*;

import java.util.Random;

public class Tablero {

    public static final int TOTAL_FILAS = 10;
    public static final int TOTAL_COLUMNAS= 10;
    private Casilla[][] casillas;

    public Tablero(){
        this.casillas = new Casilla[TOTAL_FILAS][TOTAL_COLUMNAS];
        iniciarJuego();
    }

    private void iniciarJuego(){
        for (int fila = 0; fila < TOTAL_FILAS; fila++) {
            for (int columna = 0; columna < TOTAL_COLUMNAS; columna++) {
                casillas[fila][columna] = new Casilla(fila,columna,true);
            }
        }
    }

    public void colocarBarcoRandom (Barcos barco){
        Random random = new Random();
        boolean colocar = false;

        while (!colocar){
            boolean horizontal = random.nextBoolean();
        }

    }

    public boolean puedeColocarse (int fila, int columna, int tamano, boolean horizontal){

        for (int i = 0; i < tamano; i++) {
            if(horizontal){
                columna = columna + i;
            } else {
                fila = fila + 1;
            }
        }



    }


}
