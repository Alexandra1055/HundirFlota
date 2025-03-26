package Flota;

public class Lancha extends Barco {
    public Lancha()  {
        super(1);
    }

    @Override
    public boolean estaHundido() {
        return false;
    }
    @Override
    public String getEmoji(){
        return "\uD83D\uDEA4";
    }
}
