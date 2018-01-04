package Mowers;

/**
 * Created by zorg9 on 26.02.2017.
 */
public class Position {

    int X = 0;
    int Y = 0;
    char Orientation;


    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public char getOrientation() {
        return Orientation;
    }

    public void setOrientation(char orientation) {
        Orientation = orientation;
    }


    @Override
    public String toString() {
        return String.valueOf(X) + " " + String.valueOf(Y) + " " + Orientation;
    }

}

