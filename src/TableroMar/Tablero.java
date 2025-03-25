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
                        casillas[fila][columna + i].setBarco(barco);
                        coordenadas[i] = casillas[fila][columna + i];
                    } else {
                        casillas[fila + i][columna].setAgua(false);
                        casillas[fila + i][columna].setBarco(barco);
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

    public boolean disparar (int fila, int columna){
        if (fila < 0 || fila >= TOTAL_FILAS || columna < 0 || columna >= TOTAL_COLUMNAS) {
            System.out.println("Coordenadas fuera del tablero.");
            return false;
        }

        Casilla casilla = casillas[fila][columna];
        if (casilla.isDestapado()){
            System.out.println("Ya has disparado a esta casilla, vuelve a intentarlo.");
            return false;
        }

        casilla.setDestapado(true);
        if (!casilla.isAgua()){
            return true;
        } else {
            return false;
        }

    }

    public void aguaCerca(int fila, int columna){
        int[][] direcciones = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int i = 0; i < direcciones.length; i++) {
            int filaN = fila + direcciones[i][0];
            int columnaN = columna + direcciones[i][1];

            if (filaN >= 0 && filaN < TOTAL_FILAS && columnaN >= 0 && columnaN < TOTAL_COLUMNAS){
                Casilla casillaAlRededor = casillas[filaN][columnaN];

                if (!casillaAlRededor.isDestapado() && casillaAlRededor.isAgua()){
                 casillaAlRededor.setDestapado(true);
                }
            }
        }

    }

    public Casilla getCasillas(int fila, int columna) {
        return casillas[fila][columna];
    }
}
