package Mowers;


/**
 * Created by zorg9 on 26.02.2017.
 */
public class Mower {

    //Orientations
    final char East = 'E';
    final char West = 'W';
    final char North = 'N';
    final char South = 'S';

    //Commands
    final char LeftCmd = 'L';
    final char RightCmd = 'R';
    final char ForwardCmd = 'F';
    protected Position Pos;
    protected  Position BottomLeft;
    protected  Position UpperRight;
    protected String Commands;

    public Position getPos() {
        return Pos;
    }

    public void setPos(Position pos) {
        Pos = pos;
    }

    public Position getBottomLeft() {
        return BottomLeft;
    }

    public void setBottomLeft(Position bottomLeft) {
        BottomLeft = bottomLeft;
    }

    public Position getUpperRight() {
        return UpperRight;
    }

    public void setUpperRight(Position upperRight) {
        UpperRight = upperRight;
    }

    public String getCommands() {
        return Commands;
    }

    public void setCommands(String commands) {
        Commands = commands;
    }


    public Mower(Position initialPosition) {
        this();
        Pos = initialPosition;
    }

    public Mower() {
        setPos(this.getDefaultPosition());
    }


    private Position getDefaultPosition() {
        Position position = new Position();
        position.setX(0);
        position.setY(0);
        return position;
    }

     void MoveTo(char command) {
        switch (command) {
            case LeftCmd:
                this.TurnLeft();
                break;
            case RightCmd:
                this.TurnRight();
                break;
            case ForwardCmd:
                this.MoveForward();
                break;
        }
    }

     void Run() {
        for (int i = 0; i < Commands.length(); i++) {
            this.MoveTo(Commands.charAt(i));
        }
    }

      private void TurnLeft() {
        char newOrientation = Pos.getOrientation();

        switch (Pos.getOrientation()) {
            case East:
                newOrientation = North;
                break;
            case North:
                newOrientation = West;
                break;
            case West:
                newOrientation = South;
                break;
            case South:
                newOrientation = East;
                break;
        }

        Pos.Orientation = newOrientation;

    }

      private void TurnRight() {
        char newOrientation = Pos.getOrientation();

        switch (Pos.getOrientation()) {
            case East:
                newOrientation = South;
                break;
            case North:
                newOrientation = East;
                break;
            case West:
                newOrientation = North;
                break;
            case South:
                newOrientation = West;
                break;
        }

        Pos.Orientation = newOrientation;
    }


     private void MoveForward() {
        switch (Pos.getOrientation()) {
            case East:
                if (Pos.X + 1 <= UpperRight.X)
                    Pos.X = Pos.X + 1;
                break;
            case North:
                if (Pos.Y + 1 <= UpperRight.Y)
                    Pos.Y = Pos.Y + 1;
                break;
            case West:
                if (Pos.X - 1 >= BottomLeft.X)
                    Pos.X = Pos.X - 1;
                break;
            case South:
                if (Pos.Y - 1 >= BottomLeft.Y)
                    Pos.Y = Pos.Y - 1;
                break;

        }
    }
}

