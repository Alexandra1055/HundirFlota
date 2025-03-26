package Flota;

public class Crucero extends Barco {
    public Crucero()  {
        super(2);
    }

    @Override
    public boolean estaHundido() {
        return false;
    }
    @Override
    public String getEmoji(){
        return "\uD83D\uDEE5\uFE0F";
    }
}
