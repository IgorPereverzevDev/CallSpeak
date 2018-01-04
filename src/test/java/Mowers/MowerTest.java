package Mowers;


import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by zorg9 on 05.03.2017.
 */
public class MowerTest {

    @Test
    public void testMoveToEmptyCommand() throws Exception {

        //adjust
        char command = 0x0;
        Mower mower = new Mower();
        Position expected = new Position();

        //act
        mower.MoveTo(command);

        //assert
        assertEquals(true, this.testMoveToCommandEqualsValue(expected, mower));
    }


    @Test
    public void testMoveToCommandLeft() throws Exception {

        //adjust
        char command = 0x4C;
        Position initial = new Position();
        initial.setOrientation('N');

        Position expected = new Position();
        expected.setOrientation('W');

        Mower mower = new Mower(initial);
        //act
        mower.MoveTo(command);


        //assert
        assertEquals(expected.getOrientation(), mower.getPos().getOrientation());
    }

    @Test
    public void testMoveToCommandRight() throws Exception {

        //adjust
        char command = 0x52;
        Position expected = new Position();
        expected.setOrientation('E');


        Position initial = new Position();
        initial.setOrientation('N');


        Mower mower = new Mower(initial);

        //act
        mower.MoveTo(command);


        //assert
        assertEquals(expected.getOrientation(), mower.getPos().getOrientation());
    }

    @Test
    public void testMoveToForward() throws Exception {

        //adjust
        char command = 0x46;

        Position borderBottomRight = new Position();
        borderBottomRight.setX(5);
        borderBottomRight.setY(5);

        Position expected = new Position();
        expected.setOrientation('N');
        expected.setY(1);

        Position initial = new Position();
        initial.setOrientation('N');


        Mower mower = new Mower(initial);
        mower.setUpperRight(borderBottomRight);

        //act
        mower.MoveTo(command);

        //assert
        assertEquals(true, this.testMoveToCommandEqualsValue(expected, mower));
    }


    @Test
    public void testRunMower() throws Exception {
        //adjust
        String command = "LFLFLFLFF";

        Position borderUpperRight = new Position();
        borderUpperRight.setX(5);
        borderUpperRight.setY(5);

        Position borderBottomLeft = new Position();
        borderBottomLeft.setX(0);
        borderBottomLeft.setY(0);

        Position initial = new Position();
        initial.setX(1);
        initial.setY(2);
        initial.setOrientation('N');

        Position expected = new Position();
        expected.setOrientation('N');
        expected.setX(1);
        expected.setY(3);

        Mower mower = new Mower(initial);
        mower.setCommands(command);
        mower.setUpperRight(borderUpperRight);
        mower.setBottomLeft(borderBottomLeft);

        //act
        mower.Run();

        //assert
        assertEquals(true, this.testMoveToCommandEqualsValue(expected, mower));

    }

    private boolean testMoveToCommandEqualsValue(Position expected, Mower mower) {
        if (mower.getPos().getX() != expected.getX()) {
            return false;
        }
        if (mower.getPos().getY() != expected.getY()) {
            return false;
        }
        if (mower.getPos().getOrientation() != expected.getOrientation()) {
            return false;
        }
        return true;
    }

}