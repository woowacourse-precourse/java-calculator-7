package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public List<String> split(String str, String regex) {
        if (str.startsWith("//") && str.contains("\\n")) {
            str = str.substring(str.indexOf("\\n") + 2);
        }

        List<String> splitStrings = new ArrayList<>(Arrays.asList(str.split(regex)));
        
        return splitStrings;
    }
}
