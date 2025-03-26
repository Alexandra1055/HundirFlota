package Flota;

public abstract class Barco {
    private int longitud;

    Barco(int longitud){
      this.longitud = longitud;
    }


    public int getLongitud() {
        return longitud;
    }

    public abstract boolean estaHundido() ; // retornar true si i només totes les seves caselles han estat destapades


    public abstract String getEmoji();

}
