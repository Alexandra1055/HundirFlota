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

    private void crearFlota(){
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

    public void jugar(){
        Display.iniciarJuego();

        while (!todosBarcosHundidos()){
            Display.imprimirTablero(tablero);
            int fila = Display.pedirFila();
            int columna = Display.pedirColumna();
            boolean tocado = disparar(fila,columna);

            if (tocado){
                Display.imprimirMensaje("Tocado \uD83D\uDCA5!!");
                chequearHundimientos();
            } else {
                Display.imprimirMensaje("Agua \uD83C\uDF0A");
            }
        }
        Display.imprimirTablero(tablero);
        Display.imprimirMensaje("!Has Ganado¡\uD83C\uDFC6 has conseguido hundir toda la flota");
    }


    public boolean barcoHundido(Barco barco){

        Casilla[] casillas = barco.getCoordenadas();

        if ((casillas.length >= 1 && !casillas[0].isDestapado()) ||
            (casillas.length >= 2 && !casillas[1].isDestapado()) ||
            (casillas.length >= 3 && !casillas[2].isDestapado()) ||
            (casillas.length >= 4 && !casillas[3].isDestapado()) ||
            (casillas.length >= 5 && !casillas[4].isDestapado())) {
            return false;
        }

        return true;
    }

    public boolean todosBarcosHundidos(){

        Barco portaviones = flota.get(0);
        Barco buque = flota.get(1);
        Barco submarino = flota.get(2);
        Barco crucero = flota.get(3);
        Barco lancha = flota.get(4);

        if(!barcoHundido(portaviones) ||
           !barcoHundido(buque) ||
           !barcoHundido(submarino) ||
           !barcoHundido(crucero) ||
           !barcoHundido(lancha)){
            return false;
        }
        return true;
    }

    private void chequearHundimientos(){

        Barco portaaviones = flota.get(0);
        if(!portaaviones.isHundido() && barcoHundido(portaaviones)){
            Display.imprimirMensaje("¡Has hundido el Portaaviones " + portaaviones.getEmoji() + "!");
            portaaviones.setHundido(true);
        }
        Barco buque = flota.get(1);
        if(!buque.isHundido() && barcoHundido(buque)){
            Display.imprimirMensaje("¡Has hundido el Buque " + buque.getEmoji() + "!");
            buque.setHundido(true);
        }
        Barco submarino = flota.get(2);
        if(!submarino.isHundido() && barcoHundido(submarino)){
            Display.imprimirMensaje("¡Has hundido el Submarino " + submarino.getEmoji() + "!");
            submarino.setHundido(true);
        }
        Barco crucero = flota.get(3);
        if(!crucero.isHundido() && barcoHundido(crucero)){
            Display.imprimirMensaje("¡Has hundido el Crucero " + crucero.getEmoji() + "!");
            crucero.setHundido(true);
        }
        Barco lancha = flota.get(0);
        if(!lancha.isHundido() && barcoHundido(lancha)){
            Display.imprimirMensaje("¡Has hundido el Lancha " + lancha.getEmoji() + "!");
            lancha.setHundido(true);
        }
    }

    public boolean disparar (int fila, int columna){
        disparos++;
        return tablero.disparar(fila, columna);
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public ArrayList<Barco> getFlota() {
        return flota;
    }

    public void setFlota(ArrayList<Barco> flota) {
        this.flota = flota;
    }

    public int getDisparos() {
        return disparos;
    }

    public void setDisparos(int disparos) {
        this.disparos = disparos;
    }
}
