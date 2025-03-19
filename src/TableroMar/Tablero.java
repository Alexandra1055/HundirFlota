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
            int fila = random.nextInt(TOTAL_FILAS);
            int columna = random.nextInt(TOTAL_COLUMNAS);
            int tamano = barco.getCoordenadas().length;

            if( puedeColocarse(fila,columna,tamano,horizontal)){
                Casilla[] coordenadas = new Casilla[tamano];

                for (int i = 0; i < tamano; i++) {
                    if (horizontal) {
                        casillas[fila][columna + i].setAgua(false);
                        coordenadas[i] = casillas[fila][columna + i];
                    } else {
                        casillas[fila + i][columna].setAgua(false);
                        coordenadas[i] = casillas[fila + i][columna];
                    }
                }

                barco.setCoordenadas(coordenadas);
                colocar = true;
            }
        }

    }

    public boolean puedeColocarse (int fila, int columna, int tamano, boolean horizontal){

        if(horizontal){
            if (columna + tamano > TOTAL_COLUMNAS){
                return false;
            }
            for (int i = 0; i < tamano; i++) {

                if ( !casillas[fila][columna + i].isAgua() ){
                    return false;
                }
            }
        }else {
            if (fila + tamano > TOTAL_FILAS){
                return false;
            }
            for (int i = 0; i < tamano; i++) {

                if ( !casillas[fila + i][columna].isAgua() ){
                    return false;
                }
            }
        }
        return true;
    }

    public void imprimirTablero(){
        for (int i = 0; i < TOTAL_FILAS; i++) {
            for (int j = 0; j < TOTAL_COLUMNAS; j++) {
                if (casillas[i][j].isAgua()){
                    System.out.print("|~|");
                } else {
                    System.out.print("| |");
                }
            }
            System.out.println();
        }
    }

}
