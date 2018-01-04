package Mowers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zorg9 on 05.03.2017.
 */
public class LawnTest {
    @Test
    public void deployMower() throws Exception {
        //adjust
        String command = "LFLFLFLFF";

        Position initial = new Position();
        initial.setX(1);
        initial.setY(2);
        initial.setOrientation('N');

        Mower mower = new Mower(initial);
        mower.setCommands(command);

        Lawn lawn = new Lawn();
        lawn.setHeight(2);
        lawn.setWidth(1);

        //act
        lawn.DeployMower(mower, initial, command);

        //assert
        for(Mower newMover: lawn.getMowers()) {
                assertTrue(newMover.equals(mower));
        }

    }

}