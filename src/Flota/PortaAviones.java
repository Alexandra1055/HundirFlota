package Flota;

public class PortaAviones extends Barco {

    public PortaAviones() {
        super(5);
    }

    @Override
    public boolean estaHundido() {
        return false;
    }
    @Override
    public String getEmoji(){
        return "\uD83D\uDEA2";
    }
}
