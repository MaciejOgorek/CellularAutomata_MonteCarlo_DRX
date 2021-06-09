package Application;

import javafx.scene.paint.Color;

public class Cell
{
int id;
Color color;
int energy;
int x;
int y;
double ro;
String state;


public Cell(int ID, Color c, int e, int X, int Y, double RO, String State) {
this.id = ID;
this.color = c;
this.energy = e;
this.x =X;
this.y = Y;
this.ro = RO;
this.state = State;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void setEnergy(int energy){this.energy = energy;}
    public int getEnergy(){return energy;}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getRo() {
        return ro;
    }

    public void setRo(double ro) {
        this.ro = ro;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
