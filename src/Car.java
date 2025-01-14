package src;
import java.awt.*;
import java.util.Random;
public abstract class Car implements Movable{
    private int nrDoors; // Number of doors on the src.car
    private double enginePower; // Engine power of the src.car
    private double currentSpeed; // The current speed of the src.car
    private Color color; // Color of the src.car
    private String modelName; // The src.car model name
    private double x,y;
    private final int maxCoords = 100;
    private double dir;
    private double turnFactor;
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnFactor) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.turnFactor = turnFactor;
        Random rnd = new Random();
        x = rnd.nextDouble(-maxCoords, maxCoords);
        y = rnd.nextDouble(-maxCoords, maxCoords);
    }
    public void setCurrentSpeed(double currentSpeed) {
        if( currentSpeed >= enginePower) {
            this.currentSpeed = enginePower;
        }
        if(currentSpeed <= 0) {
            this.currentSpeed = 0;
        }
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void setColor(Color clr){
        color = clr;
    }

    public void setDir(double dir) {
        if(dir > 0) this.dir = dir % (2 * Math.PI);
        if(dir < 0) this.dir = (2 * Math.PI) -((-dir) % (2 * Math.PI));
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDir() {
        return dir;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
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
    public Color getColor(){
        return color;
    }
    public int getMaxCoords() {
        return maxCoords;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }
    public void move() {
        if(Math.abs(this.y+currentSpeed * Math.cos(dir)) <= maxCoords){
            this.y += currentSpeed * Math.cos(dir);
        }else{ this.y = Math.signum(currentSpeed * Math.cos(dir)) * maxCoords;}

        if(Math.abs(x+currentSpeed * Math.sin(dir)) <= maxCoords){
            x += currentSpeed * Math.sin(dir);
        }else{ x = Math.signum(currentSpeed * Math.sin(dir)) * maxCoords;}
    }
    public void turnLeft() {setDir(dir + turnFactor);}
    public void turnRight() {setDir(dir - turnFactor);}


    public void gas(double amount){if(amount <= 1 && amount >= 0) incrementSpeed(amount);}
    public void brake(double amount){
        if(amount <= 1 && amount >= 0) decrementSpeed(amount);
    }
    public abstract double speedFactor();
}