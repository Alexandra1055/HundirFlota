package Flota;

public class Buque extends Barco {
    public Buque() {
        super(4);
    }

    @Override
    public boolean estaHundido() {
        return false;
    }

    @Override
    public String getEmoji(){
        return "⛴\uFE0F";
    }
}
