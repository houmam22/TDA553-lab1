package src;

import java.awt.*;

public class Saab95 extends Car{
    private boolean turboOn;

    public Saab95(){
        super(2, 125,0, Color.red, "src.Saab95", 0.2);
        stopEngine();
    }
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
