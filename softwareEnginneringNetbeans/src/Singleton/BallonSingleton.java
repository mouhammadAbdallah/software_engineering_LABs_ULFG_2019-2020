package Singleton;

public class BallonSingleton {

    int px, py;
    private static BallonSingleton b=new BallonSingleton(0, 0);

    private BallonSingleton(int px, int py) {
        this.px = px;
        this.py = py;
    }
    
    public static BallonSingleton getInstance(){
        return b;
    }
    
    public void move() {
        px += 10;
        py += 20;
    }

    @Override
    public String toString() {
        return "Ballon{" + "px=" + px + ", py=" + py + '}';
    }

}
