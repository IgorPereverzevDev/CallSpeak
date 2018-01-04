package CallsPeak;

import calls.CallTime;
import calls.CallsPeak;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;


/**
 * Created by zorg9 on 25.02.2017.
 */

public class CallsPeakTest {

    protected static List<CallTime> writeDataSetToFile(String text) {
        List<CallTime> pairs = new ArrayList<>();
        try {
            String path = new File("").getAbsolutePath();
            File newFile = new File(path + "/log.txt");
            OutputStream outputStream = new FileOutputStream(newFile);
            outputStream.write(text.getBytes());
            outputStream.close();
            pairs = CallsPeak.readCallsFromFile(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pairs;
    }

    @Test
    public void testDisplayNumberSeveralPair() {
        //adjust
        String expected = "The peak for this call log is 1 " +
                "simultaneous calls, that occurred between 1385718405 and 1385718491";
        String text = "1385718405:1385718491";
        List<CallTime> pairs = CallsPeakTest.writeDataSetToFile(text);


        //act
        String actual = CallsPeak.displayNumber(pairs);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void testDisplayNumberIsEmpty() {
        //adjust
        String expected = "the file is empty";
        String text = "";

        List<CallTime> pairs = CallsPeakTest.writeDataSetToFile(text);


        //act
        String actual = CallsPeak.displayNumber(pairs);


        //assert
        assertEquals(expected, actual);
    }


    @Test
    public void testDisplayNumberSeveralPairsInPrintLine() {
        //adjust
        String expected = "The peak for this call log is 5 " +
                "simultaneous calls, that occurred between 1385718405 and 1385718452";
        String text = "1385718405:1385718491\n" +
                "1385718407:1385718409\n" +
                "1385718408:1385718452\n" +
                "1385718408:1385718464\n" +
                "1385718413:1385718452\n";

        List<CallTime> pairs = CallsPeakTest.writeDataSetToFile(text);


        //act
        String actual = CallsPeak.displayNumber(pairs);

        //assert
        assertEquals(expected, actual);
    }

}