package src;
import java.awt.*;
public class Volvo240 extends Car{
    public final static double trimFactor = 1.25;
    public Volvo240(){
        super(4, 100,0, Color.black, "src.Volvo240", 0.1);
        stopEngine();
    }
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
