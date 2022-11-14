import java.awt.*;
import java.lang.Math.*;

public abstract class car implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x,y;
    private double dir;
    private double turnFactor;
    public car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnFactor) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.turnFactor = turnFactor;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    public void move() {
        y += currentSpeed * Math.cos(dir);
        x += currentSpeed * Math.sin(dir);
    }
    public void turnLeft() {
        dir = (dir + turnFactor) % (2 * Math.PI);
    }
    public void turnRight() {
        dir = (dir - turnFactor) % (2 * Math.PI);
    }

    public abstract double speedFactor();
    public abstract void gas(double amount);
    public abstract void brake(double amount);
}