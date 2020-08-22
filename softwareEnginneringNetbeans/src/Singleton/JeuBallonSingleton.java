package Singleton;

import java.util.Calendar;

public class JeuBallonSingleton {

    public static void main(String[] args) {
        
        BallonSingleton b1 = BallonSingleton.getInstance();
        System.out.println(b1);
        b1.move();
        System.out.println(b1);
        
        //...
        //...after several months..
        //.....
        
        BallonSingleton b2=BallonSingleton.getInstance();
        System.out.println("After clonnage");
        System.out.println("b1="+b1);
        System.out.println("b2="+b2);
        b2.move();
        System.out.println("b1="+b1);
        System.out.println("b2="+b2);
        
        
        //Calendar.getInstance();
    }

}
