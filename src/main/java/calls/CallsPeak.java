package calls;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zorg9 on 25.02.2017.
 */
public class CallsPeak {
    public static List<CallTime> readCallsFromFile(File file) {
        List<CallTime> pairs = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                CallTime callTime = new CallTime();
                callTime.setStart(Long.valueOf(line.substring(0, 10)));
                callTime.setEnd(Long.valueOf(line.substring(11, 21)));
                pairs.add(callTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pairs;
    }

    public static String displayNumber(List<CallTime> pairs) {
        String text = "the file is empty";
        if (!pairs.isEmpty()) {
            text = "The peak for this call log is " + pairs.size() +
                    " simultaneous calls, that occurred between " + pairs.get(0).getStart() +
                    " and " + pairs.get(pairs.size() - 1).getEnd();
        }
        return text;
    }

}
