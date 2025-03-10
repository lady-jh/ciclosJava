import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class RuletaMetodos {
    List<Integer> tambor;
    int bala;
    int posicionActual;
    Random random;

    public RuletaMetodos() {
        random=new Random();
        reiniciarJuego();
    }

    public RuletaMetodos(Random random, int posicionActual, int bala, List<Integer> tambor) {
        this.random = random;
        this.posicionActual = posicionActual;
        this.bala = bala;
        this.tambor = tambor;
    }

    public List<Integer> getTambor() {
        return tambor;
    }

    public void setTambor(List<Integer> tambor) {
        this.tambor = tambor;
    }

    public int getBala() {
        return bala;
    }

    public void setBala(int bala) {
        this.bala = bala;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public boolean disparar() {
        if (posicionActual==bala) {
            return true;
        }else{
            posicionActual=(posicionActual+1)%tambor.size();
            return false;
        }
    }

    public void reiniciarJuego() {
        tambor=new ArrayList<>();
        for(int i=0;i<6;i++) {
            tambor.add(i);
        }
        bala=random.nextInt(6);
        //posicionActual=random.nextInt(5);
        posicionActual= tambor.get(0);
    }
}

