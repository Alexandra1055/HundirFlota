package TableroMar;
import java.util.Scanner;


public class Display {
    private static final Scanner imprimir = new Scanner(System.in);

    public static void iniciarJuego(){
        System.out.println("- Hundir la Flota \uD83D\uDEA2 \uD83D\uDDFA\uFE0F -");
        System.out.println("Flota disponible:");
        System.out.println("Portaaviones: " + new Flota.PortaAviones().getEmoji() + " (5 casillas)");
        System.out.println("Buque: " + new Flota.Buque().getEmoji() + " (4 casillas)");
        System.out.println("Submarino: " + new Flota.Submarino().getEmoji() + " (3 casillas)");
        System.out.println("Crucero: " + new Flota.Crucero().getEmoji() + " (2 casillas)");
        System.out.println("Lancha: " + new Flota.Lancha().getEmoji() + " (1 casilla)");
        System.out.println();
    }

    public static int pedirFila(){
        System.out.print("Introduce una fila (0-9): ");
        while (!imprimir.hasNextInt()) {
            System.out.println("Error: por favor introduce un número.");
            imprimir.next();
            System.out.print("Introduce una fila (0-9): ");
        }
        return imprimir.nextInt();
    }

    public static int pedirColumna(){
        System.out.print("Introduce una columna (0-9): ");
        while (!imprimir.hasNextInt()) {
            System.out.println("Error: por favor introduce un número.");
            imprimir.next();
            System.out.print("Introduce una columna (0-9): ");
        }
        return imprimir.nextInt();
    }

    public static void imprimirMensaje (String texto){
        System.out.println(texto);
    }

    public static void imprimirTablero(Tablero tablero){
        for (int i = 0; i < Tablero.TOTAL_FILAS; i++) {
                System.out.print("- " + i + " -");


            for (int j = 0; j < Tablero.TOTAL_COLUMNAS; j++) {
                Casilla casilla = tablero.getCasillas(i,j);

                if (!casilla.isDestapado()){
                    System.out.print("[\uD83D\uDFE6]");
                } else{
                    if (casilla.isAgua()){
                        System.out.print("[\uD83C\uDF0A]");
                    } else {
                        System.out.print("["+casilla.getBarco().getEmoji()+"]");
                    }

                }
            }
            System.out.println();
        }
        System.out.print("- \uD83D\uDDFA\uFE0F -");

        for (int j = 0; j < Tablero.TOTAL_COLUMNAS; j++) {
                System.out.print(" " +  j + " -");
        }
        System.out.println();
    }
}
