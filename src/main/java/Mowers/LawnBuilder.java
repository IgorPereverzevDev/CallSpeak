package Mowers;

import java.io.*;

/**
 * Created by zorg9 on 26.02.2017.
 */
public class LawnBuilder {

    final int MowerGroupQty = 2;
    final int MinStrPosLen = 5;
    final String Splitter = " ";
    final int StrPostionElements = 3;

    //deserialization implementation should be moved to particular class, but it is out of scope
    private Lawn DeserializeLawn(BufferedReader sr) {
        Lawn ret = new Lawn();

        String input = null;
        try {
            input = sr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (input != null) {
            String[] strLawn = input.split(Splitter);
            ret.Width = Integer.parseInt(strLawn[0]);
            ret.Height = Integer.parseInt(strLawn[1]);
        }
        this.DeployMowers(ret, sr);

        return ret;
    }

    private void DeployMowers(Lawn lawn, BufferedReader sr) {
        int i = 1;
        String strPos = null;
        String commands;
        String input;

        try {
            while ((input = sr.readLine()) != null) {
                if (i % MowerGroupQty != 0)
                    strPos = input;
                else {
                    commands = input;
                    Mower mower = new Mower();
                    Position pos = this.DeserializePosition(strPos);
                    lawn.DeployMower(mower, pos, commands);
                    strPos = "";

                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Position DeserializePosition(String strPos) {
        Position pos = new Position();
        if (strPos.length() >= MinStrPosLen) {
            String[] strPosition = strPos.split(Splitter);
            if (strPosition.length >= StrPostionElements) {
                pos.X = Integer.parseInt(strPosition[0]);
                pos.Y = Integer.parseInt(strPosition[1]);
                pos.Orientation = strPosition[2].charAt(0);
            }
        }
        return pos;
    }

    static public Lawn Deserialize(String fileName) {
        Lawn ret;
        LawnBuilder builder = new LawnBuilder();
        BufferedReader sr = null;
        try {
            sr = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ret = builder.DeserializeLawn(sr);
        return ret;
    }
}

