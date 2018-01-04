package Mowers;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zorg9 on 26.02.2017.
 */
public class Lawn {

    int Width;
    int Height;
    private List<Mower> mowers = new ArrayList<Mower>();

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }

    void DeployMower(Mower mower, Position initialPosition, String commands) {
        mower.Pos.Y = Height;
        mower.Pos.X = Width;
        mower.Pos = initialPosition;
        mower.Commands = commands;
        mowers.add(mower);
    }

    public void RunMowers() {
        for (Mower m : mowers) {
            m.Run();
        }
    }
}

