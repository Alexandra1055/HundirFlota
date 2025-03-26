package Flota;

public class Submarino extends Barco {
    public Submarino()  {
        super(3);
    }

    @Override
    public boolean estaHundido() {
        return false;
    }
    @Override
    public String getEmoji(){
        return "\uD83D\uDEF3\uFE0F";
    }
}
