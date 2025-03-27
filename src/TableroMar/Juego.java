package TableroMar;

import Flota.*;
import java.util.ArrayList;

public class Juego {
    private Tablero tablero;
    private ArrayList<Barco> flota;
    private int disparos;

    public Juego() {
        tablero = new Tablero();
        flota = new ArrayList<>();
        disparos = 0;
        crearFlota();
    }

    private void crearFlota() {
        Barco portaaviones = new PortaAviones();
        tablero.colocarBarcoRandom(portaaviones);
        flota.add(portaaviones);

        Barco buque = new Buque();
        tablero.colocarBarcoRandom(buque);
        flota.add(buque);

        Barco submarino = new Submarino();
        tablero.colocarBarcoRandom(submarino);
        flota.add(submarino);

        Barco crucero = new Crucero();
        tablero.colocarBarcoRandom(crucero);
        flota.add(crucero);

        Barco lancha = new Lancha();
        tablero.colocarBarcoRandom(lancha);
        flota.add(lancha);
    }

    public void jugar() {
        Display.iniciarJuego();

        while (!todosBarcosHundidos()) {
            Display.imprimirTablero(tablero);
            int fila = Display.pedirFila();
            int columna = Display.pedirColumna();
            boolean tocado = disparar(fila, columna);

            if (tocado) {
                Display.imprimirMensaje("Tocado \uD83D\uDCA5!!");
                chequearHundimientos();
            } else {
                Display.imprimirMensaje("Agua \uD83C\uDF0A");
            }
        }
        Display.imprimirTablero(tablero);
        Display.imprimirMensaje("¡Has Ganado! \uD83C\uDFC6 has conseguido hundir toda la flota");
    }

    public boolean todosBarcosHundidos() {
        int i = 0;
        while (i < flota.size()) {
            if (!flota.get(i).estaHundido()) {
                return false;
            }
            i++;
        }
        return true;
    }

    private void chequearHundimientos() {
        int i = 0;
        while (i < flota.size()) {
            Barco barco = flota.get(i);
            if (!barco.isHundido() && barco.estaHundido()) {
                Display.imprimirMensaje("¡Has hundido el " + barco.getClass().getSimpleName() + " " + barco.getEmoji() + "!");
                tablero.destaparAguaCerca(barco);
                barco.setHundido(true);
            }
            i++;
        }
    }

    public boolean disparar(int fila, int columna) {
        disparos++;
        return tablero.disparar(fila, columna);
    }

    public Tablero getTablero() {
        return tablero;
    }

    public ArrayList<Barco> getFlota() {
        return flota;
    }

    public int getDisparos() {
        return disparos;
    }
}
