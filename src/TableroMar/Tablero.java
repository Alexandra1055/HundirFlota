package TableroMar;

import Flota.Barco;
import java.util.Random;

public class Tablero {
    public static final int TOTAL_FILAS = 10;
    public static final int TOTAL_COLUMNAS = 10;
    private Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[TOTAL_FILAS][TOTAL_COLUMNAS];
        iniciarJuego();
    }

    private void iniciarJuego() {
        int fila = 0;
        while (fila < TOTAL_FILAS) {
            int columna = 0;
            while (columna < TOTAL_COLUMNAS) {
                casillas[fila][columna] = new Casilla(fila, columna, true);
                columna++;
            }
            fila++;
        }
    }

    public void colocarBarcoRandom(Barco barco) {
        Random random = new Random();
        boolean colocar = false;

        while (!colocar) {
            boolean horizontal = random.nextBoolean();
            int fila = random.nextInt(TOTAL_FILAS);
            int columna = random.nextInt(TOTAL_COLUMNAS);
            int tamano = barco.getLongitud();

            if (puedeColocarse(fila, columna, tamano, horizontal)) {
                Casilla[] coordenadas = new Casilla[tamano];
                int i = 0;
                while (i < tamano) {
                    if (horizontal) {
                        casillas[fila][columna + i].setAgua(false);
                        casillas[fila][columna + i].setContenido(barco.getEmoji());
                        coordenadas[i] = casillas[fila][columna + i];
                    } else {
                        casillas[fila + i][columna].setAgua(false);
                        casillas[fila + i][columna].setContenido(barco.getEmoji());
                        coordenadas[i] = casillas[fila + i][columna];
                    }
                    i++;
                }
                barco.setCoordenadas(coordenadas);
                colocar = true;
            }
        }
    }

    public boolean puedeColocarse(int fila, int columna, int tamano, boolean horizontal) {
        if (horizontal) {
            if (columna + tamano > TOTAL_COLUMNAS) {
                return false;
            }
            int i = -1;
            while (i <= 1) {
                int j = -1;
                while (j < tamano) {
                    int filaCercana = fila + i;
                    int columnaCercana = columna + j;
                    if (filaCercana >= 0 && filaCercana < TOTAL_FILAS &&
                            columnaCercana >= 0 && columnaCercana < TOTAL_COLUMNAS) {
                        if (!casillas[filaCercana][columnaCercana].isAgua()) {
                            return false;
                        }
                    }
                    j++;
                }
                i++;
            }
        } else {
            if (fila + tamano > TOTAL_FILAS) {
                return false;
            }
            int i = -1;
            while (i < tamano) {
                int j = -1;
                while (j <= 1) {
                    int filaCercana = fila + i;
                    int columnaCercana = columna + j;
                    if (filaCercana >= 0 && filaCercana < TOTAL_FILAS &&
                            columnaCercana >= 0 && columnaCercana < TOTAL_COLUMNAS) {
                        if (!casillas[filaCercana][columnaCercana].isAgua()) {
                            return false;
                        }
                    }
                    j++;
                }
                i++;
            }
        }
        return true;
    }

    public boolean disparar(int fila, int columna) {
        if (fila < 0 || fila >= TOTAL_FILAS || columna < 0 || columna >= TOTAL_COLUMNAS) {
            System.out.println("Coordenadas fuera del tablero.");
            return false;
        }

        Casilla casilla = casillas[fila][columna];
        if (casilla.isDestapado()) {
            System.out.println("Ya has disparado a esta casilla, vuelve a intentarlo.");
            return false;
        }

        casilla.setDestapado(true);
        return !casilla.isAgua();
    }

    public void aguaCerca(int fila, int columna) {
        int[][] direcciones = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1},  {1, 0},  {1, 1}
        };
        int i = 0;
        while (i < direcciones.length) {
            int filaN = fila + direcciones[i][0];
            int columnaN = columna + direcciones[i][1];
            if (filaN >= 0 && filaN < TOTAL_FILAS && columnaN >= 0 && columnaN < TOTAL_COLUMNAS) {
                Casilla casillaAlRededor = casillas[filaN][columnaN];
                if (!casillaAlRededor.isDestapado() && casillaAlRededor.isAgua()) {
                    casillaAlRededor.setDestapado(true);
                }
            }
            i++;
        }
    }

    public void destaparAguaCerca(Barco barco) {
        Casilla[] partesBarco = barco.getCoordenadas();
        if (partesBarco == null) {
            return;
        }
        int i = 0;
        while (i < partesBarco.length) {
            int fila = partesBarco[i].getFila();
            int columna = partesBarco[i].getColumna();
            aguaCerca(fila, columna);
            i++;
        }
    }


    public Casilla getCasillas(int fila, int columna) {
        return casillas[fila][columna];
    }
}
